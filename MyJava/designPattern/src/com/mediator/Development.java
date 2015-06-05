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
	System.out.println("�з������н���Ŀ");
    }

    @Override
    public void outAction() {
	System.out.println("�㱨����Ҫ�ʽ�֧��");
	m.command("finacial", "����Ǯ");
    }

}
