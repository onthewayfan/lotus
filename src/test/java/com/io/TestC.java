package com.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestC {
	public static void main(String[] args) throws Exception {
		String msg = "how area you!";
		
		InputStream inputStream = new ByteArrayInputStream(msg.getBytes());
		
		OutputStream outputStream = new ByteArrayOutputStream();
		int temp = 0;
		while((temp=inputStream.read())!=-1) {
			outputStream.write(Character.toUpperCase(temp));
		}
		//System.out.println(outputStream);
		inputStream.close();
		outputStream.close();
		
		File[] files = new File[] {
				new File("d:"+File.separator+"data-a.txt"),
				new File("d:"+File.separator+"data-b.txt"),
				new File("d:"+File.separator+"使用须知.txt")
		};
		StringBuffer stringBuffer = new StringBuffer();
		for (File file : files) {
			//System.out.println(readFile(file));
			stringBuffer.append(readFile(file)+"\n");
		}
		System.out.println(stringBuffer);
		OutputStream outputStream2 =new FileOutputStream(new File("d:"+File.separator+"data.txt"));
		outputStream2.write(new String(stringBuffer).getBytes());
		outputStream2.close();
		
	}
	
	public static String readFile(File file) throws Exception {
		if(file.exists()) {
			InputStream inputStream = new FileInputStream(file);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] data = new byte[10];
			int temp = 0;
			while((temp=inputStream.read(data))!=-1) {
				byteArrayOutputStream.write(data,0,temp);
			}
			byteArrayOutputStream.close();
			inputStream.close();
			return new String(byteArrayOutputStream.toByteArray());
		}
		return null;
		
	}

}
