package com.example.textcontextmenu;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showListViw();
	}
	//����ListView����ʵ����
	private void showListViw(){
		ListView listView =  (ListView) findViewById(R.id.listView);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, 
				getData());
		listView.setAdapter(adapter);
		this.registerForContextMenu(listView);
		
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("�ļ�����");
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.add(1,1,1,"����");
		menu.add(1,2,1,"����");
		menu.add(1,3,1,"ճ��");
		menu.add(1,4,1,"ɾ��");
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "����˸���", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(this, "����˼���", Toast.LENGTH_SHORT).show();
			break;
		case 3:
			Toast.makeText(this, "�����ճ��", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(this, "�����ɾ��", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	//����ListView��ʾ������
	private ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList<>();
		for(int i = 1;i<=5;i++){
			list.add("�ļ�"+i);
		}
		return list;
	}
}
