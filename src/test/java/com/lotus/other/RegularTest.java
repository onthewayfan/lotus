package com.lotus.other;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {
	
	public static void main(String[] args) {
          String str= "INSERT INTO member(mid,age,name) VALUES (#{member.mid},#{member.age},#{member.name})";
          String regex= "#\\{[a-zA-Z_0-9\\.]+\\}";
          Pattern pat = Pattern.compile(regex);
          Matcher mat = pat.matcher(str);
          while(mat.find()) {
        	  System.out.println(mat.group(0));
          }
	}
}
