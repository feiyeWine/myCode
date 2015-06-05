package com.example.testsubmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//ͨ��XML�ļ������Ӳ˵�
		MenuInflater inflater  = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
	/*	//��̬����Ӳ˵�
		SubMenu file = menu.addSubMenu("�ļ�");
		SubMenu edit = menu.addSubMenu("�༭");
		file.add(1,1,1,"�½�");
		file.add(1,2,1,"��");
		file.add(1,3,1,"����");
		file.setHeaderTitle("�ļ�����");
		file.setHeaderIcon(R.drawable.ic_launcher);
		edit.add(2,1,1,"����");
		edit.add(2,1,1,"ճ��");
		edit.add(2,1,1,"ɾ��");
		edit.setHeaderTitle("�༭����");*/
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.newFile:
			Toast.makeText(this, "������½�", Toast.LENGTH_SHORT).show();
			break;
		case R.id.openFile:
			Toast.makeText(this, "����˴�", Toast.LENGTH_SHORT).show();
			break;
		case R.id.saveFile:
			Toast.makeText(this, "������±���", Toast.LENGTH_SHORT).show();
			break;
		case R.id.editFile:
			Toast.makeText(this, "����˸���", Toast.LENGTH_SHORT).show();
			break;
		case R.id.jianqieFile:
			Toast.makeText(this, "�����ճ��", Toast.LENGTH_SHORT).show();
			break;
		case R.id.xiugaiFile:
			Toast.makeText(this, "�����ɾ��", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
		
	}
}
