package com.secondwork;
/**
 * ���ͼ�ⷨ
 * @author YR
 *
 */
public class Test5 {
    private static int  n = 16;
    private static int[][] arr= {
            {0,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {5,0,0,1,3,6,0,0,0,0,0,0,0,0,0,0},
            {3,0,0,0,8,7,6,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,6,8,0,0,0,0,0,0,0},
            {0,3,8,0,0,0,0,3,5,0,0,0,0,0,0,0},
            {0,6,7,0,0,0,0,0,3,3,0,0,0,0,0,0},
            {0,0,6,0,0,0,0,0,8,4,0,0,0,0,0,0},
            {0,0,0,6,3,0,0,0,0,0,2,2,0,0,0,0},
            {0,0,0,8,5,3,8,0,0,0,0,1,2,0,0,0},
            {0,0,0,0,0,3,4,0,0,0,0,3,3,0,0,0},
            {0,0,0,0,0,0,0,2,0,0,0,0,0,3,5,0},
            {0,0,0,0,0,0,0,2,1,3,0,0,0,5,2,0},
            {0,0,0,0,0,0,0,0,2,3,0,0,0,6,6,0},
            {0,0,0,0,0,0,0,0,0,0,3,5,6,0,0,4},
            {0,0,0,0,0,0,0,0,0,0,5,2,6,0,0,3},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,4,3,0},
    };
    
    //ʹ���������㷨����ͼ�����·��
    public static void shortPath(int arr[][]){
	int i = 1;
	int sum = 0;
	int temp = 0;
	int p [] = new int[n];
	int len[] = new int[n];
	while(i<n){
	    int total = Integer.MAX_VALUE;
	    for(int j =0;j<i;j++){
		if(arr[j][i]!=0){
	//�ж��Ƿ���ڵ��ýڵ��·��������������·�����ȸ���
		    if(total>(arr[j][i]+len[j])){
			total = arr[j][i]+len[j];
			temp = j;
		    }
		    len[i] = total;
		    sum = total;
		    p[i] = temp;
		}
	    }
	    i++;
	}
	int path[] = new int[7];//��ͼ����Ϊ7��
	path[0] = 0;
	path[6] = 15;
	for(int k = 5;k>=1;k--){
	    path[k] = p[path[k+1]];
	}
	System.out.println("���·��Ϊ��");
	for(int m = 0;m<6;m++){
	    System.out.print(path[m]+"->");
	}
	System.out.println(path[6]);
	System.out.println("��С����Ϊ��"+sum);
    }
    public static void main(String[] args) {
	
	shortPath(arr);
	
    }
}
