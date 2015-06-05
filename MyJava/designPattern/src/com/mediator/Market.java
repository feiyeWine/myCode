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
	System.out.println("�г������г�����");
    }

    @Override
    public void outAction() {
	System.out.println("�㱨��ָ���з���Ŀ");
    }

}
