package com.firstwork;

/**
 * 判断一个集合中是否存在两个数的和为给定数，时间复杂度O(nlogn)
 * @author YR
 *
 * 学号：13121073	姓名：尹榕 (practice 1)
 */
public class Test1 {
    public static void main(String[] args) {
	int[] arr = {2,8,4,22,11,7,8,-3,-5};
	int sum = 23;
	int key;
	int t = 0;
	int i;
	System.out.println("数组为：");
	for(int temp : arr){
	    System.out.print(temp+"\t");
	}
	mergeSort(arr);
	System.out.println("\n排序后为：");
	for(int temp : arr){
	    System.out.print(temp+"\t");
	}
	System.out.print("\n此数组中是否存在和是"+sum+"的两个数？");
	for( i= 0;i<arr.length;i++){
	    key = sum-arr[i];
	    t = search(arr,key);
	    if(t!=-1&&i!=t){
		System.out.println("\n此数组中存在两个数的和是："+sum+"\n这两个数为："+arr[i]+","+key);
		break;
	    }else if(t==-1&&i<arr.length){
		continue;
	    }
	}
	if(t==-1&&i>=arr.length){
		System.out.println("\n此数组中不存在两个数的和是："+sum);
	}
    }
    
   //分割数组
    public static int[] mergeSort(int[] arr){
	if(arr.length==0||arr==null){
	    return arr;
	}
	int middle = arr.length/2;
	int[] left = new int[middle];
	int[] right = new int[arr.length-middle];
	for(int i=0;i<arr.length;i++){
	    if(i<middle){
		left[i]=arr[i];
	    }else{
		right[i-middle] = arr[i];
	    }
	}
	if(arr.length>1){
	    left = mergeSort(left);
	    right = mergeSort(right);
	    merge(left,right,arr);
	}
	return arr;
    }
    //进行归并排序
    public static void merge(int[] left,int[] right,int[] mergeArr){
	
	int i = 0,j = 0,k = 0;
	while(i<left.length&&j<right.length){
	    if(left[i]<right[j]){
		mergeArr[k] = left[i];
		i++;
	    }else{
		mergeArr[k] = right[j];
		j++;
	    }
	    k++;
	}
	while(i<left.length){
	    mergeArr[k] = left[i];
	    i++;
	    k++;
	}
	while(j<right.length){
	    mergeArr[k] = right[j];
	    j++;
	    k++;
	}
    }
    //二分查找
    public static int search(int[] arr,int key){
	int begin = 0;
	int end = arr.length-1;
	while(begin<end){
	    int middle = (begin+end)/2;
	    if(key<arr[middle]){
		end = middle-1;
	    }else if(key>arr[middle]){
		begin = middle+1;
	    }else{
		return middle;
	    }
	}
	return -1;
    }
}
