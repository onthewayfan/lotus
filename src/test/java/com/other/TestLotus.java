package com.other;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class TestLotus {

	public static void main(String[] args) {
		double a= Math.sqrt(9);
		System.out.println(a);
		System.out.println("total:"+2+4);
		System.out.println("total:"+(2+4));
		System.out.println("/:"+(13/4));
		//按位补码
		byte b = ~11;
	    System.out.println(b);
	   
		int[] rows = { 1, 2, 3, 4 };
		int[] columns = { 5, 6, 7, 8 };
		rowLoop: for (int r = 0; r < rows.length; r++) { // 一个标注循环
			colLoop: for (int c = 0; c < columns.length; c++) { // 另一个
				break rowLoop; // 使用标注
			}
		}
	    
	    int c = 7;
	    int d = 1;
	    System.out.println(c&d);
	    int f = 3;
	    double g = 0d;
	    try {
	    	g=factorial(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println(g);
	    
	    System.out.println(max(0,1,2,3,4,56,78,0));
	    
	    Class<?> typeInt = int.class;
	    System.out.println(typeInt);
	    
	    Runnable r = () -> System.out.println("Hello World");
	    System.out.println(r);
	
	    
	    String[] string = new String[]{"how","do","you","do"};
	    for (String string2 : string) {
			System.out.println(string2);
		}
	    
	    boolean[] bo = new boolean[3];
	    for (boolean e : bo) {
			System.out.println(e);
		}
	    System.out.println("int-max:"+Integer.MAX_VALUE+",int-min:"+Integer.MIN_VALUE);
	    
	    out.println("abc ha ha ");
	    
		Map<String, Object> user = new HashMap<String, Object>();
		for (int i = 0; i < 5; i++) {
			user.put("name"+i, i);
		}
		user.forEach((k,v)-> System.out.println("====== key : " + k + "; value : " + v));
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 5; i++) {
			list.add(i+"test");
		}
	    list.forEach((l)->out.println(l));
	    
	    
	    
	    Collection collection = new LinkedList<>();
	    Set set = new HashSet<>();
	    List list2 = new ArrayList<>();
	    Map map = new Hashtable<>();
	    Iterator iterator = list2.iterator();
	   
	    Collection<String> aStrings = Arrays.asList("one","two");
	    Collection<String> bStrings = Collections.singleton("theree");
	    for (String string2 : aStrings) {
			System.out.println(string2);
		}	    
	    for (String string2 : bStrings) {
			System.out.println(string2);
		}
	    
	    List<String> list3 = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list3.add(i+"test3");
		}
	    for(Iterator<String> i = list3.iterator();i.hasNext();){
	    	System.out.println(i.next());
	    }
	    
	    String pStr = "\\d"; // 一个数字
	    String text = "Apollo 13";
	    Pattern p = Pattern.compile(pStr);
	    Matcher m = p.matcher(text);
	    System.out.print(pStr + " matches " + text + "? " + m.find());
	    System.out.println(" ; match: " + m.group());
	    
	    byte byte1 = -100;
	    int int1 =  Math.abs(byte1);
	    System.out.println(int1);
	    System.out.println(Math.log10(100));
	    System.out.println(Math.log(16));
	    System.out.println(Math.pow(2, 3));
	    System.out.println(Math.exp(8));
	    
	}
	
	
	public static double factorial(int x) {
		if (x < 0)
		throw new IllegalArgumentException("x must be >= 0");
		double fact;
		for(fact=1.0; x > 1; fact *= x, x--)
		/* empty */ ; // 注意，使用的是空语句
		return fact;
		}
	
	public static int  max(int first,int... rest){
		int max = first;
		System.out.println(rest.length);
		for (int i : rest) {
			if (i>=max) {
				max=i;
			}
			System.out.println(i);
		}
		return max;
	}
	
}
