package cn.MyFramebook;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame1 extends Frame implements ActionListener{
	Button btn;
	public static void main(String[] args) {
		MyFrame1 f=new MyFrame1();
	}
		MyFrame1() {
		super("Frame with button");
		btn=new Button("ÍË³ö");
		btn.setBackground(Color.yellow);
		btn.setForeground(Color.blue);
		add(btn);
		pack();
		setSize(300,200);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		btn.addActionListener(this);
		setVisible(true);
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn)
				System.exit(0);
		}

}
