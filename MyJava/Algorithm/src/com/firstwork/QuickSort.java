package com.firstwork;
/**
 * ��������
 * @author YR
 *
 * ѧ�ţ�13121073	���������� (practice 1)
 */
public class QuickSort {
    private int arr[] = {6,4,8,20,9,2,7};
    public static void main(String[] args) {
	
	
	QuickSort q = new QuickSort();
	System.out.println("����ǰΪ:");
	for(int i :q.arr){
	    System.out.print(i+"\t");
	}
	
	q.sort(0,q.arr.length-1);
	System.out.println("\n�����Ϊ��");
	for(int i:q.arr)
	    System.out.print(i+"\t");
    }
    
    //�������
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
    
    //�ֱ�����
    public void sort(int low,int hight){
	if(low<hight){
	    int middle = getMiddle(arr,low,hight);
	    sort(low,middle-1);
	    sort(middle+1,hight);
	}
    }
}
