package com.firstwork;

import java.util.Arrays;


/**
 * @author  YR
 * 
 * 学号：13121073	姓名：尹榕 (practice 1)
 *
 */
public class Test4 {
    public static void main(String[] args)
    {
        int[] array=new int[]{0,1,1,1,0,1,0,0};
        int [] temp = Arrays.copyOf(array, array.length);
        System.out.println("待排数组为:");
        for(int i :array){
            System.out.print(i+"\t");
        }
        //计数排序
        int[] B=countSort(array, 5);
        System.out.println("\na排序结果：");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(B[i]+"\t");
        }
        
      //原地排序,不需额外空间
        System.out.println("\nb排序结果");
        temp = count(array,5);
        for(int i :temp){
            System.out.print(i+"\t");
        }
        
        //插入排序
        System.out.println("\nc排序结果：");
        insertSort(array);
        for(int i :array){
            System.out.print(i+"\t");
        }
        
    }
    
    // 计数排序算法，时间复杂度（n+k）
    //线性时间，且是稳定的，但是需要额外的辅助空间
    public static int[] countSort(int[] array,int k)
    {
	//构造C数组
        int[] C=new int[k+1];
        //获取array数组大小用于构造B数组  
        int length=array.length,sum=0;
        //构造B数组
        int[] B=new int[length];
       
        for(int i=0;i<length;i++)
        {
            C[array[i]]+=1;     // 统计array中各元素个数，存入C数组
        }
        for(int i=0;i<k+1;i++)//修改C数组
        {
            sum+=C[i];
            C[i]=sum;    
        }
        for(int i=length-1;i>=0;i--)//遍历array数组，构造B数组
        {
            
            B[C[array[i]]-1]=array[i];//将array中该元素放到排序后数组B中指定的位置
            C[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
            
        }
        return B;//将排序好的数组返回，完成排序
        
    }
    
    //插入排序算法，稳定的，不需额外空间
    public static void insertSort(int[] elements){
        for(int i = 1;i <elements.length; i++){
            int j = -1;
            while(j <= i && elements[i] > elements[++j]);//找到element[i]应该摆放的位置，此处可以利用查找算法进行优化
            if(j < i){
                //将j之后的数据移动一位，然后把elements[i]移动到j处
                int temp = elements[i];
                for(int k = i-1;k >= j;k--){
                    elements[k+1] = elements[k];
                }
                elements[j] = temp;
            }
        }
    }
    
    //原地排序
    public static int[] count(int [] array,int k1){
	 int[] c=new int[k1+1];
	        int k=0;
	        for(int i=0;i<c.length;i++){
	            c[i]=0;
	        }
	        for(int j=0;j<array.length;j++){
	            c[array[j]]=c[array[j]]+1;
	        }
	        for(;k<c[0];k++){
	            array[k]=0;
	        }
	        for(;k<c[1]+c[0];k++){
	            array[k]=1;
	        }
	        return array;
    }
}