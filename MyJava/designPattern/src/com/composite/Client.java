package com.composite;

public class Client {
    public static void main(String[] args) {
	AbstractFile f2,f3,f4,f5;
	Folder f1 = new Folder("�ҵ��ղ�");
	f2 = new ImageFile("��ͼ.jpg");
	f3 = new VideoFile("һ�׸�.mp3");
	f1.addFile(f2);
	f1.addFile(f3);
	f1.killVirus();
	
	Folder f11 = new Folder("��Ӱ");
	f4 = new VideoFile("�ҵĺ��ֵ�");
	f5 = new VideoFile("������ϵ");
	f11.addFile(f4);
	f11.addFile(f5);
	
	f1.addFile(f11);
	f1.killVirus();
    }
}
