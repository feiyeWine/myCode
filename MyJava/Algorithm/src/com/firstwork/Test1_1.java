package com.firstwork;

public class Test1_1 {
    
    public static void main(String[] args) {
	int[] arr = {2,8,4,7,16,12,33,53};
	mergeSort(arr,0,arr.length-1);
	for(int i :arr){
	    System.out.println(i);
	}
    }
    
    public static void mergeSort(int a[],int begin,int end){
	if(begin<end){
	    int a1[] = new int[end-begin+1];
	    int begin0 = 0;
	    int mid = (begin+end)/2;
	    
	    mergeSort(a,begin,mid);
	    mergeSort(a,mid+1,end);
	    
	    int begin1 = begin;
	    int begin2 = mid+1;
	    int end1 = mid;
	    int end2 = end;
	    
	    for(int i = 0;i<a1.length;i++){
		if(begin1<=end1&&begin2<=end2){
		    if(a[begin1]<a[begin2]){
			a1[begin0] = a[begin1];
			begin0++;
			begin1++;
		    }else{
			a1[begin0] = a[begin2];
			begin0++;
			begin2++;
		    }
		}else
		    break;
	    }
	    if(begin1<=end1){
		for(;begin0<a1.length;begin0++){
		    a1[begin0] = a[begin1];
		    begin1++;
		}
	    }else{
		for(;begin0<a1.length;begin0++){
		    a1[begin0] = a[begin2];
		    begin2++;
		}
	    }
	    for(int i = 0;i<a1.length;i++){
		a[begin+i] = a1[i];
	    }
	}
    }
}
