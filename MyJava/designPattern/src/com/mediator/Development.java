package com.mediator;

public class Development implements Department{
    private Mediator m ;
    public Development(Mediator m) {
	super();
	this.m = m;
	m.register("development", this);
    }

    @Override
    public void selfAction() {
	System.out.println("研发部，承接项目");
    }

    @Override
    public void outAction() {
	System.out.println("汇报，需要资金支持");
	m.command("finacial", "给我钱");
    }

}
