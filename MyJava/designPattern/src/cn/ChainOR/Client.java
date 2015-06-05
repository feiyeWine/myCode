package cn.ChainOR;

public class Client {
    
    public static void main(String[] args) {
	Leader a = new Director("张三");
	Leader b = new Manager("李四");
	Leader c = new GeneralManager("王五");
	
	//责任链关系
	a.setNextLeader(b);
	b.setNextLeader(c);
	
	LeaveRequest req = new LeaveRequest("小李", 5, "结婚旅行");
	a.handleRequest(req);
    }
}
