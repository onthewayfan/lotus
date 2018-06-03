package com.lotus.classic;

import java.util.Scanner;

public class GoldbachClass {
	//哥德巴赫猜想---任何一个大于或等于6的偶数均可表示为两个素数之和
	//素数--又称质数 大于1的自然数中，处理1和他本身以外不再有其它因数，这样的数称为素数
	//测试哥德巴赫猜想
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GoldbachClass goldbachClass = new GoldbachClass();//创建类对象
		Scanner scanner = new Scanner(System.in);//创建输入流对象
		System.out.println("输入需要验证的数（n>6）");
		int n;
		while(true){
			n=scanner.nextInt();
			goldbachClass.getGoldbachNum(n);
		}
	
	}
	/**
	 * 判断是不是素数
	 * @param n
	 * @return
	 */
	public boolean isPrimeNum(int n) {
		int i;
		for (i = 2; i < n/2; i++) {
			if(n%i==0) {
				break;
			}
		}
		if(i>=n/2) {
			return  true;
		}
		return false;
//		boolean flag =true;
//		if(n<2) {//素数大于1
//			flag = false;
//		}else {
//			for (int i = 2; i < Math.sqrt(n); i++) {
//				if(n%i==0) {//若能整除，则说明不是素数
//					flag = false;
//					break;
//				}
//			}
//		}
//		return flag;
	}
	//验证哥德巴赫猜想
	public void getGoldbachNum(int n) {
		if(n<6||n%2==1) {
			System.out.println(n+"不满足哥德巴赫猜想！");
			return ;
		}
		for (int i = 2; i < n-1; i++) {
			if(this.isPrimeNum(i)&&this.isPrimeNum(n-i)) {
				System.out.println(n+"="+i+"+"+(n-i));
				break;
			}		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
