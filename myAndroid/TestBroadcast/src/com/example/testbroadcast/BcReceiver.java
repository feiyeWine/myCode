package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BcReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC1���յ��Ĺ㲥Ϊ��"+s);
		Bundle bundle = getResultExtras(true);
		System.out.println("�õ�Ϊ��"+bundle.getString("test"));
		Toast.makeText(context, "BC1���յ��Ĺ㲥Ϊ��"+s, Toast.LENGTH_SHORT).show();
		Toast.makeText(context,"�õ�Ϊ��"+bundle.getString("test"), Toast.LENGTH_SHORT).show();
	}

}
