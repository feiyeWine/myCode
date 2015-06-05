package cn.GUI;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestJDialog extends JFrame{
    public static void main(String[] args) {
	new TestJDialog();
    }
    public TestJDialog(){
	this.setSize(400, 500);
	Container c = this.getContentPane();
	this.setLayout(new FlowLayout());
	Dialog dialog = new Dialog(this,"hi");
	dialog.setSize(200, 200);
	dialog.show();
	this.setVisible(true);
    }
}
