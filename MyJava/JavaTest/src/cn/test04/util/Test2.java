package cn.test04.util;

//Test2.java
import java.util.Scanner;
public class Test2
{
	public static void main(String args[]){
		
	    int n=0;
	    String str1=new String();
	    char ch[]=new char[3];
	    String str="abc adf 12";
	    Scanner scan=new Scanner(str);
	    while(scan.hasNext()){
		str1=scan.next();
		System.out.println(str1);
	    }
	    System.out.println(str1);
	    
	    
	    
	    /*String str="1 2 3";
		Scanner scan=new Scanner(str);
		int[] t = new int[4];
		int n=0;
		while(scan.hasNext()){
			if(scan.hasNextInt()){
			    t[n] = scan.nextInt();
				n++;
			}
		}
		int n=0;
		System.out.println("n="+n);*/
	    /*int n=0;
	    String s = "12 ab 34";  
	    Scanner sc = new Scanner(s);  
	    Integer mInt = 0; 
	    String str ;
	    while (sc.hasNext()) {    
	       if (sc.hasNextInt()) {  
	           if((mInt = sc.nextInt())instanceof Integer)  
	           System.out.println("mInt: " + mInt); 
	           
	       }
	       
	    }  
	}*/
	}
}

