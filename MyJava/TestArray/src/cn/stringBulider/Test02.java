package cn.stringBulider;
/**
 * ����StringBuilder��һЩ���÷���
 * @author Administrator
 *
 */

public class Test02 {
	public static void main(String[] args){
		StringBuilder sb=new StringBuilder("abcdefghigklmnopqrstuvwxyz");
		sb.delete(3,5).delete(3,5);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		StringBuffer sb2=new StringBuffer();
	}
}