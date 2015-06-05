package cn.test04.util;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
	int num[] = new int[3];
	int i = 0;
	int cr =0;
	int cy =0;
	int cb = 0;
	int count = 0;
	int t =0;
	char[] c = new char[20000];
	Scanner scanner = new Scanner(System.in);
	while(i<3){
	    num[i] = scanner.nextInt();
	    i++;
	}
	Scanner  ss= new Scanner(System.in);
	if(num[0]>num[1]){
	    t = num[0];
	    num[0] = num[1];
	    num[1] = t;
	}
	if(num[1]>num[2]){
	    t = num[1];
	    num[1] = num[2];
	    num[2] = t;
	}
	if(num[0]>num[2]){
	    t = num[0];
	    num[0] =num[2];
	    num[2] = t;
	}
	c = ss.nextLine().trim().toCharArray();
	 int cr1 = 0;
	   int cb1 = 0;
	   int cy1 = 0;
	for(i = 0;i<c.length;i++){
	   
	    if(c[i]=='R'){
		cr++;
		cr1 =cr;
	    }else if(c[i]=='B'){
		cb++;
		cb1 =cb;
	    }else if(c[i]=='Y'){
		cy++;
		cy1 =cy;
	    }
	    count++;
	    if(cr1>cb1){
		    t = cr1;
		    cr1 = cb1;
		    cb1 = t;
		}
		if(cb1>cy1){
		    t = cb1;
		    cb1 = cy1;
		    cy1 = t;
		}
		if(cr1>cy1){
		    t = cr1;
		    cr1 =cy1;
		    cy = t;
		}
	    if((((cb1-cr1)==num[0])&&((cy1-cb1)==num[1])&&((cy1-cr1)==num[2]))||(((cb1-cr1)==num[1])&&((cy1-cb1)==num[0])&&((cy1-cr1)==num[2]))){
		System.out.println(count);
	    }
	}
	
	
    }
}
