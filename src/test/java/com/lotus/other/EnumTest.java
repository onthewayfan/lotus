package com.lotus.other;


public enum EnumTest {
	
	RED("红色"),BLUE("蓝色"),GREEN("绿色");
	private String title;
	private EnumTest(String title) {
		this.title = title;
	}
	@Override
    public String toString() {
    	return this.title;
    }
}
