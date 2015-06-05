package com.mediator;

import java.util.HashMap;
import java.util.Map;

public class Manager implements Mediator{
    private Map<String,Department> map = new HashMap<>();
    @Override
    public void register(String dname, Department d) {
	map.put(dname, d);
    }

    @Override
    public void command(String dname, String cd) {
	System.out.println(dname+" ÒªÇó£º"+cd);
	map.get(dname).selfAction();
    }

}
