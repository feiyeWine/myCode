package com.thirdwork;
/**
 * 部分背包问题
 * @author YR
 *姓名：尹榕 学号：13121073 班级：131211 practice3
 */
public class Test2 {
    private static int[] weights = {0,50,30,45,25,5};//50,30,45,25,5
    private static int[] values = {0,200,180,225,200,50};//200,180,225,200,50
    private static int n = 5; //5
    private static int p = 100; //100
    
    public static void main(String[] args) {
		double[] s = sort(values, weights, n, p);
		System.out.print("重量为：");
		for(int i = 1;i<=n;i++){
		    System.out.print(weights[i]+"\t");
		}
		System.out.print("\n价值为：");
		for(int i = 1;i<=n;i++){
		    System.out.print(values[i]+"\t");
		}
		int v = 0;
		for(int i = 1;i<=n;i++){
		    for(int j = 1;j<=n;j++){
			int temp = values[j]/weights[j];
			if(temp == s[i] ){
			    if(weights[j]<=p){
				v += values[j];
				p = p-weights[j];
			    }else{
				v += s[i]*p;
				p = 0;
				break;
			    }
			    break;
			}
		    }
		    if(p==0){
			break;
		    }
		}
		System.out.println("\n部分背包求解为："+v);
    }
    //排序
    private static double[] sort(int[] v, int[] w, int n,int p) {
	double per[] = new double[n+1];
	for(int i = 1;i<=n;i++){
	    per[i] = v[i]/w[i];
	}
	for(int i =1;i<n;i++){
	    double temp = 0;
	    for(int j = i+1;j<=n;j++){
		if(per[i]<per[j]){
		    temp = per[i];
		    per[i] = per[j];
		    per[j] = temp;
		}
	    }
	}
	/*for(int i = 1;i<=n;i++){
	    System.out.println(per[i]);
	}*/
	
	return per;
    }
}
