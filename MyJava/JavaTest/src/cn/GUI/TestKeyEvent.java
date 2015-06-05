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
 * ���Լ����¼��Ĵ���
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
	        label.setText("�㰴�µļ����ǣ�"+c);
	        if(c=='v'){
			JLabel lab2 = new JLabel();
			lab2.setText("��������ǣ���V��");
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
