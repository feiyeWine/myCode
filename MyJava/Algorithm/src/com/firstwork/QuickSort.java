package com.firstwork;
/**
 * 快速排序
 * @author YR
 *
 * 学号：13121073	姓名：尹榕 (practice 1)
 */
public class QuickSort {
    private int arr[] = {6,4,8,20,9,2,7};
    public static void main(String[] args) {
	
	
	QuickSort q = new QuickSort();
	System.out.println("排序前为:");
	for(int i :q.arr){
	    System.out.print(i+"\t");
	}
	
	q.sort(0,q.arr.length-1);
	System.out.println("\n排序后为：");
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
