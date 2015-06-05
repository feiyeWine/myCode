package com.firstwork;

/**
 * �ж�һ���������Ƿ�����������ĺ�Ϊ��������ʱ�临�Ӷ�O(nlogn)
 * @author YR
 *
 * ѧ�ţ�13121073	���������� (practice 1)
 */
public class Test1 {
    public static void main(String[] args) {
	int[] arr = {2,8,4,22,11,7,8,-3,-5};
	int sum = 23;
	int key;
	int t = 0;
	int i;
	System.out.println("����Ϊ��");
	for(int temp : arr){
	    System.out.print(temp+"\t");
	}
	mergeSort(arr);
	System.out.println("\n�����Ϊ��");
	for(int temp : arr){
	    System.out.print(temp+"\t");
	}
	System.out.print("\n���������Ƿ���ں���"+sum+"����������");
	for( i= 0;i<arr.length;i++){
	    key = sum-arr[i];
	    t = search(arr,key);
	    if(t!=-1&&i!=t){
		System.out.println("\n�������д����������ĺ��ǣ�"+sum+"\n��������Ϊ��"+arr[i]+","+key);
		break;
	    }else if(t==-1&&i<arr.length){
		continue;
	    }
	}
	if(t==-1&&i>=arr.length){
		System.out.println("\n�������в������������ĺ��ǣ�"+sum);
	}
    }
    
   //�ָ�����
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
    //���й鲢����
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
    //���ֲ���
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
