package com.lotus.io;

import java.io.File;

public class TestIO{
	public static void main(String[] args) throws Exception {
		// 五个类 File InputStream OutputStream Reader Writer，一个接口 Serializable
		File file = new File("d:"+File.separator+"test"+File.separator+"abc"+File.separator+"test.txt");
		if(!file.getParentFile().exists()) {
			file.mkdirs();//创建父级目录（多）
		}
		if(file.exists()) {
			file.delete();
		}else {
			file.createNewFile();
		}
		//列出目录下子目录信息
		
//		if(file1.exists()&&file1.isDirectory()) {
//			File[] files = file1.listFiles();
//			for (File file2 : files) {//列出全部的目录中的内容
//				System.out.println(file2.getPath());
//			}
//		}
		new Thread(()->{
			File file1 = new File("d:"+File.separator);
			listDir(file1);
		},"列出线程").start();
		System.out.println("开始文件列出..........................");
		
	}
	
	public static void listDir(File file) {
		if(file.isDirectory()) {
			File[] result = file.listFiles();
			if(result!=null) {
				for (File file2 : result) {
					listDir(file2);//继续列出
				}
			}
		}else {
			System.out.println(file);
		}
	}
	

}
