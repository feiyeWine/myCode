package com.fiveWork;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.ByteOrder;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PIMCalendar extends JFrame{
    private static PIMCalendar frame = new PIMCalendar() ;
    private static Container container = frame.getContentPane();
    //container = frame.getContentPane();
    
    private static int year = new GregorianCalendar().get(Calendar.YEAR);
    private static int month = new GregorianCalendar().get(Calendar.MONTH);
    private static int day = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
    
    private JTextField text;
    private JTextField text2;
    private JTextField text3;
    
   
    private static  JPanel panel;
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    
    private JButton[] button= new JButton[42];	//按钮数目
    
    
    public void init(){
	container.setLayout(new BorderLayout());
	frame.getLabel();
    }
    
    //图形界面
    public JPanel getGUI(int year,int month){
	int y = year;
	int m = month;
	
	container = this.getContentPane();
	panel = new JPanel();
	panel.setSize(WIDTH-10,HEIGHT-10);
	
	panel.setLayout(new GridLayout(8,7));
	panel.add(new JLabel("星期日"));
	panel.add(new JLabel("星期一"));
	panel.add(new JLabel("星期二"));
	panel.add(new JLabel("星期三"));
	panel.add(new JLabel("星期四"));
	panel.add(new JLabel("星期五"));
	panel.add(new JLabel("星期六"));
	//构造按钮对象
	for(int i = 0;i<42;i++){
	    button[i] = new JButton(""+i);
	    button[i].setVisible(false);
	    panel.add(button[i]);
	}
	
	getCalendar(y,m,day);
	return panel;
    }
    
    //获取日历
    public void getCalendar(int year,int month,int day){
	int y = year;
	int m = month;
	int d = day;
	
	// 取得当天日期值
	Calendar today = new GregorianCalendar(y,m,d);
	// 本月一号
	Calendar firstDay = new GregorianCalendar(today.get(Calendar.YEAR),
		today.get(Calendar.MONTH), 1);
	// 一号对应的星期号
	int weekDayOfFirstDay = firstDay.get(Calendar.DAY_OF_WEEK);
	// 此月最大天数
	int maxDayOfMonth = firstDay.getActualMaximum(Calendar.DAY_OF_MONTH);
	// 此日在本月编号
	int dayOfToday = today.get(Calendar.DAY_OF_MONTH);
	
	// 初始化按钮
	int count = 0;
	for ( int i = 0; i < 42; i++) {
	    if (i + 1 >= weekDayOfFirstDay) { // 之前按钮不显示
		count++;
		button[i].setText("" + count);
		button[i].setSize(WIDTH/7, HEIGHT/12);
		if (count == dayOfToday) {
		    button[i].setBackground(Color.green);
		}
		button[i].setVisible(true);
		button[i].addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			
		    }
		});
	    }
	    if (count >= maxDayOfMonth) {
		break;
	    }
	}
    }
    public void getLabel(){
	JLabel label = new JLabel("当前日期为：");
	text = new JTextField(5);
	text.setText(""+year);
	JLabel label2 = new JLabel("年");
	text2 = new JTextField(3);
	text2.setText(""+(month+1));
	JLabel label3 = new JLabel("月");
	text3 = new JTextField(3);
	text3.setText(""+day);
	JLabel label4 = new JLabel("日");
	JPanel p = new JPanel();
	text.setEditable(false);
	text2.setEditable(false);
	text3.setEditable(false);
	
	p.add(label);
	p.add(text);
	p.add(label2);
	p.add(text2);
	p.add(label3);
	p.add(text3);
	p.add(label4);
	
	JButton b = new JButton("上一个月");
	b.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		panel.removeAll();
		container.remove(panel);
		if(month>0){
		    month--;
		    text2.setText(""+(month+1));
		}else{
		    year--;
		    text.setText(""+year);
		    month = 11;
		    text2.setText(""+(month+1));
		}
		//container.remove(panel);
		
		container.add(frame.getGUI(year,month),BorderLayout.CENTER);
		frame.validate();
	    }
	});
	JButton b2 = new JButton("下一个月");
	b2.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		panel.removeAll();
		container.remove(panel);
		if (month < 11) {
		    month++;
		    text2.setText("" + (month + 1));
		} else {
		    year++;
		    text.setText("" + year);
		    month = 0;
		    text2.setText("" + (month + 1));
		}
		container.add(frame.getGUI(year,month),BorderLayout.CENTER);
		frame.validate();
	    }
	    
	});
	p.add(b);
	p.add(b2);
	container.add(p,BorderLayout.NORTH);
	
    }
    
  
    public static void main(String[] args) {
	frame.init();
	JMenuBar bar = new JMenuBar();
	new BuildMenuBar(bar);
	frame.setJMenuBar(bar);
	container.add(frame.getGUI(year,month),BorderLayout.CENTER);
	frame.setSize(WIDTH,HEIGHT);
	frame.setVisible(true);
	
    }
}


class BuildMenuBar {
    String[] items = { "Todo", "Note", "Appointment", "Contact" };
    JMenuItem[] menuItem;
    BuildMenuBar() {
    }

    BuildMenuBar(JMenuBar menuBar) {
	// 文件 菜单
	JMenu fileMenu = new JMenu("新建条目");

	// addMenuItems(menuBar, fileMenu, items);
	menuItem = new JMenuItem[items.length];
	for (int i = 0; i < items.length; i++) {
	    menuItem[i] = new JMenuItem(items[i]);
	    menuItem[i].addActionListener(new ItemsListener());
	    fileMenu.add(menuItem[i]);
	}
	menuBar.add(fileMenu);

	// 编辑 菜单
	JMenu editMenu = new JMenu("编辑");
	editMenu.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.out.println("-----------------");
	    }
	});
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
    public static void addMenuItems(JMenuBar menuBar, JMenu menu, String[] items) {
	JMenuItem[] menuItem = new JMenuItem[items.length];
	for (int i = 0; i < items.length; i++) {
	    menuItem[i] = new JMenuItem(items[i]);
	    menuItem[i].addActionListener(new BuildMenuBar().new ItemsListener());
	    menu.add(menuItem[i]);
	}
	menuBar.add(menu);
    }

    class ItemsListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    //new MyDialog(items[0]);
	    if (e.getSource() == menuItem[0]){
		new MyDialog(items[0]);
	    }
	    if (e.getSource() == menuItem[1]) {
		new MyDialog(items[1]);
	    }
	    if (e.getSource() == menuItem[2]) {
		new MyDialog(items[2]);
	    }
	    if (e.getSource() == menuItem[3]) {
		new MyDialog(items[3]);
	    }
	}

    }
}
