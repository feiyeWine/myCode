package cn.ChainOR;
/**
 * 经理
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
	    System.out.println("请假人："+request.getReqName()+"\t请假时间："+request.getLeaveDay()+
		    "\t请假理由："+request.getReqResion()
		    );
	    System.out.println("经理："+this.name+"，审批通过！");
	}else{
	    this.nextLeader.handleRequest(request);
	}
    }

}
