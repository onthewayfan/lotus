package com.lotus.designpatterns.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Compressor {
	
	private final CompressionStrategy compressionStrategy;
	
	public Compressor(CompressionStrategy compressionStrategy) {
		this.compressionStrategy =  compressionStrategy;
	}
	

	public void compress(Path inFile,File outFile) throws IOException {
		try(OutputStream outputStream = new FileOutputStream(outFile)){
			OutputStream newOutputStream = null;
			try {
				newOutputStream = compressionStrategy.compress(outputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Files.copy(inFile, newOutputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	}

}
