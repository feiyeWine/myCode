package cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * ��������
 * @author YR
 *
 */
public class TestJScrollPane extends JFrame{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setTitle("JScrollPane��ʾ");
	Container c = f.getContentPane();
	JScrollPane pane = new JScrollPane();
	JButton button = new JButton("���");
	pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	JPanel panel = new JPanel();
	panel.add(button);
	c.setLayout(new BorderLayout());
	c.add(new JButton("press me"),BorderLayout.SOUTH);
	panel.add(new JButton("��ťһ"));
	panel.add(new JButton("��ť��"));
	panel.add(new JButton("��ť��"));
	panel.add(new JButton("��ť��"));
	pane.setViewportView(panel);
	c.add(pane);
	f.setSize(400, 600);
	f.setVisible(true);
    }
}
