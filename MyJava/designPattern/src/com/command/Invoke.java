package com.command;

public class Invoke {
    /**
     * ������
     */
    
    private Command command;
    public Invoke(Command command){
	this.command = command;
    }
    
    void call(){
	command.execute();
    }
}
