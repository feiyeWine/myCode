//myMath.java
package cn.test04.util;
public class myArray
{
	public float average(float a[]){
		if(a.length!=0){return sum(a)/a.length;}
		else return 0;
	}
	public float sum(float a[]){
		int i;
		float sum=0;
		for(i=0;i<a.length;i++){
			sum=sum+a[i];
		}
		return sum;
	}
	public float max(float a[]){
		float max1;
		int i;
		max1=a[0];
		for(i=1;i<a.length;i++){
			if(a[i]>max1)
				max1=a[i];
		}
		return max1;
	}
	public float min(float a[]){
		float min1;
		int i;
		min1=a[0];
		for(i=1;i<a.length;i++){
			if(a[i]<min1)
				min1=a[i];
		}
		return min1;
	}
	public void unitary(float a[],float b[]){
		int i;
		float max1,min1;
		max1=max(a);
		min1=min(a);
		if(max1!=min1){
			for(i=0;i<a.length;i++){
				b[i]=(a[i]-min1)/(max1-min1);
			}
		}
		else{
			for(i=0;i<a.length;i++){
				b[i]=a[i]/max1;
			}
		}
	}
	public void show(float a[]){
		int i;
		System.out.printf("%6.2f",a[0]);
		for(i=1;i<a.length;i++){
			System.out.printf(",%6.2f",a[i]);
		}
		System.out.println();
	}
}
