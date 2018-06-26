package com.lotus.designpatterns.command;

public class CommandTest {

	public static void main(String[] args) {
		
		Macro macro = new Macro();
				
		Editor editor = new Editor();
		
		//使用命令者构建
		macro.record(new Open(editor));
		macro.record(new Save(editor));
		macro.record(new Close(editor));
		
		//使用Lambada表达式构建
		macro.record(()->editor.open());
		macro.record(()->editor.save());
		macro.record(()->editor.close());
		
		//使用方法构建
		macro.record(editor::open);
		macro.record(editor::save);
		macro.record(editor::close);
		
		macro.run();
		
		
	}
	
}
