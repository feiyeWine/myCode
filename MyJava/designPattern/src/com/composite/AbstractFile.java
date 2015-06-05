package com.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Ä£ÄâÉ±¶¾
 * @author YR
 *
 */
public interface AbstractFile {
    void killVirus();
}

class ImageFile implements AbstractFile{
    private  String name;
    
    public ImageFile(String name) {
	super();
	this.name = name;
    }

    @Override
    public void killVirus() {
	System.out.println("Í¼Æ¬£º"+this.name+"É±¶¾");
    }
}
class VideoFile implements AbstractFile{
    private  String name;
    
    public VideoFile(String name) {
	super();
	this.name = name;
    }

    @Override
    public void killVirus() {
	System.out.println("ÒôÆµ£º"+this.name+"É±¶¾");
    }
}
class Folder implements AbstractFile{
    private String name;
    private List<AbstractFile> list = new ArrayList<>();
    
    
    public Folder(String name) {
	super();
	this.name = name;
    }
    public void addFile(AbstractFile file){
	list.add(file);
    }
    public void removeFile(AbstractFile file){
	list.remove(file);
    }
    public AbstractFile getFile(int index){
	return list.get(index);
    }
    @Override
    public void killVirus() {
	for (AbstractFile file : list) {
	   file.killVirus();
	}
    }
    
}



