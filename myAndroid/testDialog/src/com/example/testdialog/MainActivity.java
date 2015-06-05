package com.example.testdialog;

import java.util.zip.Inflater;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
	private Button button2;
	private String[] str = {"��","Ů","��ʿ","����Ա"}; 
	private Button button3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		
	}
	//��ʼ��
	private void init(){
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showDialog1();
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog2();
			}
		});
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showDialog3();	
			}
		});
	}
	//ȷ�ϰ�ť�Ի���
	private void showDialog1(){
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("ȷ�϶Ի���");	//���ñ���
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//����ͼ��
		bulider.setMessage("ȷ�϶Ի�������");	//��������
		bulider.setPositiveButton("ȷ��", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "�����ȷ�϶Ի���", Toast.LENGTH_SHORT).show();
			}
		});
		bulider.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Toast.makeText(MainActivity.this, "�����ȡ����ť", Toast.LENGTH_SHORT).show();
			}
		});
		//��ʾ�Ի���
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
	//��ѡ��ť�Ի���
	private void showDialog2(){
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("��ѡ�Ի���");	//���ñ���
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//����ͼ��
		bulider.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				String text = str[arg1];
				Toast.makeText(MainActivity.this, "ѡ����"+text, Toast.LENGTH_SHORT).show();
			}
		});
		//��ʾ�Ի���
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
	/**
	 * �Զ���Ի���
	 */
	private void showDialog3(){
		LayoutInflater flater = LayoutInflater.from(this);
		View view = flater.inflate(R.layout.mydialog, null);
		AlertDialog.Builder bulider = new AlertDialog.Builder(this);
		bulider.setTitle("�Զ���Ի���");
		bulider.setIcon(R.drawable.th_bossprefs2tv1);	//����ͼ��
		bulider.setView(view);
		
		//��ʾ�Ի���
		AlertDialog dialog = bulider.create();
		dialog.show();
	}
}
