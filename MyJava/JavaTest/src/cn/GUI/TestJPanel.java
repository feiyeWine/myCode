package cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ���ܶ������ڣ�ֻ����ӵ�����������
 * @author YR
 *
 */
public class TestJPanel extends JFrame{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	JPanel panel = new JPanel();
	Container container = f.getContentPane();
	container.setLayout(new BorderLayout());
	f.setTitle("����JPanel");
	JButton button = new JButton("���");
	button.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	panel.add(button);
	container.add(panel);
	f.setSize(500,500);
	f.setVisible(true);
	
    }

}
