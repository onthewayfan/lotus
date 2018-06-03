package com.lotus.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InTest {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		byte[] data= new byte[1024];
		System.out.println("输入信息");
		int temp = 0;
		while((temp = in.read(data))!=-1) {
			bos.write(data,0,temp);
			if(temp<data.length) {
				break;
			}
		}
		System.out.println(new String(bos.toByteArray()));
		bos.close();
		in.close();
		
	}

}
