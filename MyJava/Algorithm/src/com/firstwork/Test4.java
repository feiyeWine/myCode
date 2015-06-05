package com.firstwork;

import java.util.Arrays;


/**
 * @author  YR
 * 
 * ѧ�ţ�13121073	���������� (practice 1)
 *
 */
public class Test4 {
    public static void main(String[] args)
    {
        int[] array=new int[]{0,1,1,1,0,1,0,0};
        int [] temp = Arrays.copyOf(array, array.length);
        System.out.println("��������Ϊ:");
        for(int i :array){
            System.out.print(i+"\t");
        }
        //��������
        int[] B=countSort(array, 5);
        System.out.println("\na��������");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(B[i]+"\t");
        }
        
      //ԭ������,�������ռ�
        System.out.println("\nb������");
        temp = count(array,5);
        for(int i :temp){
            System.out.print(i+"\t");
        }
        
        //��������
        System.out.println("\nc��������");
        insertSort(array);
        for(int i :array){
            System.out.print(i+"\t");
        }
        
    }
    
    // ���������㷨��ʱ�临�Ӷȣ�n+k��
    //����ʱ�䣬�����ȶ��ģ�������Ҫ����ĸ����ռ�
    public static int[] countSort(int[] array,int k)
    {
	//����C����
        int[] C=new int[k+1];
        //��ȡarray�����С���ڹ���B����  
        int length=array.length,sum=0;
        //����B����
        int[] B=new int[length];
       
        for(int i=0;i<length;i++)
        {
            C[array[i]]+=1;     // ͳ��array�и�Ԫ�ظ���������C����
        }
        for(int i=0;i<k+1;i++)//�޸�C����
        {
            sum+=C[i];
            C[i]=sum;    
        }
        for(int i=length-1;i>=0;i--)//����array���飬����B����
        {
            
            B[C[array[i]]-1]=array[i];//��array�и�Ԫ�طŵ����������B��ָ����λ��
            C[array[i]]--;//��C�и�Ԫ��-1����������һ��ͬ����С��Ԫ��
            
        }
        return B;//������õ����鷵�أ��������
        
    }
    
    //���������㷨���ȶ��ģ��������ռ�
    public static void insertSort(int[] elements){
        for(int i = 1;i <elements.length; i++){
            int j = -1;
            while(j <= i && elements[i] > elements[++j]);//�ҵ�element[i]Ӧ�ðڷŵ�λ�ã��˴��������ò����㷨�����Ż�
            if(j < i){
                //��j֮��������ƶ�һλ��Ȼ���elements[i]�ƶ���j��
                int temp = elements[i];
                for(int k = i-1;k >= j;k--){
                    elements[k+1] = elements[k];
                }
                elements[j] = temp;
            }
        }
    }
    
    //ԭ������
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