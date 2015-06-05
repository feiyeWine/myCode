package com.example.testfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment extends Fragment{
	private String aaa;
	
	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//layout�����ļ�ת����View����
		/**
		 * resource:Fragment ��Ҫ���صĲ����ļ�
		 * root:����layout�ĸ�ViewGroup
		 * attactToRoot:false, �����ظ������ļ�
		 */
		View view = inflater.inflate(R.layout.myfragment, container	, false);
		TextView text = (TextView) view.findViewById(R.id.text);
		Button button = (Button) view.findViewById(R.id.button);
		text.setText("��̬����");
		button.setText("��ȡ����");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String value = getAaa();
				Toast.makeText(getActivity(), "value="+value, Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}
}
