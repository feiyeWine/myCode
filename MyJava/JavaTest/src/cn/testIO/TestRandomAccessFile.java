package cn.testIO;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 完成学生成绩的增加与修改
 * @author YR
 *
 */
public class TestRandomAccessFile {
    public static void main(String[] args) throws Exception {
	RandomAccessFile file = new RandomAccessFile("student.text", "rw");
	Scanner scanner = new Scanner(System.in);
	Student student = new Student();
	student.no = scanner.nextInt();
	student.name = scanner.next();
	student.className = scanner.next();
	student.score = scanner.nextFloat();
	boolean flag = false; //学生信息是否存在
	file.seek(0);	//定位到文件头
	while(file.getFilePointer()!=file.length()){
	    int no2 = file.readInt();	//读学号
	    file.readUTF();
	    file.readUTF();
	    if(student.no == no2){
		file.writeFloat(student.score);//相等，只修改学生分数
		flag = true;
		break;
	    }else{
		file.readFloat();
	    }
	}
	if(!flag){
	    file.writeInt(student.no);
	    file.writeUTF(student.name);
	    file.writeUTF(student.className);
	    file.writeFloat(student.score);
	}
	System.out.println("学生信息一览表：");
	file.seek(0);
	while(file.getFilePointer()!=file.length()){
	    student.no  = file.readInt();
	    student.name = file.readUTF();
	    student.className = file.readUTF();
	    student.score = file.readFloat();
	    System.out.print(student.no+",");
	    System.out.print(student.name+",");
	    System.out.print(student.className+",");
	    System.out.println(student.score);
	}
	file.close();
    }
}
class Student{
    int no;
    String name;
    String className;
    float score;
}