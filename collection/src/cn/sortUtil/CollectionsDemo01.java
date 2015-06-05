package cn.sortUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ������Ҫ����
 * 1.binarySearch(List<? extends Comparable<? super T>> list, T key)  ��������
 * 2��reverse(List<?> list)  Ԫ�ط�ת
 * 3��shuffle(List<?> list) ʹ��Ĭ�����Դ��ָ���б������û���ϴ��
   4.sort(List<T> list) 
          ����Ԫ�ص���Ȼ˳�� ��ָ���б�������������� 
 sort(List<T> list, Comparator<? super T> c) 
          ����ָ���Ƚ���������˳���ָ���б��������� 
   5.swap(List<?> list, int i, int j) 
          ��ָ���б���ָ��λ�ô�����Ԫ�ء�   
 * @author YR
 *
 */
public class CollectionsDemo01
{
	public static void main(String[] args)
	{
		List<Integer> cards = new ArrayList<>();
		for(int i = 0;i<54;i++)
		{
			cards.add(i);
		}
		//ϴ��
		Collections.shuffle(cards);
		//����
		List<Integer> p1 = new ArrayList<>();
		List<Integer> p2 = new ArrayList<>();
		List<Integer> p3 = new ArrayList<>();
		List<Integer> last = new ArrayList<>();
		for(int i = 0;i< 51;i+=3)
		{
			p1.add(cards.get(i));
			p2.add(cards.get(i+1));
			p3.add(cards.get(i+2));	
		}
		last.add(cards.get(51));
		last.add(cards.get(52));
		last.add(cards.get(53));
		System.out.println("��һ���ˣ�"+p1);
		System.out.println("�ڶ����ˣ�"+p2);
		System.out.println("�������ˣ�"+p3);
		System.out.println("���ƣ�"+last);
	}
	public static void test1()
	{
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<5;i++)
		{
			list.add(i);
		}
		Collections.reverse(list);
		System.out.println(list);
	}
}