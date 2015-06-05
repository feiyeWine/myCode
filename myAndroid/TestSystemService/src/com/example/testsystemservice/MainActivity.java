package com.example.testsystemservice;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	LayoutInflater inflate = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
	View view = inflate.inflate(R.layout.activity_main,null);
	setContentView(view);
	
	//setContentView(R.layout.activity_main);
	}
	public void doClick(View v){
		switch (v.getId()) {
		case R.id.netWork:
				if(isNetConnect(MainActivity.this)==true){
					Toast.makeText(MainActivity.this, "���紦������״̬", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(MainActivity.this, "����û������", Toast.LENGTH_SHORT).show();
				}
			break;
		case R.id.wifi:
			WifiManager wifi = (WifiManager) MainActivity.this.getSystemService(WIFI_SERVICE);
			if(wifi.isWifiEnabled()){
				wifi.setWifiEnabled(false);
				Toast.makeText(MainActivity.this, "�����Ѿ��ر�", Toast.LENGTH_SHORT).show();
			}else{
				wifi.setWifiEnabled(true);
				Toast.makeText(MainActivity.this, "�����Ѿ���", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.voice:
			AudioManager audio = (AudioManager) MainActivity.this.getSystemService(AUDIO_SERVICE);
			int max = audio.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
			int current = audio.getStreamVolume(AudioManager.STREAM_RING);
			Toast.makeText(MainActivity.this, "ϵͳ���������Ϊ:"+max+"\nϵͳ�ĵ�ǰ����Ϊ��"+current, Toast.LENGTH_SHORT).show();
		default:
			break;
		}
	}
	public boolean isNetConnect(Context context){
		if(context!=null){
			ConnectivityManager cm =  (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
			NetworkInfo info = cm.getActiveNetworkInfo();
			return info.isAvailable();
		}
		return false;
	}
}
