package com.observer2;

public class Client {
    public static void main(String[] args) {
	//����Ŀ�����
	ConcreteObserver subject = new ConcreteObserver();
	//�����۲��߶���
	ObserverA obs1 = new ObserverA();
	ObserverA obs2 = new ObserverA();
	ObserverA obs3 = new ObserverA();
	
	subject.addObserver(obs1);
	subject.addObserver(obs2);
	subject.addObserver(obs3);
	subject.set(300);
	System.out.println(obs1.getMyState());
	System.out.println(obs2.getMyState());
	System.out.println(obs3.getMyState());
	
    }
}