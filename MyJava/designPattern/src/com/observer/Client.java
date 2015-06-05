package com.observer;

public class Client {
    public static void main(String[] args) {
	//目标对象
	ConcreteSubject subject = new ConcreteSubject();
	//创建多个观察者
	ObserverA obs1 = new ObserverA();
	ObserverA obs2 = new ObserverA();
	ObserverA obs3 = new ObserverA();
	//让这三个观察者添加到subject对象的观察者队伍中
	subject.registerObserver(obs1);
	subject.registerObserver(obs2);
	subject.registerObserver(obs3);
	//改变观察者状态
	subject.setState(3000);
	//测试观察者状态是否发生变化s
	System.out.println(obs1.getMyState());
	System.out.println(obs2.getMyState());
	System.out.println(obs3.getMyState());
    }
}
