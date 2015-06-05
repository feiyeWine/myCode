package cn.MyFramebook;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyTextField extends Frame implements ActionListener
{
	TextField txtfld1,txtfld2;
	public static void main(String[] args) 
	{
		MyTextField frm = new MyTextField();	
	}
	MyTextField()
	{
		super("Frame with Panel");
		setLayout(new FlowLayout());
		txtfld1 = new TextField(20);
		txtfld2 = new TextField(20);
		add(txtfld1);
		add(txtfld2);
		pack();
		txtfld2.setEditable(false);
		setVisible(true);
		setSize(500,350);
		txtfld1.addActionListener(this);
		addWindowListener(new WindowAdapter() 
		{

			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}
			
		});	
	}
	public void actionPerformed(ActionEvent e)
	{
		if((e.getSource()== txtfld1)&&(txtfld1.getText().equals("black")))
			{
				txtfld1.setText("");
				txtfld2.setText("Tel:66666666");
			}
		else if((e.getSource()==txtfld1)&&(txtfld1.getText().equals("smith")))
		{
			txtfld1.setText("");
			txtfld2.setText("Tel:88888888");
		}
		else if((e.getSource()==txtfld1)&&(txtfld1.getText().equals("white")))
		{
			txtfld1.setText("");
			txtfld2.setText("Tel:99999999");
		}
		else
		{
			txtfld1.setText("");
			txtfld2.setText("No Such Telephone Number");
		}
	}

}
