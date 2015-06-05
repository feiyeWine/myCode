package com.composite;

public class Client {
    public static void main(String[] args) {
	AbstractFile f2,f3,f4,f5;
	Folder f1 = new Folder("我的收藏");
	f2 = new ImageFile("美图.jpg");
	f3 = new VideoFile("一首歌.mp3");
	f1.addFile(f2);
	f1.addFile(f3);
	f1.killVirus();
	
	Folder f11 = new Folder("电影");
	f4 = new VideoFile("我的好兄弟");
	f5 = new VideoFile("不再联系");
	f11.addFile(f4);
	f11.addFile(f5);
	
	f1.addFile(f11);
	f1.killVirus();
    }
}
