package cn.text02.GUI;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 实现对话框功能
 * @author YR
 *
 */
public class TestDialog02 extends Frame{
    
    Frame f = new  Frame("My Frame");
    Dialog d = new Dialog(f,"My Dialog",true);
    public static void main(String[] args) {
	TestDialog02 f = new TestDialog02();
	f.init();
    }
    public void init(){
	Button b = new Button("Call me");
	b.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		d.setVisible(true);
	    }
	});
	Label l = new Label("My first Dialog",Label.CENTER);
	d.add(l);
	d.setBounds(500,400,200,200);
	f.setLayout(new FlowLayout());
	f.add(b);
	f.setBounds(400,300,150,200);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	d.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			//d.dispose();
		}
	});
    }
}
