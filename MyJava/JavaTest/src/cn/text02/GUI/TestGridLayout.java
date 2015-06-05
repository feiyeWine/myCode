package cn.text02.GUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Íø×´²¼¾ÖÆ÷
 * @author YR
 *
 */
public class TestGridLayout extends Frame{
    public static void main(String[] args) {
	TestGridLayout f = new TestGridLayout();
	f.init();
    }
    public void init(){
	Frame f = new Frame();
	String name[] ={"1","2","3","4","5","6","7","8","9"};
	Button button[] = new Button[name.length];
	for(int i = 0;i<name.length;i++){
	    button[i] = new Button(name[i]);
	    f.add(button[i]);
	}
	f.setLayout(new GridLayout(4,4,4,4));
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
