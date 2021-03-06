package com.recorder.view;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import android.media.MediaRecorder;

public class AudioManager {
	private MediaRecorder mMediaRecorder;
	private String mDir;
	private String mCurrentFilePath;
	private boolean isPrepared;
	
	
	private static AudioManager mInstance;
	
	private AudioManager(String dir){
		mDir = dir;
	}
	/**
	 * 回调准备完毕
	 * @author YR
	 *
	 */
	public interface AudioStateListener{
		void wellPrepared();
	}
	public AudioStateListener mListener;
	public void setOnAudioStateListener(AudioStateListener listener){
		mListener = listener;
	}
	
	
	public static AudioManager getInstance(String dir){
		if(mInstance == null){
			synchronized (AudioManager.class) {
				if(mInstance==null){
					mInstance = new AudioManager(dir);
				}
			}
		}
		return mInstance;
	}
	public void prepareAudio(){
		
		isPrepared = false;
		File dir = new File(mDir);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fileName = generateFileName();
		File file = new File(dir,fileName);
		try {
		mMediaRecorder = new MediaRecorder();
		mCurrentFilePath = file.getAbsolutePath();
		//设置输出文件
		mMediaRecorder.setOutputFile(file.getAbsolutePath());
		//设置MediaRecorder的音频源为麦克风
		mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		//设置音频的格式
		mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
		//设置音频的编码
		mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		mMediaRecorder.prepare();
		mMediaRecorder.start();
		
		isPrepared = true;
		if(mListener!=null){
			mListener.wellPrepared();
		}
		
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 随机生成文件的名称
	 * @return
	 */
	private String generateFileName() {
		
		return UUID.randomUUID().toString()+".amr";
	}


	public int getVoiceLevel(int maxLevel){
		if(isPrepared){
			try{
			//mMediaRecorder.getMaxAmplitude()1-32767
			return maxLevel*mMediaRecorder.getMaxAmplitude()/32768+1;
			}catch(Exception e){
			}
		}
		return 1;
	}
	
	public void release(){
		mMediaRecorder.stop();
		mMediaRecorder.release();
		mMediaRecorder = null;
	}
	
	public void cancel(){
		
		release();
		if(mCurrentFilePath!=null){
			File file = new File(mCurrentFilePath);
			file.delete();
			mCurrentFilePath = null;
		}
	}


	public String getCurrentFilePath() {
		return mCurrentFilePath;
	}
}
