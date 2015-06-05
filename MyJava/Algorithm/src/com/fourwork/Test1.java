package com.fourwork;

import java.util.Scanner;

/**
 * 
 * @author YR
 * �༶��131211 ���������� ѧ�ţ�13121073 practice4
 * ���ԣ�
4 5 1
1 2 2
2 4 2
1 4 2
1 3 6
4 3 1
 */
public class Test1{
    private static int nodeNum,edgeNum,original;//�������������ߵ�
    private final static int MAX = Integer.MAX_VALUE;
    private final static int N =  20;
    
    private static Edge[] edge = new Edge[N];
    private static int dis[] = new int[N];
    private static int pre[] = new int[N];
    
    public static boolean bellmanFord(){
	boolean flag = true;
	//��ʼ��
	for(int i = 1;i<=nodeNum;i++){
	    dis[i] = (i==original?0:MAX);
	}
	//�ɳ�
	for(int i =1;i<=nodeNum-1;i++){
	    for(int j =1;j<=edgeNum;j++){
		if(dis[edge[j].v]>dis[edge[j].u]+edge[j].cost){
		    dis[edge[j].v] = dis[edge[j].u]+edge[j].cost;
		    pre[edge[j].v] = edge[j].u;
		}
	    }
	}
	//�ж��Ƿ��и�Ȩ��·
	for(int i =1;i<=edgeNum;i++){
	    if(dis[edge[i].v]>dis[edge[i].u]+edge[i].cost){
		flag = false;
		break;
	    }
	}
	return flag;
    }
    static void printPath(int root){
	//ǰ��
	while(root!=pre[root]){
	    System.out.print(root+"<����");
	    root = pre[root];
	}
	if(root == pre[root]){
	    System.out.print(root);
	}
    }
    public static void main(String[] args) {
	for(int i = 0;i<N;i++){
	    edge[i] = new Edge();
	}
	
	Scanner sc = new Scanner(System.in);
	if (sc.hasNext()) {
	    nodeNum = sc.nextInt();
	    edgeNum = sc.nextInt();
	    original = sc.nextInt();
	}
	pre[original] = original;
	for(int i =1;i<=edgeNum;i++){
	    if (sc.hasNext()) {
		edge[i].u = sc.nextInt();
		edge[i].v = sc.nextInt();
		edge[i].cost = sc.nextInt();
	    }
	}
	if(bellmanFord()){
	    for(int i = 1;i<=nodeNum;i++){
		System.out.print("��С���ۣ�"+dis[i]+" ·��:");
		printPath(i);
		System.out.println();
	    }
	}
	else{
	   System.out.println("���ڸ�Ȩ��·"); 
	}
	sc.close();
    }
}

class Edge{
    int u, v, cost;
}
