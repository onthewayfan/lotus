package com.lotus.designpatterns.command;
/**
 * 具体命令者 - 3
 * @author otw
 *
 */
public class Save implements Action{
	
	private final Editor editor;
	
	public Save(Editor editor) {
		this.editor = editor;
	}
	
	@Override
	public void perform() {
		editor.save();
	}


}
