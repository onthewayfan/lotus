package com.lotus.designpatterns.command;
/**
 * 具体命令者 - 2
 * @author otw
 *
 */
public class Open implements Action{
	
	private final Editor editor;
	
	public Open(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.open();
	}


}
