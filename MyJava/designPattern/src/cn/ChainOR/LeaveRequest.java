package cn.ChainOR;

public class LeaveRequest {
    
    private String reqName;
    private int leaveDay;
    private String reqResion;
    
    
    public LeaveRequest(String reqName, int leaveDay, String reqResion) {
	super();
	this.reqName = reqName;
	this.leaveDay = leaveDay;
	this.reqResion = reqResion;
    }
    public String getReqName() {
        return reqName;
    }
    public void setReqName(String reqName) {
        this.reqName = reqName;
    }
    public int getLeaveDay() {
        return leaveDay;
    }
    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }
    public String getReqResion() {
        return reqResion;
    }
    public void setReqResion(String reqResion) {
        this.reqResion = reqResion;
    }
    
}
