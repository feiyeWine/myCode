package com.example.testlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnScrollListener
{
	private ListView listView;
	private ArrayAdapter<String> arr_adapter;
	private SimpleAdapter sim_adapter;
	private List<Map<String,Object>> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter);
		
		listView = (ListView) findViewById(R.id.listView1);
		//1���½�һ��������
		//ArrayAdapter(�����ģ���ǰListView�����ص�ÿһ���б��Ӧ�Ĳ����ļ�);
		//SimpAdapter()
		/*
		 * context��������
		 * data:����Դ��List<? extends Map<String,?> data>��һ��Map����ɵ�List����
		 * 			ÿһ��Map����ȥ��ӦListView�б��е�һ��
		 * 			ÿһ��Map����-ֵ�ԣ��еļ��������������from����ָ���ļ�
		 * resource���б���Ĳ����ļ�ID
		 * from:Map�еļ���
		 * to:��������ͼ�е�ID����from�ɶ�Ӧ��ϵ
		 */
		//2����������������Դ
		//String[] arr_data = {"data1","data2","data3","data4"};
		dataList = new ArrayList<Map<String,Object>>();
		sim_adapter = new SimpleAdapter(this, getData(), R.layout.simple_list, new String[]{"item1","item2"},new int[]{R.id.img1,R.id.text1} );
		//arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
		//3����ListView������������
		//listView.setAdapter(arr_adapter);
		listView.setAdapter(sim_adapter);
		listView.setOnItemClickListener(this);
		listView.setOnScrollListener(this);
	}
	private List<Map<String,Object>> getData(){
		for(int i = 0 ;i < 20;i++){
			Map<String,Object>map = new HashMap<>();
			map.put("item1", R.drawable.ic_launcher);
			map.put("item2", "item"+i);
			dataList.add(map);
		}
		return dataList;
	}
	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		
	}
	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		switch(arg1){
			case SCROLL_STATE_FLING:
				Log.i("main","��ָ���뿪��Ļʱ���������£���ͼͨ�����Լ�������");
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("item1", R.drawable.ic_launcher);
				map.put("item2","������");
				dataList.add(map);
				sim_adapter.notifyDataSetChanged();
				break;
			case SCROLL_STATE_IDLE:
				Log.i("main","��ͼ�Ѿ�ֹͣ����");
			case SCROLL_STATE_TOUCH_SCROLL:
				Log.i("main","��ָû���뿪��Ļ����ͼ���ڻ���");
		
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		String text = listView.getItemAtPosition(arg2)+"";
		Toast.makeText(this, "position="+arg2+"text="+text, Toast.LENGTH_SHORT).show();
	}
}
