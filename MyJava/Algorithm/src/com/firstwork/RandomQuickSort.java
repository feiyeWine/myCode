package com.firstwork;


/**
 * 快速排序
 * @author YR
 * 学号：13121073	姓名：尹榕 (practice 1)
 */
public class RandomQuickSort {
    private int arr[] = {6,4,8,20,9,2,7};
    public static void main(String[] args) {
	RandomQuickSort q = new RandomQuickSort();
	
	System.out.println("排序前为:");
	for(int i :q.arr){
	    System.out.print(i+"\t");
	}
	
	int r = Math.round(q.arr.length-1); //产生随机数
	int temp;
	System.out.println("\n随机位置为："+r);
	temp = q.arr[r];
	q.arr[r] = q.arr[0];
	q.arr[0] = temp;
	
	System.out.println("\n排序后为：");
	q.sort(0, q.arr.length-1);
	for(int i:q.arr)
	System.out.print(i+"\t");
    }
    
    //获得中轴
    public int getMiddle(int arr[],int low,int hight){
	
	 int key = arr[low];
	while(low<hight){
	    while(low<hight&&arr[hight]>=key){
		hight--;
	    }
	    arr[low] = arr[hight];
	    while(low<hight&&arr[low]<=key){
		low++;
	    }
	    arr[hight] = arr[low];
	}
	arr[low] = key;
	return low;
    }
    
    //分别排序
    public void sort(int low,int hight){
	if(low<hight){
	    int middle = getMiddle(arr,low,hight);
	    sort(low,middle-1);
	    sort(middle+1,hight);
	}
    }
}

