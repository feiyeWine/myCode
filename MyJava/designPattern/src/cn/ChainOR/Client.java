package cn.ChainOR;

public class Client {
    
    public static void main(String[] args) {
	Leader a = new Director("����");
	Leader b = new Manager("����");
	Leader c = new GeneralManager("����");
	
	//��������ϵ
	a.setNextLeader(b);
	b.setNextLeader(c);
	
	LeaveRequest req = new LeaveRequest("С��", 5, "�������");
	a.handleRequest(req);
    }
}
