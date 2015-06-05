package com.fourwork;

public class Test4 {
    private double[] p, w;// �ֱ�����ֵ������
    private int n;
    private double c;
    private double bestp;
    private double cp;
    private double cw;
    private int x[]; // ��¼��ѡ����Ʒ
    private int[] cx;

    public Test4(double pp[], double ww[], double cc) {
	this.p = pp;
	this.w = ww;
	this.n = pp.length - 1;
	this.c = cc;
	this.cp = 0;
	this.cw = 0;
	this.bestp = 0;
	x = new int[ww.length];
	cx = new int[pp.length];
    }

    void knapsack() {
	backtrack(0);
    }

    void backtrack(int i) {
	if (i > n) { // �ж��Ƿ񵽴���Ҷ�ӽڵ�
	    if (cp > bestp) {
		for (int j = 0; j < x.length; j++)
		    x[j] = cx[j];
		bestp = cp;
	    }
	    return;
	}
	if (cw + w[i] <= c) {// ����������
	    cx[i] = 1;
	    cw += w[i];
	    cp += p[i];
	    backtrack(i + 1);
	    cw -= w[i];
	    cp -= p[i];
	}
	cx[i] = 0;
	backtrack(i + 1); // ���������
    }

    void printResult() {
	
	for (int i = 0; i < x.length; i++) {
	    if(x[i]==1){
		System.out.print((char)(65+i)+"\t");
	    }
	}
    }

    public static void main(String[] args) {
	double p[] = { 200,180,225,200,50 };//��ֵ
	double w[] = {50,30,45,25,5 };//����
	int maxWeight = 100;
	Test4 t = new Test4(p, w, maxWeight);
	t.knapsack(); // ��������
	System.out.println("���ݷ�");
	System.out.println("��Ʒ����:n="+p.length);
	System.out.println("��������:c="+maxWeight);
	System.out.println("��Ʒ����:50,30,45,25,5");
	System.out.println("��Ʒ��ֵ:200,180,225,200,50");
	System.out.println("����ֵ:=" + t.bestp);
	System.out.print("װ�뱳���е���Ʒ��: ");
	t.printResult();
    }
}
