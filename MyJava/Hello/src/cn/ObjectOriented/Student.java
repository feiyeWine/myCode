package cn.ObjectOriented;

public class Student {
	//��̬������
	 String name;
	 int id;    //ѧ��
	 int age;
	 String gender;
	 int weight;
	 
	 Computer computer;

	//��̬����Ϊ
	 public void study(){
		 System.out.println(name+"��ѧϰ");
	 }
	 
	 public void sayHello(String sname){
		 System.out.println(name+"��"+sname+"�f����ã�");
	 }
	
}
