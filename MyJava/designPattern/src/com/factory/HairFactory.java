package com.factory;
/**
 * ���͹���
 * @author YR
 *
 */
public class HairFactory  {
    public HairInterface getHair(String key){
	if(key.equals( "left")){
	   return new LeftHair(); 
	}else if(key.equals("right")){
	    return new RightHair();
	}
	return null;
    }
}
