package com.lotus.designpatterns.command;

/**
 * 具体命令者 - 1
 * @author otw
 *
 */
public class Close implements Action{
	
	private final Editor editor;
	
	public Close(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.close();
	}


}
