package com.mediator;

public class Market implements Department{
    private Mediator m ;
    public Market(Mediator m) {
	super();
	this.m = m;
	m.register("market", this);
    }

    @Override
    public void selfAction() {
	System.out.println("市场部，市场调研");
    }

    @Override
    public void outAction() {
	System.out.println("汇报，指定研发项目");
    }

}
