package cn.testIO;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * ���ѧ���ɼ����������޸�
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
	boolean flag = false; //ѧ����Ϣ�Ƿ����
	file.seek(0);	//��λ���ļ�ͷ
	while(file.getFilePointer()!=file.length()){
	    int no2 = file.readInt();	//��ѧ��
	    file.readUTF();
	    file.readUTF();
	    if(student.no == no2){
		file.writeFloat(student.score);//��ȣ�ֻ�޸�ѧ������
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
	System.out.println("ѧ����Ϣһ����");
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