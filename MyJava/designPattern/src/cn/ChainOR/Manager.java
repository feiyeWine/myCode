package cn.ChainOR;
/**
 * ����
 * @author YR
 *
 */
public class Manager extends Leader{

    Manager(String name) {
	super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
	if(request.getLeaveDay()<10){
	    System.out.println("����ˣ�"+request.getReqName()+"\t���ʱ�䣺"+request.getLeaveDay()+
		    "\t������ɣ�"+request.getReqResion()
		    );
	    System.out.println("����"+this.name+"������ͨ����");
	}else{
	    this.nextLeader.handleRequest(request);
	}
    }

}
