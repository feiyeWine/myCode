package com.secondWork;


public class PIMNote extends PIMEntity{
    private String text;
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public void fromString(String s) {
	System.out.println(s);
    }
    @Override
    public String toString() {
	return "NOTE "+getPriority()+" "+getText();
    }
}
