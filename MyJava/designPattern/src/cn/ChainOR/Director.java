package cn.ChainOR;
/**
 *����
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
	    System.out.println("����ˣ�"+request.getReqName()+"\t���ʱ�䣺"+request.getLeaveDay()+
		    "\t������ɣ�"+request.getReqResion()
		    );
	    System.out.println("���Σ�"+this.name+"������ͨ����");
	}else{
	    this.nextLeader.handleRequest(request);
	}
    }

}
