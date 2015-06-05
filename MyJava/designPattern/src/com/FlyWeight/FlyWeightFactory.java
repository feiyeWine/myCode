package com.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author YR
 *
 */
public class FlyWeightFactory {
    private static Map<String,ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();
    
    public static ChessFlyWeight getChess(String c){
	if(map.get(c)!=null){
	    return map.get(c);
	}else{
	    ChessFlyWeight chess = new ConcreteChess(c);
	    map.put(c, chess);
	    return chess;
	}
    }
}
