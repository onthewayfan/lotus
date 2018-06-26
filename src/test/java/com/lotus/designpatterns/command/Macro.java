package com.lotus.designpatterns.command;
/**
 * 命令发起者
 *    ：控制一个或多个命令执行者的信息
 * @author otw
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Macro {

	private final List<Action> actions;
	
	public Macro() {
		this.actions = new ArrayList<>();
	}
	
	public void record(Action action) {
		actions.add(action);
	}
	
	public void run() {
		actions.forEach(Action::perform);
		actions.clear();
	}
	
}
