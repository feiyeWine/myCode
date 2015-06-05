package com.secondWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * 学号：13121073 姓名：尹榕
 * @author YR
 *
 */
public class PIMCollection extends ArrayList<PIMEntity>{
    
    private PIMManager manager = new PIMManager();
    private Collection<PIMEntity> list = manager.list;
    //初始化
    public PIMCollection(){
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
    
    public Collection<PIMNote> getNotes(){
	List<PIMNote>  note= new ArrayList<>();
	if(list!=null){
	    for(PIMEntity temp:list){
		if(temp instanceof PIMNote){
		    note.add((PIMNote) temp);
		  //  System.out.println(temp.toString());
		}
	    }
	}
	
	return note;
    }
    public Collection<PIMTodo> getTodos(){
	List<PIMTodo>  todo= new ArrayList<>();
	if(list!=null){
	    for(PIMEntity temp:list){
		if(temp instanceof PIMTodo){
		    todo.add((PIMTodo) temp);
		   // System.out.println(temp.toString());
		}
	    }
	}
	
	return todo;
    }
    
    public Collection getAppointments(){
	List<PIMAppointment>  app= new ArrayList<>();
	if(list!=null){
	    for(PIMEntity temp:list){
		if(temp instanceof PIMAppointment){
		    app.add((PIMAppointment) temp);
		    //System.out.println(temp.toString());
		}
	    }
	}
	
	return app;
    }
    
    public Collection<PIMContact> getContact(){
	List<PIMContact>  contact= new ArrayList<>();
	if(list!=null){
	    for(PIMEntity temp:list){
		if(temp instanceof PIMContact){
		    contact.add((PIMContact) temp);
		    //System.out.println(temp.toString());
		}
	    }
	}
	
	return contact;
    }
    public Collection<PIMEntity> getItemsForDate(Date d){
	List<PIMEntity> entity = new ArrayList<>();
	if(entity!=null){
	    for(PIMEntity temp:list)
	    if(temp instanceof PIMTodo){
		if(d.equals(((PIMTodo)temp).getDate())){	//判断有无此日期
		    entity.add(temp);
		}
	    }else if(temp instanceof PIMAppointment){
		if(d.equals(((PIMAppointment)temp).getDate())){
		    entity.add(temp);
		}
	    }
	}
	
	return entity;
    }
    
    //日期转化
    public Date stringFormatDate(String str) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();
	try {
	    date = sdf.parse(str);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }

    public static void main(String[] args) {
	//测试
	
	PIMCollection collection = new PIMCollection();
	//测试getTodos()
	ArrayList<PIMEntity> lis = (ArrayList) collection.getTodos();
	for(PIMEntity temp : lis){
	    System.out.println(temp);
	}
	//测试getNotes
	lis = (ArrayList) collection.getNotes();
	for(PIMEntity temp : lis){
	    System.out.println(temp);
	}
	//测试getAppointments()
	lis = (ArrayList) collection.getAppointments();
	for(PIMEntity temp : lis){
	    System.out.println(temp);
	}
	// 测试getContact()
	lis = (ArrayList) collection.getContact();
	for (PIMEntity temp : lis) {
	    System.out.println(temp);
	}
	//测试getItemsForDate
	lis = (ArrayList)collection.getItemsForDate(collection.stringFormatDate("03/25/2013"));
	for(PIMEntity temp : lis){
	    System.out.println(temp);
	}
    }
}
