package cn.ChainOR;
/**
 *总经理
 * @author YR
 *
 */
public class GeneralManager extends Leader{

    GeneralManager(String name) {
	super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
	if(request.getLeaveDay()<30){
	    System.out.println("请假人："+request.getReqName()+"\t请假时间："+request.getLeaveDay()+
		    "\t请假理由："+request.getReqResion()
		    );
	    System.out.println("总经理："+this.name+"，审批通过！");
	}else{
	    System.out.println("审批不通过，莫非你想辞职！");
	}
    }

}
