package cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 测试键盘事件的处理
 * @author YR
 *
 */
public class TestKeyEvent extends JFrame{
    private JLabel label;
    private Container container;
    public static void main(String[] args) {
	new TestKeyEvent();
    }
    public TestKeyEvent() {
	container = this.getContentPane();
	container.setLayout(new BorderLayout());
	label = new JLabel();
	container.add(label,BorderLayout.NORTH);
	this.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
	        char c = e.getKeyChar();
	        label.setText("你按下的键盘是："+c);
	        if(c=='v'){
			JLabel lab2 = new JLabel();
			lab2.setText("你输入的是：‘V’");
			container.add(lab2,BorderLayout.SOUTH);
		    }
	    }
	    
	});
	this.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosed(WindowEvent e) {
	       System.exit(0);
	    }
	});
	this.setSize(400,600);
	this.setVisible(true);
    }
}
