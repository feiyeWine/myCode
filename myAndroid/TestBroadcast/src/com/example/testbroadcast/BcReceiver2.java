package com.example.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BcReceiver2 extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		String s = intent.getStringExtra("msg");
		System.out.println("BC2���յ��Ĺ㲥Ϊ��"+s);
		Bundle bundle = new Bundle();
		bundle.putString("test", "�����Ľ��");
		setResultExtras(bundle);
		Toast.makeText(context, "BC2���յ��Ĺ㲥Ϊ��"+s, Toast.LENGTH_SHORT).show();
	}

}
