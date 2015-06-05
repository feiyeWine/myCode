package sort;

import java.util.TreeSet;

public class DemoTestPerson {
	public static void main(String[] args) {
		Person p1 = new Person("��",100);
		Person p2 = new Person("����ΰ",1000);
		Person p3 = new Person("����",1200);
		Person p4 = new Person("����",150);
		//���δ�ŵ�TreeSet������,ʹ��ҵ�������ࣨ�����ࣩ
		TreeSet<Person> person = new TreeSet<Person>(
			new java.util.Comparator<Person>(){

				@Override
				public int compare(Person o1, Person o2) {
					return o1.getHandSome()-o2.getHandSome();
				}
				
			}
		);
		person.add(p1);
		//TreeSet���������ʱ�������ݸ��Ĳ���Ӱ��ԭ����˳��
		person.add(p2);
		person.add(p3);
		person.add(p4);
		System.out.println(person);
	}
}
