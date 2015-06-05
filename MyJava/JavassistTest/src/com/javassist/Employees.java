package com.javassist;

public class Employees {
    private int empno;
    private String ename;
    public Employees(){
	
    }
    public Employees(int empno, String ename) {
	super();
	this.empno = empno;
	this.ename = ename;
    }
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    
}
