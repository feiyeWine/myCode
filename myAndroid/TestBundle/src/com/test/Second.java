package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		//��intent�л�ȡ���ݹ���������
		Bundle bundle = this.getIntent().getExtras();
		String message = bundle.getString("message");
		TextView text = (TextView) this.findViewById(R.id.second_textView);
		text.setText(message);
	}
}
