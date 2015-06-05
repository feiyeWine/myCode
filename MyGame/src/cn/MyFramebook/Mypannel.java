package cn.MyFramebook;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mypannel extends Frame implements ActionListener{
	Button btn;
	Mypannel(){
		super("Frame with Panel");
		setVisible(true);
		Panel pnl = new Panel();
		pnl.setBackground(Color.green);
		btn= new Button("ÍË³ö");
		add(pnl);
		pnl.add(btn);
		pack();
		setSize(200,300);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		btn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Mypannel frm = new Mypannel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn)
			System.exit(0);
		
	}
	
}
