package cn.ThreadPro;

public class Watcher implements Runnable{
  private Movie m = new Movie();
    
    public Watcher(Movie m) {
	super();
	this.m = m;
    }

    @Override
    public void run() {
	for(int i = 0;i<20;i++){
	    if(0==i%2){
	   m.watch();
	    }
	    else{
		m.watch();
	    }
	}   
    }

}
