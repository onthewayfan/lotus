package com.lotus.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;

class Temp{}

public class ReflectionTest {

public static void main(String[] args) throws Exception {
	//testRef();
	//testMethod();
	 testClass();
}
@Deprecated	
public static void testMethod() throws Exception {
	Class<?> cls = String.class;
//	Method[] mets = cls.getMethods();
//	for (Method method : mets) {
//		System.out.println(method);
//	}
	Object object= cls.newInstance();
	Method setMethod = cls.getMethod("split",String.class);
	String[] obj = (String[])setMethod.invoke(object,",");
	System.out.println(Arrays.toString(obj));
}

public static void testClass() throws Exception {
	Class<?> cls = String.class;
	Object object= cls.newInstance();
	Field[] field1 = cls.getFields();//取得父类属性
	Field[] field2 = cls.getDeclaredFields();//取得本类属性
	for (Field field : field1) {
		System.out.println(field);
	}
	System.out.println("---------------------------------------");
    for (Field field : field2) {
    	System.out.println(field);
	}
    Field field3 = cls.getDeclaredField("CASE_INSENSITIVE_ORDER");//取得本类属性
    field3.setAccessible(true);//取消封装（public,private,protected）
    try {
        field3.set(object, "test");
        System.out.println(field3.get(object));
	} catch (Exception e) {
		e.printStackTrace();
	}
    System.out.println("Name:"+field3.getType().getName());//包 类
    System.out.println("SimpleName:"+field3.getType().getSimpleName());//类
    
}


public static void testRef() throws Exception {
	Date date =new Date();
	System.out.println(date.getClass());
	//第一种实例化模式
	Class<?> cls= new Date().getClass();
	System.out.println(cls.getName());
	//类.class
	Class<?> cls1 = Date.class;
	System.out.println(cls1.getName());
	//forName 方法
	Class<?> cls2 = Class.forName("java.util.Date");
	System.out.println(cls2.getName());
	//反射实例化对象
	Object obj = cls2.newInstance();
	System.out.println(obj);
	
	
	Class<?> cls3 = String.class;
	System.out.println(cls3.getPackage().getName());
	System.out.println(cls3.getSuperclass().getName());
	Class<?>[] clss = cls3.getInterfaces();//获取某一类继承接口
	for (Class<?> class1 : clss) {
		System.out.println(class1.getName());
	}
	//获取类中的垢找方法
	Constructor<?>[] constructors = cls3.getConstructors();
	for (Constructor<?> constructor : constructors) {
		System.out.println(constructor);
		System.out.print(Modifier.toString(constructor.getModifiers()));
		System.out.print(" "+constructor.getName());
		System.out.print("(");
		Class<?>[] types= constructor.getParameterTypes();
		for (int i = 0; i < types.length; i++) {
			System.out.print(types[i].getName());
			if(i<types.length-1) {
				System.out.print(",");
			}
		}
		System.out.print(")");
		Class<?>[] exps= constructor.getExceptionTypes();
		if(exps.length!=0) {
			System.out.print(" throws");
		}
		for (int i = 0; i < exps.length; i++) {
			System.out.print(exps[i].getName());
			if(i<exps.length-1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}
	
	System.out.println("实例化:"+cls3.newInstance());
	
	Constructor<?> constructors1 = cls3.getConstructor(String.class);
	
	System.out.println("实例化1:"+constructors1);
}

}

