package com.fourwork;


public class Test3 {
    static int[] x = new int[100];
    static boolean place(int k)//����ʺ�k������x[k]���Ƿ�����ͻ
    {
        for(int i=1;i<k;i++)
            if(x[k]==x[i]||Math.abs(k-i)==Math.abs(x[k]-x[i]))
                return false;
            return true;
    }

    static void queue(int n)
    {
	System.out.println("���ֿ��ܽ�Ϊ��");
        int i,k;
        for(i=1;i<=n;i++)
            x[i]=0;
        k=1;
        int m =0;
        while(k>=1)
        {
            x[k]=x[k]+1;   //����һ�з��õ�k���ʺ�
            while(x[k]<=n&&!place(k))
                x[k]=x[k]+1;//������һ��
            if(x[k]<=n&&k==n)//�õ�һ�����
            {	m++;
                for(i=1;i<=n;i++)
                    System.out.printf("%5d",x[i]);
                System.out.print("\n");
            //return;//��return��ֻ�������һ�ֽ⣬����return����Լ������ݣ����ȫ���Ŀ��ܵĽ�
            }
            else if(x[k]<=n&&k<n)
                k=k+1;//������һ���ʺ�
            else
            {
                x[k]=0;//����x[k],����
                k=k-1;
            }
        }
        System.out.println("�ܹ��У�"+m+"����");
    }
    public static void main(String[] args) {
	int n  = 8;
	System.out.println("�ʺ����Ϊ��"+n);
	queue(n);
    }
}
