package com.lotus.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
public class TestDemo {
	public static void main(String[] args) throws Exception {
		//1.
		File file = new File("d:"+File.separator+"test.txt");
		if(!file.getParentFile().exists()) {
			file.mkdirs();
		}
		//2.通过子类实例化，只能进行文件处理
		OutputStream outputStream = new FileOutputStream(file,true);
		//3.进行文件输出处理操作
		String msg = "www.baidu.com\r\n"; 
		outputStream.write(msg.getBytes());
		//4.关闭流
		outputStream.close(); 
		
		//自动创建文件
		
		
		if(file.exists()) {
			InputStream inputStream = new FileInputStream(file);
			byte[] data = new byte[1024];
			int len = inputStream.read(data);
			inputStream.close();
			System.out.println("读取内容:"+new String(data,0,len));
			
		}
		
		
		
		
	}

}
