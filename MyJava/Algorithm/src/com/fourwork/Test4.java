package com.fourwork;

public class Test4 {
    private double[] p, w;// 分别代表价值和重量
    private int n;
    private double c;
    private double bestp;
    private double cp;
    private double cw;
    private int x[]; // 记录可选的物品
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
	if (i > n) { // 判断是否到达了叶子节点
	    if (cp > bestp) {
		for (int j = 0; j < x.length; j++)
		    x[j] = cx[j];
		bestp = cp;
	    }
	    return;
	}
	if (cw + w[i] <= c) {// 搜索右子树
	    cx[i] = 1;
	    cw += w[i];
	    cp += p[i];
	    backtrack(i + 1);
	    cw -= w[i];
	    cp -= p[i];
	}
	cx[i] = 0;
	backtrack(i + 1); // 检查左子树
    }

    void printResult() {
	
	for (int i = 0; i < x.length; i++) {
	    if(x[i]==1){
		System.out.print((char)(65+i)+"\t");
	    }
	}
    }

    public static void main(String[] args) {
	double p[] = { 200,180,225,200,50 };//价值
	double w[] = {50,30,45,25,5 };//重量
	int maxWeight = 100;
	Test4 t = new Test4(p, w, maxWeight);
	t.knapsack(); // 回溯搜索
	System.out.println("回溯法");
	System.out.println("物品个数:n="+p.length);
	System.out.println("背包容量:c="+maxWeight);
	System.out.println("物品重量:50,30,45,25,5");
	System.out.println("物品价值:200,180,225,200,50");
	System.out.println("最优值:=" + t.bestp);
	System.out.print("装入背包中的物品是: ");
	t.printResult();
    }
}
