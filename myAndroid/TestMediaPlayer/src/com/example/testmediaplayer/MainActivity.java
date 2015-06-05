package com.example.testmediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private Button bt_start;
	private Button bt_pause;
	private Button bt_stop;
	private MediaPlayer mediaPlayer = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt_start = (Button)findViewById(R.id.start);
		bt_pause = (Button)findViewById(R.id.pause);
		bt_stop = (Button) findViewById(R.id.stop);
		//��ӵ���¼�
		bt_start.setOnClickListener(this);
		bt_pause.setOnClickListener(this);
		bt_stop.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.start:
			start();
			break;
		case R.id.pause:
			pause();
			break;
		case R.id.stop:
			stop();
			break;
		}
	}
	public void start(){
		try {
			if(mediaPlayer != null){
				if(mediaPlayer.isPlaying()){	//�Ƿ����ڲ���
					return;
				}
			}
			stop();	//����ֹͣ���ŷ���
			mediaPlayer = MediaPlayer.create(this, R.raw.chong_xin_lai_guo); //����MP3�ļ�
			//�ļ�������ϼ����¼�
			mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				
				@Override
				public void onCompletion(MediaPlayer arg0) {
					//�����ļ���������¼�
					//�����Դ��MediaPlayer�ĸ�ֵ��ϵ������Դ����Ϊ������������
					mediaPlayer.release();
					bt_start.setText("����");
				}
			});
			//�ļ����Ŵ������
			mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
				
				@Override
				public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
					mediaPlayer.release();
					return false;
				}
			});
			//��ʼ����
			mediaPlayer.start();
			bt_start.setText("���ڲ���");
			bt_pause.setText("��ͣ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pause(){
		try {
			if( mediaPlayer != null ){
				if(mediaPlayer.isPlaying()){
					mediaPlayer.pause();
					bt_pause.setText("ȡ����ͣ");
				}else{
					mediaPlayer.start();
					bt_pause.setText("��ͣ");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void stop(){
		try {
			if(mediaPlayer != null){
				mediaPlayer.stop();
				bt_start.setText("����");
				bt_pause.setText("��ͣ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
