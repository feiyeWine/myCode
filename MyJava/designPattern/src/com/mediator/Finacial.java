package com.mediator;

public class Finacial implements Department{
    private Mediator m ;
    public Finacial(Mediator m) {
	super();
	this.m = m;
	m.register("finacial", this);
    }

    @Override
    public void selfAction() {
	System.out.println("财务部，管理资金");
    }

    @Override
    public void outAction() {
	System.out.println("汇报，提供资金支持资金支持");
    }

}
