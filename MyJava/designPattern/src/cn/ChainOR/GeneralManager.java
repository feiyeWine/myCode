package cn.ChainOR;
/**
 *�ܾ���
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
	    System.out.println("����ˣ�"+request.getReqName()+"\t���ʱ�䣺"+request.getLeaveDay()+
		    "\t������ɣ�"+request.getReqResion()
		    );
	    System.out.println("�ܾ���"+this.name+"������ͨ����");
	}else{
	    System.out.println("������ͨ����Ī�������ְ��");
	}
    }

}
