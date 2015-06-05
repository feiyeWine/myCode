package com.example.testprogressbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	private ProgressBar progressBar;
	private Button add;
	private Button reduce;
	private Button reset;
	private TextView text;
	private Button show;
	private ProgressDialog proDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//���ô��ڽ�����
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.progress_bar);
		//��ʾ���ֽ�����
		setProgressBarVisibility(true);
		setProgressBarIndeterminate(true);
		setProgress(9999);
		init();
	}

	private void init() {
		add = (Button) findViewById(R.id.add);
		reduce = (Button) findViewById(R.id.reduce);
		reset = (Button) findViewById(R.id.reset);
		text = (TextView) findViewById(R.id.textView1);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		show = (Button) findViewById(R.id.show);
		int first = progressBar.getProgress();
		int second = progressBar.getSecondaryProgress();
		int max = progressBar.getMax();
		String str = "��һ����Ϊ��"+(int)(first/(float)max*100)+"%"+"  �ڶ�����Ϊ��"+(int)(second/(float)max*100)+"%";
		text.setText(str);
		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		reset.setOnClickListener(this);
		show.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.add:{
			progressBar.incrementProgressBy(10);
			progressBar.incrementSecondaryProgressBy(10);
			break;
		}
		case R.id.reduce:{
			progressBar.incrementProgressBy(-10);
			progressBar.incrementSecondaryProgressBy(-10);
			break;
		}
		case R.id.reset:{
			progressBar.setProgress(80);
			progressBar.setSecondaryProgress(60);
			break;
		}
		case R.id.show:{
			//�½��Ի���
			proDialog = new ProgressDialog(MainActivity.this);
			//������ʾ���
			proDialog.setProgressStyle(proDialog.STYLE_HORIZONTAL);
			//���ñ���
			proDialog.setTitle("my ProgressDialog");
			//���öԻ�����Ϣ
			proDialog.setMessage("my progressDialog");
			//����ͼƬ
			proDialog.setIcon(R.drawable.ic_launcher);
			/**
			 * ����ProgressDialog��һЩ��������
			 */
			proDialog.setSecondaryProgress(40);
			proDialog.setMax(100);
			proDialog.incrementProgressBy(50);
			proDialog.setIndeterminate(false);
			
			//����ȷ����ť
			proDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					Toast.makeText(MainActivity.this, "����ProgressDialog", Toast.LENGTH_SHORT).show();
				}
			});
			//����ȡ����ť
			proDialog.setCancelable(true);
			proDialog.show();
			break;
		}
		default:
			break;
		}
		String str = "��һ����Ϊ��"+(int)(progressBar.getProgress()/(float)progressBar.getMax()*100)+"%"+"  �ڶ�����Ϊ��"+(int)(progressBar.getSecondaryProgress()/(float)progressBar.getMax()*100)+"%";
		text.setText(str);
	}
}
