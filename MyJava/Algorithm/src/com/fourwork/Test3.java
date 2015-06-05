package com.fourwork;


public class Test3 {
    static int[] x = new int[100];
    static boolean place(int k)//考察皇后k放置在x[k]列是否发生冲突
    {
        for(int i=1;i<k;i++)
            if(x[k]==x[i]||Math.abs(k-i)==Math.abs(x[k]-x[i]))
                return false;
            return true;
    }

    static void queue(int n)
    {
	System.out.println("各种可能解为：");
        int i,k;
        for(i=1;i<=n;i++)
            x[i]=0;
        k=1;
        int m =0;
        while(k>=1)
        {
            x[k]=x[k]+1;   //在下一列放置第k个皇后
            while(x[k]<=n&&!place(k))
                x[k]=x[k]+1;//搜索下一列
            if(x[k]<=n&&k==n)//得到一个输出
            {	m++;
                for(i=1;i<=n;i++)
                    System.out.printf("%5d",x[i]);
                System.out.print("\n");
            //return;//若return则只求出其中一种解，若不return则可以继续回溯，求出全部的可能的解
            }
            else if(x[k]<=n&&k<n)
                k=k+1;//放置下一个皇后
            else
            {
                x[k]=0;//重置x[k],回溯
                k=k-1;
            }
        }
        System.out.println("总共有："+m+"个解");
    }
    public static void main(String[] args) {
	int n  = 8;
	System.out.println("皇后个数为："+n);
	queue(n);
    }
}
