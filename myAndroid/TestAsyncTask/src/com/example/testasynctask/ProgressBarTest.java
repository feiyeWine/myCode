package com.example.testasynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarTest extends Activity{
	private ProgressBar progressBar;
	private MyAsyncTask mTask = new MyAsyncTask();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBarTest);
	
		mTask.execute();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		if(mTask!=null&&mTask.getStatus()==AsyncTask.Status.RUNNING){
			
			//cancel����ֻ�ǽ���Ӧ��AsyncTask���Ϊcancel״̬��������������ȡ���̵߳�ִ��
			mTask.cancel(true);
		}
	}
	
	class MyAsyncTask extends AsyncTask<Void, Integer, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			for(int i = 0;i<100;i++){
				if(isCancelled()){
					break;
				}
				publishProgress(i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			if(isCancelled()){
				return;
			}
			progressBar.setProgress(values[0]);
		}
	}
}
