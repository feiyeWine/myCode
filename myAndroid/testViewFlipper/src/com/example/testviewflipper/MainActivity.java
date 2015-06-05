package com.example.testviewflipper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends ActionBarActivity {
	private  ViewFlipper flipper;
	private  Float startX;
	private  int[] resId={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		flipper = (ViewFlipper) findViewById(R.id.flipper);
		for(int i=0;i<resId.length;i++){
			flipper.addView(getImageView(resId[i]));
		}
		flipper.setInAnimation(this,R.anim.abc_fade_in);
		flipper.setOutAnimation(this,R.anim.abc_fade_out);
		flipper.setFlipInterval(2000);
		flipper.startFlipping();
	}
	//��ָ����
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch(event.getAction()){
		//��ָ����
		case MotionEvent.ACTION_DOWN:
		{
			startX = event.getX();
			break;
		}
		//��ָ����
		case MotionEvent.ACTION_MOVE :
		{
			//���һ���
			if(event.getX()-startX>60){
				flipper.setInAnimation(this, R.anim.abc_fade_in);
				flipper.setInAnimation(this,R.anim.abc_fade_out);
				flipper.showPrevious();	//��ʾǰһ��
			}
			//���󻬶�
			if(startX - event.getX()>60){
				flipper.setInAnimation(this, R.anim.abc_fade_in);
				flipper.setInAnimation(this,R.anim.abc_fade_out);
				flipper.showNext();
			}
			
			break;
		}
		case MotionEvent.ACTION_UP :
		{
			
			break;
		}
		}
		
		return super.onTouchEvent(event);
	}
	
	private ImageView getImageView(int resId){
		ImageView img =new ImageView(this);
		//img.setImageResource(resId);
		img.setBackgroundResource(resId);
		return img;
	}
}
