package com.example.testcontent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * �ڶ���ҳ��
 * @author YR
 *
 */
public class SActivity extends Activity{
	private Button bt ;
	private String data="��ã����ǵڶ���ҳ��";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sactivity);
		bt = (Button) findViewById(R.id.button1_third);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("data", data);
				setResult(2, intent);
				//������ǰҳ��
				finish();
			}
		});
	}
}
