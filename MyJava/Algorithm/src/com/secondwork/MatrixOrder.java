package com.secondwork;
/**
 * 学号：13121073 姓名：尹榕 (practice2)
 * @author YR
 *
 */
public class MatrixOrder   
{  
    private static String name = "ABCD"; //单个字母表示矩阵名 
    private static int[] a = {3, 5, 2, 1,10};  
      
    private static int len = a.length - 1;  
      
    private static int[][] m = new int[len][len];  
    private static int[][] s = new int[len][len];  
      
    public static void main(String[] args)  
    {  
        System.out.print("最少需要的计算次数：");  
        Compute(a, m, s);  
        System.out.println();  
          
        System.out.print("矩阵相乘的顺序为： ");  
        display(s, name, 0, len-1);  
    }  
      
    public static void Compute(int[] a, int[][] m, int[][] s)  
    {  
        int t = 0;  
        int min = 0;  
        int temp = 0;  
          
        for(int i=2; i<a.length; i++)  
        {  
            for(int j=0; j<a.length-i; j++)  
            {  
                t = j + i - 1;  
                  
                m[j][t] = Integer.MAX_VALUE;  
                  
                for(int k=j; k<t; k++)  
                {  
                    //标量乘法
                    temp = m[j][k] + m[k+1][t] + a[j]*a[k+1]*a[t+1];  
                      
                    if(temp < m[j][t])  
                    {  
                        min = temp;  
                        m[j][t] = temp; //保存代价 
                        s[j][t] = k;  //记录取得最优代价处k的值
                    }  
                }  
            }  
        }  
          
        System.out.print(min);  
    }  
      
    public static void display(int[][] s, String name, int i, int j)  
    {  
        if(i == j)  
        {  
            System.out.print(name.charAt(i));  
        }  
        else  
        {  
            System.out.print("(");  
            display(s, name, i, s[i][j]);  
            display(s, name, s[i][j]+1, j);  
            System.out.print(")");  
        }  
    }  
}  