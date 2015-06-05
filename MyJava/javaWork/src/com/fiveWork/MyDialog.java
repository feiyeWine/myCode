package com.fiveWork;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyDialog {
    	private JDialog dialog = new JDialog(new PIMCalendar());
	private Container container = dialog.getContentPane();
	private  JTextField jt1,jt2,jt3;
	
	private PIMCollection collection = new PIMCollection();
	private String proprity,text,date;
	
	
    public MyDialog(String name) {
	container.setLayout(new GridLayout(8,1));
	JLabel itName = new JLabel(name, JLabel.CENTER);
	container.add(itName);
	JLabel j1 = new JLabel("Proprity", JLabel.LEFT);
	container.add(j1);
	 jt1 = new JTextField();
	container.add(jt1);
	JLabel j2 = new JLabel("Text", JLabel.LEFT);
	container.add(j2);
	 jt2 = new JTextField();
	container.add(jt2);
	JLabel j3 = new JLabel("Date (格式为：25/03/2013)", JLabel.LEFT);
	container.add(j3);
	jt3 = new JTextField();
	container.add(jt3);
	JButton button = new JButton("添加");
	container.add(button);
	
	final String itemName= name;
	button.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		proprity = jt1.getText();
		text = jt2.getText();
		date = jt3.getText();
		if(itemName.equals("Todo")){
		    PIMTodo todo = new PIMTodo();
		    todo.setPriority(proprity);
		    todo.setText(text);
		    todo.setDate(todo.stringFormatDate(date));
		    collection.add(todo);
		}
		if(itemName.equals("Note")){
		    PIMNote note = new PIMNote();
		    note.setPriority(proprity);
		    note.setText(text);
		    collection.add(note);
		}
		if(itemName.equals("Appointment")){
		    PIMAppointment ap = new PIMAppointment();
		    ap.setPriority(proprity);
		    ap.setDescription(text);
		    ap.setDate(ap.stringFormatDate(date));
		    collection.add(ap);
		}
		if(itemName.equals("Contact")){
		    PIMContact contact = new PIMContact();
		    contact.setPriority(proprity);
		    String [] str = text.split(",");
		    contact.setFirstName(str[0]);
		    contact.setLastName(str[1]);
		    contact.setEmailAddress(str[2]);
		    collection.add(contact);
		}
		collection.setList(collection);
		for(PIMEntity temp :collection){
		    System.out.println(temp.toString());
		}
		
		dialog.setVisible(false);
	    }
	});

	switch (name) {
	case "Todo":
	    break;
	case "Note":
	    container.remove(jt3);
	    container.remove(j3);
	    dialog.validate();
	    break;
	case "Appointment":
	    j2.setText("Description");
	    break;
	case "Contact":
	    j2.setText("FirstName+LastName+EmailAddress(格式：以“,”为分隔符)");
	    container.remove(jt3);
	    container.remove(j3);
	    dialog.validate();
	    break;
	}
	dialog.setSize(500, 300);
	dialog.setVisible(true);
    }
    public static void main(String[] args) {
	new MyDialog("Contact");
	String str = "hi,hello,wo";
	String s[] = str.split(",");
	System.out.println(s[2]);
    }
}
