package com.example.recorder;

import java.util.List;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.recorder.MainActivity.Recorder;

public class RecorderAdapter extends ArrayAdapter<Recorder>{
	
	private Context mContext;
	private List<Recorder> mDatas;
	
	private int mMinItemWidth;
	private int mMaxItemWidth;
	
	private LayoutInflater mInflater;
	
	public RecorderAdapter(Context context, List<Recorder> mDatas) {
		super(context, -1,mDatas);
		
		mContext = context;
		this.mDatas = mDatas;
		mInflater = LayoutInflater.from(context);
		
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		mMaxItemWidth = (int) (outMetrics.widthPixels*0.7f);
		mMinItemWidth = (int) (outMetrics.widthPixels*0.15f);
		
		
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if(holder==null){
			convertView = mInflater.inflate(R.layout.item_recorder, parent,false);
			holder = new ViewHolder();
			holder.seconds = (TextView) convertView.findViewById(R.id.recorder_time);
			holder.length = convertView.findViewById(R.id.recorder_lenght);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.seconds.setText(Math.round(getItem(position).time)+"\"");
		ViewGroup.LayoutParams lp = holder.length.getLayoutParams();
		lp.width = (int) (mMinItemWidth+(mMaxItemWidth/60f*getItem(position).time));
		
		return convertView;
	}
	private class ViewHolder{
		TextView seconds;
		View length;
	}
}
