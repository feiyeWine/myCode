package com.secondWork;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 *  @author 尹榕（13121073）
 *
 */
public class PIMManager {
    public PIMManager(){
	
    }
    ArrayList<PIMEntity> list = new ArrayList<>();
    //列出items的信息
    public void list(){
	System.out.println("There are "+list.size()+" items.");
	for(int i = 0;i<list.size();i++){
	    System.out.println("Item "+(i+1)+": "+list.get(i).toString());
	}
    }
    //创建items
    public void create(){
	System.out.println("Enter an item type ( todo, note, contact or appointment )");
	Scanner scanner = new Scanner(System.in);
	String item = scanner.nextLine().trim();
	Date date;
	switch(item){
	case "todo":
	    PIMTodo todo = new PIMTodo();
	    todo.fromString("Enter date for todo item:");
	    item = scanner.nextLine().trim();
	    date = todo.stringFormatDate(item);//将字符串转换为日期
	    todo.setDate(date);		//设置日期
	    todo.fromString("Enter todo text:");
	    item = scanner.nextLine();
	    todo.setText(item);
	    todo.fromString("Enter todo priority:");
	    item = scanner.nextLine();
	    todo.setPriority(item);
	    list.add(todo);
	    break;
	case "note":
	    PIMNote note = new PIMNote();
	    note.fromString("Enter note priority:");
	    item = scanner.nextLine().trim();
	    note.setPriority(item);
	    note.fromString("Enter note text:");
	    item = scanner.nextLine();
	    note.setText(item);
	    list.add(note);
	    break;
	case "appointment":
	    PIMAppointment appointment = new PIMAppointment();
	    appointment.fromString("Enter date for appointment item:");
	    item = scanner.nextLine().trim();
	    date = appointment.stringFormatDate(item);//将字符串转换
	    appointment.setDate(date);		//设置日期
	    appointment.fromString("Enter appointment description:");
	    item = scanner.nextLine();
	    appointment.setDescription(item);
	    appointment.fromString("Enter appointment priority:");
	    item = scanner.nextLine();
	    appointment.setPriority(item);
	    list.add(appointment);
	    break;
	case "contact":
	    PIMContact contact = new PIMContact();
	    contact.fromString("Enter firstName for contact item:");
	    item = scanner.nextLine().trim();
	    contact.setFirstName(item);
	    contact.fromString("Enter lastName for contact item:");
	    item = scanner.nextLine().trim();
	    contact.setLastName(item);
	    contact.fromString("Enter emailAddress for contact item:");
	    item = scanner.nextLine();
	    contact.setEmailAddress(item);
	    contact.fromString("Enter contact priority:");
	    item = scanner.nextLine();
	    contact.setPriority(item);
	    list.add(contact);
	    break;
	}
	
    }
    //保存items,利用IO流将items写入文件text,不以追加形式写入文件
    public void save(){
	String str = null;
	String path = "E:/text";
	File file = new File(path);
	FileOutputStream fos = null;
	try {
	    fos = new FileOutputStream(file);
	} catch (FileNotFoundException e1) {
	    e1.printStackTrace();
	}
	if(!list.isEmpty())
	    for(int i = 0;i<list.size();i++){
		    str = "Item "+(i+1)+": "+list.get(i).toString()+"\r\n";
		    try {
			byte[] data = str.getBytes();
			fos.write(data,0,data.length);
			fos.flush();
		    }catch(IOException e){
			e.printStackTrace();
		    }
		}
		try {
		    if(fos!=null){
			fos.close();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    System.out.println("Items have been saved");
	}
    //加载items,从文件text中读取items
    public void Load(){
	FileInputStream fis;
	try {
	     fis = new FileInputStream("E:/text");
	     byte[] b = new byte[1024];
	     int len = 0;
	     if((len=fis.read(b))!=-1){
		 String str = new String(b,0,len);
		 System.out.print(str);
	     }
	     fis.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    public static void main(String[] args) {
	PIMManager manager = new PIMManager();
	System.out.println("Welcome to PIM.");
	Scanner scanner;
	String command="";
	while(!command.equals("Quit")){
	    System.out.println("---Enter a command (suported commands are List Create Save Load Quit)---");
	     scanner = new Scanner(System.in);
	     command = scanner.nextLine().trim();
	   switch(command){
	   case "List":
	       manager.list();
	       break;
	   case "Create":
	       manager.create();
	       break;
	   case "Save":
	       manager.save();
	       break;
	   case "Load":
	       manager.Load();
	       break;
	   } 
	}
    }
}
