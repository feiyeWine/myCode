package com.thirdwork;
/**
 * 0-1背包问题
 * @author YR
 *姓名：尹榕 学号：13121073 班级：131211 practice3
 */
public class Test1 {
    private static int[] weights = {0,50,30,45,25,5};//50,30,45,25,5
    private static int[] values = {0,200,180,225,200,50};//200,180,225,200,50
    private static int n = 5; //5
    private static int p = 100; //100
    
    public static void main(String[] args) {
	int[][] sum = knapsackNp(values, weights, n, p);
	System.out.print("重量为：");
	for(int i = 1;i<=n;i++){
	    System.out.print(weights[i]+"\t");
	}
	System.out.print("\n价值为：");
	for(int i = 1;i<=n;i++){
	    System.out.print(values[i]+"\t");
	}
	System.out.println("\n0-1背包求解最大价值为："+sum[n][p]);
	
	/*for(int i =0;i<=n;i++){
	    for(int j =0;j<=p;j++)
		System.out.print(sum[i][j]+"\t");
	    System.out.println();
	}*/
	System.out.print("背包序号为：");
	int[] x = track(sum, weights);
	for (int i = 1; i <n; i++) {
	    if(x[i]==1)
		switch (i) {
		case 1:
		    System.out.print("A\t");
		    break;
		case 2:
		    System.out.print("B\t");
		    break;
		case 3:
		    System.out.print("C\t");
		    break;
		case 4:
		    System.out.print("D\t");
		    break;
		case 5:
		    System.out.print("E\t");
		    break;
		}
	    }
    }
    //背包中物品序号
    public static int[] track(int[][]c,int w[]){
	int j = p;
	  int[] x = new int[n+1];
	  for(int i=n;i>0;i--){
	      if(c[i][j]>c[i-1][j]){
	      x[i]=1;
	      j=j-w[i];
	      }else x[i]=0;
	     }
	  /*for(int m = 1;m<=n;m++){
	      System.out.println(x[m]);
	  }*/
	  return x;
    }
    //0-1背包求解
  public static  int[][] knapsackNp(int[] v,int[] w,int n,int p){
      int [][] c = new int[n+1][p+1];
      //初始化
      for(int i = 0;i<=p;i++){
	  c[0][i] = 0;
      }
      for(int i =1;i<=n;i++){
	  c[i][0] = 0;
	  for(int j = 1;j<=p;j++){
	      if(w[i] <= j){
		  if((v[i]+c[i-1][j-w[i]])>c[i-1][j]){
		      c[i][j] = v[i] + c[i-1][j-w[i]];
		  }else{
		      c[i][j] = c[i-1][j];
		  }
	      }else{
		  c[i][j] = c[i-1][j];
	      }
	  }
      }
      	/*int j = p;
	  int[] x = new int[n+1];
	  for(int i=n;i>0;i--){
	      if(c[i][j]>c[i-1][j]){
	      x[i]=1;
	      j=j-w[i];
	      }else x[i]=0;
	     }
	  for(int m = 1;m<=n;m++){
	      System.out.println(x[m]);
	  }*/
      
      return c;
  }
}
