package cn.text02.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestBorderLayout extends Frame{
    public static void main(String[] args) {
	TestBorderLayout f = new TestBorderLayout();
	f.init();
    }
    public void init(){
	Frame f = new Frame();
	Button east = new Button("east");
	Button south = new Button("south");
	Button west = new Button("west");
	Button north = new Button("north");
	Button center = new Button("center");
	f.setLayout(new BorderLayout());
	f.add(east,BorderLayout.EAST);
	f.add(south,BorderLayout.SOUTH);
	f.add(west, BorderLayout.WEST);
	f.add(north, BorderLayout.NORTH);
	f.add(center, BorderLayout.CENTER);
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
