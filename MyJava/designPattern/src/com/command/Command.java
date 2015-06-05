package com.command;

public interface Command {
    
    void execute();
}

class Concentrate implements Command{
    private Receiver receiver;
    
    Concentrate(Receiver receiver){
	this.receiver = receiver;
    }
    @Override
    public void execute() {
	receiver.action();
    }
    
}