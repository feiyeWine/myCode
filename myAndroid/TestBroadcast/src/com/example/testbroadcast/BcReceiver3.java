package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BcReceiver3 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC3���յ��Ĺ㲥Ϊ��"+s);
		Toast.makeText(context, "BC3���յ��Ĺ㲥Ϊ��"+s, Toast.LENGTH_SHORT).show();
	}

}