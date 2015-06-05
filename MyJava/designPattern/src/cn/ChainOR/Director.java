package cn.ChainOR;
/**
 *主任
 * @author YR
 *
 */
public class Director extends Leader{

    Director(String name) {
	super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
	if(request.getLeaveDay()<3){
	    System.out.println("请假人："+request.getReqName()+"\t请假时间："+request.getLeaveDay()+
		    "\t请假理由："+request.getReqResion()
		    );
	    System.out.println("主任："+this.name+"，审批通过！");
	}else{
	    this.nextLeader.handleRequest(request);
	}
    }

}
