package cn.GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 滚动窗口
 * @author YR
 *
 */
public class TestJScrollPane extends JFrame{
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setTitle("JScrollPane演示");
	Container c = f.getContentPane();
	JScrollPane pane = new JScrollPane();
	JButton button = new JButton("点击");
	pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	JPanel panel = new JPanel();
	panel.add(button);
	c.setLayout(new BorderLayout());
	c.add(new JButton("press me"),BorderLayout.SOUTH);
	panel.add(new JButton("按钮一"));
	panel.add(new JButton("按钮二"));
	panel.add(new JButton("按钮三"));
	panel.add(new JButton("按钮四"));
	pane.setViewportView(panel);
	c.add(pane);
	f.setSize(400, 600);
	f.setVisible(true);
    }
}
