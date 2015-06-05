package cn.GUI;

import java.awt.Color;

import javax.swing.JFrame;

public class TestJFrame extends JFrame{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setTitle("ÎÒµÄJframe");
	f.setBounds(0, 0, 400, 500);
	f.setBackground(Color.gray);
	f.setVisible(true);
    }
   
}
