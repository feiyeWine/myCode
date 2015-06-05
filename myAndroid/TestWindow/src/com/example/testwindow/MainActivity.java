package com.example.testwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//��ȡActivity�е�window
		Window window = this.getWindow();
		//�ڱ���������ʾ������
		this.setTitle("������...");
		//��ʾ������
		this.requestWindowFeature(Window.FEATURE_PROGRESS);
		//����ͼ��
		this.requestWindowFeature(Window.FEATURE_LEFT_ICON);
		/*//���ش���״̬��
		window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//���ش����Ϸ�������
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);*/
		setContentView(R.layout.activity_main);
		//���ý������ɼ�
		this.setProgressBarVisibility(true);
		this.setProgress(2000);
		this.setSecondaryProgress(6000);
		
		this.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.qq);
	}
}
