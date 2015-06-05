package cn.innerType;

import java.util.List;
 
/**
 * 基本类型排序
 * @author YR
 *
 */
public class Util {
	
	public static<T extends Comparable<T>> void sort(List<T> list)
	{
		//容器的排序
		Object arr[] = list.toArray();
		sort(arr);
		for(int i = 0;i<arr.length;i++){
			list.set(i,(T)arr[i]);
		}
		
	}
	public static<T extends Comparable<T>> void sort(T[] arr){
		//数组的排序，泛型
		for(int i = 0;i<arr.length-1;i++){
			boolean sort = true;
			
			for(int k = 0;k<arr.length-i-1;k++){
				T temp;
				if(((Comparable)arr[k]).compareTo(arr[k+1])>0){
					temp = arr[k+1];
					arr[k+1] = arr[k];
					arr[k] = temp;
					sort = false;
				}

			}
			if(sort)
				break;
		
	}
	}
	
	public static void sort(Object[] arr){
		//数组的排序
		for(int i = 0;i<arr.length-1;i++){
			boolean sort = true;
			
			for(int k = 0;k<arr.length-i-1;k++){
				Object temp;
				if(((Comparable)arr[k]).compareTo(arr[k+1])>0){
					temp = arr[k+1];
					arr[k+1] = arr[k];
					arr[k] = temp;
					sort = false;
				}

			}
			if(sort)
				break;
		}
	}

}
