package cn.text02.GUI;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 打开文件或存储文件
 * @author YR
 *
 */
public class TestFileDialog extends Frame{
    Frame f = new Frame("My Frame");
    FileDialog f1 = new FileDialog(f,"My fileDialog",FileDialog.LOAD);
    FileDialog f2 = new FileDialog(f,"My fileDialog",FileDialog.SAVE);
    public static void main(String[] args) {
	TestFileDialog f = new TestFileDialog();
	f.init();
    }
    public void  init(){
	Button b1 = new Button("LOAD");
	b1.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		f1.setVisible(true);
	    }   
	});
	Button b2 = new Button("SAVE");
	b2.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent arg0){
		f2.setVisible(true);
	    }   
	});
	f.setLayout(new FlowLayout());
	f.add(b1);
	f.add(b2);
	f.setBounds(500,300,200,200);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	
    }
    
}
