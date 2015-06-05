package cn.testswing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 测试文本框
 * @author YR
 *
 */
public class JTextField extends JFrame implements ActionListener{
    javax.swing.JTextField field1;
    javax.swing.JTextField field2;
    public static void main(String[] args) {
	JTextField f = new JTextField();
	f.test();
    }
    public void test(){
	JFrame frame = new JFrame();
	Container container = frame.getContentPane();
	frame.setLayout(new FlowLayout());
	JLabel label1 = new JLabel("请输入一个数字：\n");
	JLabel label2 = new JLabel("该数的阶乘为：");
	 field1= new javax.swing.JTextField(10);
	 field2 = new javax.swing.JTextField(10);
	 field2.setEditable(false);
	container.add(label1);
	container.add(field1);
	container.add(label2);
	container.add(field2);
	field1.addActionListener(this);
	this.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowClosing(WindowEvent e) {
		System.exit(0);
	    }
	});
	frame.setSize(400, 300);
	frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
	int n = Integer.parseInt(field1.getText());
	long f = 1;
	for(int i = 1;i<=n;i++){
	    f *= i;
	}
	field2.setText(String.valueOf(f));
    }
}
