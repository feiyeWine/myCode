package com.fiveWork;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CreateMenuBar {
    String[] items = { "Todo", "Note","Appointment","Contact" };
    CreateMenuBar(JMenuBar menuBar) {
	// �ļ� �˵�
	JMenu fileMenu = new JMenu("�½���Ŀ");
	 
	addMenuItems(menuBar, fileMenu, items);
	
	// �༭ �˵�
	JMenu editMenu = new JMenu("�༭");
	menuBar.add(editMenu);

	// �鿴 �˵�
	JMenu viewMenu = new JMenu("�鿴");
	menuBar.add(viewMenu);

	// ���� �˵�
	JMenu saveMenu = new JMenu("����");
	menuBar.add(saveMenu);

	// ���� �˵�
	JMenu loadMenu = new JMenu("����");
	menuBar.add(loadMenu);

    }

    // дһ��addMenuItem()�������˵� ���������������Ӳ˵���
    public static void addMenuItems(JMenuBar menuBar, JMenu menu,
	    String[] string) {
	JMenuItem[] menuItem = new JMenuItem[string.length];
	for (int i = 0; i < string.length; i++) {
	    menuItem[i] = new JMenuItem(string[i]);
	    menu.add(menuItem[i]);
	}
	menuBar.add(menu);
    }
    
    public void getDialog(String name){
	JDialog dialog = new JDialog();
	Container container = dialog.getContentPane();
	container.setLayout(new GridLayout());
	
	
	switch(name){
	case "Todo":
	    
	    break;
	}
    }
    
    
    class ItemsListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource()==items[0]){
		
	    }
	}
	
    }
}
