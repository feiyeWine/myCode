package com.firstWork;
/**
 * 
 * @author 尹榕
 * 学号：13121073
 *
 */
//Course类
public class Course {
    public static void main(String[] args) {
	Student student = new Student(args[0]);
	System.out.print(student.num+"  choose  ");
	for(int i=1;i<args.length;i++){
	    student.getBook(args[i]);
	    if(args.length>2&&i<args.length-1){
		System.out.print(" and  ");
	    }
	}
    }
}
//Book类
class Book{
    public String name;
    public Book(){
	
    }
   public Book(String name){
       this.name = name;
   }
}
//Student类
class Student{
    public String num;
    public Book books = new Book();
    public Student(){
    
    }
    public Student(String num){
	this.num = num;
    }
    public Student(String num,String name){
	this();
	this.books.name = name;
    }
    //获取书名
    public void getBook(String name){
	books.name = name;
	System.out.print(books.name);
    }
}