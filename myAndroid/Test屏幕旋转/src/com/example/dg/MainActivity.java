package com.example.dg;

import android.support.v7.app.ActionBarActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
	}
	/**
	 * ������Ļ��ת
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		//��ȡ��Ļ��ǰ״̬
		if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){ //Configuration.ORIENTATION_PORTRAIT��ʾ����
			Toast.makeText(MainActivity.this, "����������", Toast.LENGTH_SHORT).show();
		}
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){//Configuration.ORIENTATION_LANDSCAPE��ʾ����
			Toast.makeText(MainActivity.this, "�����Ǻ���", Toast.LENGTH_SHORT).show();

		}
		
		super.onConfigurationChanged(newConfig);
	}
}
