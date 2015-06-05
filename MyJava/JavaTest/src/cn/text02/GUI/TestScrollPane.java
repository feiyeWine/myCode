package cn.text02.GUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试滚动条
 * @author YR
 *
 */
public class TestScrollPane extends Frame{
    public static void main(String[] args) {
	TestScrollPane f  = new TestScrollPane();
	f.init();
    }
    public void init(){
	//创建滚动条
	ScrollPane sp = new ScrollPane();
	Panel p = new Panel();
	p.setLayout(new GridLayout(3,3,5,5));
	
	Frame f = new Frame();
	String name[] ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
	Button button[] = new Button[name.length];
	for(int i = 0;i<name.length;i++){
	    button[i] = new Button(name[i]);
	    p.add(button[i]);
	}
	sp.add(p);
	f.add(sp);
	f.setBounds(500,300,200,150);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
	
    }
}
