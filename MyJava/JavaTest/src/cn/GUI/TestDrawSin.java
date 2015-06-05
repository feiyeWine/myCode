package cn.GUI;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 绘制一条y = sin(s);曲线
 * @author YR
 *
 */
public class TestDrawSin extends Frame{
    int beginx = 0;
    int endx = 600;
    public void paint(Graphics g){
	this.setBackground(Color.GRAY);
	Color color = g.getColor();
	g.setColor(Color.BLACK);
	g.drawString("y=sin(x)曲线图", 250, 40);
	g.drawLine(0, 325, 600, 325);
	g.setColor(Color.GREEN);
	for(int i = beginx;i<endx;i++){
	   g.fillOval(i-beginx, (int)(600-(1+Math.sin(i*Math.PI/300))*280), 10, 10); 
	}
	g.setColor(color);
    }
    	
    public static void main(String[] args) {
	Timer myTimer = new Timer();
	
	TestDrawSin sinFrame = new TestDrawSin();
	myTimer.schedule(sinFrame.new SinTimerTask(), 100,10);
	sinFrame.setSize(620,620);
	sinFrame.setLocation(100,100);
	sinFrame.setVisible(true);
	sinFrame.addWindowListener(new WindowAdapter() {
	    
	    @Override
	    public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	    }
	    
	});
    }
    class SinTimerTask extends TimerTask{
	    
	    @Override
	    public void run() {
		if(beginx>=Integer.MAX_VALUE){
		    beginx = 0;
		    endx = 600;
		}else{
		    beginx++;
		    endx++;
		}
		repaint();//刷新窗口
	    }
	    
	}
    //重写update方法
	public void update(Graphics g){
	    Image offScreenImage = null; //利用双缓冲技术消除闪烁
	    Graphics gOff = null;
		if(offScreenImage == null){
    		offScreenImage = this.createImage(this.getSize().width,this.getSize().height);
    		gOff= offScreenImage.getGraphics();
		}
		gOff.setColor(getBackground());
		gOff.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		gOff.fillRect(0, 0, WIDTH, HEIGHT);
		paint(gOff);
		g.drawImage(offScreenImage,0,0,this);
		
	}
}

