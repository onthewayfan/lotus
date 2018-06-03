/*package com.hadoop;

import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HadoopTest {
	public static void main(String[] args) {
	
		Configuration configuration = new Configuration();
		FileSystem fileSystem = null;
		try {
			fileSystem = FileSystem.get(URI.create("127.0.0.1:9000"), configuration);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path path = new Path("");
		FSDataInputStream fsDataOutputStream = null;
		try {
			fsDataOutputStream = fileSystem.open(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
*/