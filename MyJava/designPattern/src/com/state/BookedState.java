package com.state;
/**
 * ¿ÕÏÐ×´Ì¬
 * @author YR
 *
 */
public class BookedState implements State{

    @Override
    public void handle() {
	System.out.println("ÒÑÔ¤¶©×´Ì¬");
    }

}
