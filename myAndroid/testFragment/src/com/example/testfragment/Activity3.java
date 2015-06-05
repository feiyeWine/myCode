package com.example.testfragment;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testfragment.MyFragment3.MyListener;


public class Activity3 extends Activity implements MyListener{
	private EditText editText;
	private Button send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity3);
		editText = (EditText) findViewById(R.id.editText);
		send = (Button) findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			String text = editText.getText().toString();
			MyFragment3 fragment3 = new MyFragment3();
			Bundle bundle = new Bundle();
			bundle.putString("name", text);
			fragment3.setArguments(bundle);
			FragmentManager fm = getFragmentManager();
			FragmentTransaction bt = fm.beginTransaction();
			bt.add(R.id.activity3, fragment3,"activity3" );
			bt.commit();
			Toast.makeText(Activity3.this, "��Fragment��������", Toast.LENGTH_SHORT).show();
			}
		});
		//��̬����
		FragmentManager fm = getFragmentManager();
		Fragment fragmentId = fm.findFragmentById(R.id.frag);
		MyFragment frag = (MyFragment) fragmentId;
		frag.setAaa("frag��̬��ֵ");
	}
	@Override
	public void thank(String code) {
		Toast.makeText(Activity3.this, "�ѳɹ����յ�"+code, Toast.LENGTH_SHORT).show();
	}
}
