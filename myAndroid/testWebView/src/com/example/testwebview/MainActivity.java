package com.example.testwebview;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {
	private WebView webView;
	private ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String url = "http://www.qq.com";
		/*Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW,uri);
		startActivity(intent);*/
		
		webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl(url);
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				webView.loadUrl(url);
				return true;
			}
		});
		//��WebView��ʹ��JavaScript
		//����JavaScript
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		//����ʹ�û������
		webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				if(newProgress == 100){
					//��ҳ������ϣ��ر�ProgressDialog
					closeDialog();
					
				}else{
					//��ҳ���ڼ���,��ProgressDialog
					openDialog(newProgress);
				}
			}

			private void closeDialog() {
				if(dialog!=null&&dialog.isShowing()){
					dialog.dismiss();
					dialog = null;
				}
			}

			private void openDialog(int newProgress) {
				if(dialog==null){
					dialog = new ProgressDialog(MainActivity.this);
					dialog.setTitle("���ڼ���...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.show();
				}else{
					dialog.setProgress(newProgress);
				}
			}
		});
	}
	//��д������--���ص��߼�
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if(webView.canGoBack()){
				webView.goBack(); //������һҳ��
				return true;
			}
		
		else{
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
