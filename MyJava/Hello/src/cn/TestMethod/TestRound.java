package cn.TestMethod;
/**
 * ¾Å¾Å³Ë·¨±í
 * @author ÒüéÅ
 * @version 1.0
 */

public class TestRound {
	public static void main(String[] args){
		int i= 1;
		for(i=1;i<=9;i++){
			for(int j=i;j<=9;j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");	
			}
			System.out.println();
		}
		
	}

}
