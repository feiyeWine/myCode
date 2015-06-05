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
	// 文件 菜单
	JMenu fileMenu = new JMenu("新建条目");
	 
	addMenuItems(menuBar, fileMenu, items);
	
	// 编辑 菜单
	JMenu editMenu = new JMenu("编辑");
	menuBar.add(editMenu);

	// 查看 菜单
	JMenu viewMenu = new JMenu("查看");
	menuBar.add(viewMenu);

	// 保存 菜单
	JMenu saveMenu = new JMenu("保存");
	menuBar.add(saveMenu);

	// 加载 菜单
	JMenu loadMenu = new JMenu("加载");
	menuBar.add(loadMenu);

    }

    // 写一个addMenuItem()方法，菜单 可以用这个方法添加菜单项
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
