package com.lotus.designpatterns.command;

/**
 * 
 * 命令接收者
 *    ：执行实际任务
 * @author otw
 *
 */
public class Editor {

	public void save(){System.out.println(" perform save !");};
	
	public void open(){System.out.println(" perform open !");};
	
	public void close(){System.out.println(" perform close !");};
	
}
