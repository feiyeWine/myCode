package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {7,4,5,6,8};
		for(int i = 0;i<a.length-1;i++){
			boolean sort = true;
			
			for(int k = 0;k<a.length-i-1;k++){
				int temp;
				if(a[k+1]<a[k]){
					temp = a[k+1];
					a[k+1] = a[k];
					a[k] = temp;
					sort = false;
				}

			}
			if(sort)
				break;
		
	}
		for( int i = 0;i<a.length;i++){
				System.out.print(a[i]+" ");	
		}
	}

}
