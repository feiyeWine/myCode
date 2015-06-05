package com.recorder.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recorder.R;

public class DialogManage {
	private Dialog mDialog ;
	private ImageView mIcon, mVoice;
	private TextView mLabel;
	private Context mContext;
	
	public DialogManage(Context context){
		mContext = context;
	}
	public void showRecordingDialog(){
		mDialog = new Dialog(mContext,R.style.Theme_AudoDialog);
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.dialog_recorder, null);
		mDialog.setContentView(view);
		
		mIcon = (ImageView) mDialog.findViewById(R.id.recorder_dialog_icon);
		mLabel = (TextView) mDialog.findViewById(R.id.recorder_dialog_label);
		mVoice = (ImageView) mDialog.findViewById(R.id.recorder_dialog_voice);
		
		mDialog.show();
	}
	
	public void recording(){
		if(mDialog!=null&&mDialog.isShowing()){
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.VISIBLE);
			mLabel.setVisibility(View.VISIBLE);
			
			mIcon.setImageResource(R.drawable.recorder);
			mLabel.setText("��ָ�ϻ���ȡ������");
		}
	}
	
	public void wantToCancel(){
		if(mDialog!=null&&mDialog.isShowing()){
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.GONE);
			mLabel.setVisibility(View.VISIBLE);
			
			mIcon.setImageResource(R.drawable.cancel);
			mLabel.setText("�ɿ���ָ��ȡ������");
		}
	}
	public void toShort(){
		if(mDialog!=null&&mDialog.isShowing()){
			mIcon.setVisibility(View.VISIBLE);
			mVoice.setVisibility(View.GONE);
			mLabel.setVisibility(View.VISIBLE);
			
			mIcon.setImageResource(R.drawable.voice_to_short);
			mLabel.setText("¼��ʱ�����");
		}
	}
	public void dimissDialog(){
		if(mDialog!=null&&mDialog.isShowing()){
			mDialog.dismiss();
			mDialog = null;
		}
	}
	/**
	 * ͨ��level����ͼƬ1-7
	 * @param level
	 */
	public void updateVoiceLevel(int level){
		if(mDialog!=null&&mDialog.isShowing()){
//			mIcon.setVisibility(View.VISIBLE);
//			mVoice.setVisibility(View.VISIBLE);
//			mLabel.setVisibility(View.VISIBLE);
			
			int resId = mContext.getResources().getIdentifier("v"+level, "drawable", mContext.getPackageName());
			mVoice.setImageResource(resId);

		}
	}
}
