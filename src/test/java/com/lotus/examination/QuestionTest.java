package com.lotus.examination;

public class QuestionTest {
	public static void main(String[] args) throws Exception{
		int i= 9;
		switch (i) {
		default:
			System.out.println("default");
			//break;
		case 0:
			System.out.println("zero");
			break;
		case 1:System.out.println("one");
		case 2:System.out.println("two");
		}
		
	}

}
class Base{
	private void amethod(int iBase) {
		System.out.println("Base.amethod");
	}
}
class Over extends Base{
	public static void main(String[] args) {
		Over o = new Over();
		int iBase = 0;
		o.amethod(iBase);
	}
	public void amethod(int iBase) {
		System.out.println("Over.amethod");
	}
}

class Test{
	public int aMethod() {
		//static int i=0;
		int i=0;
		i++;
		return i;
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.aMethod();
		int j= test.aMethod();
		System.out.println(j);
	}
	
	
	
}