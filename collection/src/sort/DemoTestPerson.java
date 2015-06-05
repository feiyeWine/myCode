package sort;

import java.util.TreeSet;

public class DemoTestPerson {
	public static void main(String[] args) {
		Person p1 = new Person("张",100);
		Person p2 = new Person("梁朝伟",1000);
		Person p3 = new Person("成龙",1200);
		Person p4 = new Person("老裴",150);
		//依次存放到TreeSet容器中,使用业务排序类（匿名类）
		TreeSet<Person> person = new TreeSet<Person>(
			new java.util.Comparator<Person>(){

				@Override
				public int compare(Person o1, Person o2) {
					return o1.getHandSome()-o2.getHandSome();
				}
				
			}
		);
		person.add(p1);
		//TreeSet在添加数据时排序，数据更改不会影响原来的顺序
		person.add(p2);
		person.add(p3);
		person.add(p4);
		System.out.println(person);
	}
}
