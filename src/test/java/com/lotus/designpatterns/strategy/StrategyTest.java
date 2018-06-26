package com.lotus.designpatterns.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class StrategyTest {
	
	public static void main(String[] args) {
		
		Path inFile = FileSystems.getDefault().getPath("", "build.gradle");
		File outFile = new File("tmp.zip");
		
        //使用具体策略初始化
		Compressor zipCompressor = new Compressor(new ZipCompressStrategy());
		Compressor gzipCompressor = new Compressor(new GzipCompressStrategy());
		
		//使用方法引用初始化
		Compressor zipCompressor1 = new Compressor(ZipOutputStream::new);
		Compressor gzipCompressor1 = new Compressor(GZIPOutputStream::new);
		
		try {
			
			//输出 压缩文件内容
//			Scanner sc = new Scanner(inFile);
//			while (sc.hasNext()) {
//				System.out.println(sc.nextLine());
//			}
			
			//zipCompressor.compress(inFile, outFile);
			zipCompressor1.compress(inFile, outFile);
			//gzipCompressor.compress(inFile, outFile);
			//gzipCompressor1.compress(inFile, new File("tmp.gzip"));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
