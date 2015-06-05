package com.example.testnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{
	NotificationManager notiManager; //֪ͨ������
	int notifiId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		findViewById(R.id.send).setOnClickListener(this);
		findViewById(R.id.cancle).setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.send:
				sendNotification();
				break;
			case R.id.cancle:
				notiManager.cancel(notifiId);
				break;
		}
	}
	private void sendNotification(){
		Builder builder = new Notification.Builder(this);
		builder.setSmallIcon(R.drawable.icon); //����ͼ��
		builder.setTicker("Hello");	//�ֻ�״̬����ʾ
		builder.setWhen(System.currentTimeMillis());
		builder.setContentTitle("�ҵ�֪ͨ��"); //���ñ���
		builder.setContentText("������֪ͨ��"); //����֪ͨ����
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);//��������ͼ
	/*	builder.setDefaults(Notification.DEFAULT_SOUND);//������ʾ����
		builder.setDefaults(Notification.DEFAULT_LIGHTS);//������ʾ��
		builder.setDefaults(Notification.DEFAULT_VIBRATE);//������
*/		builder.setDefaults(Notification.DEFAULT_ALL);//
		Notification notification = builder.build();//4.1����
		notiManager.notify(notifiId,notification);
	}
}
