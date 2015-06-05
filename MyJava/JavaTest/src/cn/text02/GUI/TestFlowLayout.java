package cn.text02.GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFlowLayout extends Frame {
    public static void main(String[] args) {
	TestFlowLayout f = new TestFlowLayout();
	f.init();
	
    }
    public void init(){
	Frame f = new Frame();
	Button left = new Button("left");
	Button center = new Button("center");
	Button right = new Button("right");
	f.setLayout(new FlowLayout(FlowLayout.LEFT));
	f.add(left);
	f.add(center);
	f.add(right);
	f.setBounds(300,400,200,200);
	f.setVisible(true);
	f.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
		
	});
    }
}
