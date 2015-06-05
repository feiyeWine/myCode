package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���ۺ���
 * @author YR
 *
 */
public class ConcreteAddregate {
    private List<Object> list = new ArrayList<>();
    
    public List<Object> getList() {
        return list;
    }
    public void setList(List<Object> list) {
        this.list = list;
    }
    public void addObj(Object obj){
	list.add(obj);
    }
    public void removeObj(Object obj){
   	list.remove(obj);
    }
    
    public MyIterator getIterator(){
	return new ConcreteIterator();
    }
    
    //ʹ���ڲ��ඨ�������������ʹ���ⲿ�������
    private class ConcreteIterator implements MyIterator{
	private int cursor;
	@Override
	public void first() {
	    cursor=0;
	}

	@Override
	public void last() {
	    cursor = list.size();
	}

	@Override
	public boolean isFirst() {
	    return cursor==0?true:false;
	}

	@Override
	public boolean isLast() {
	    return cursor==(list.size()-1)?true:false;
	}

	@Override
	public void next() {
	    if(cursor<list.size()){
		cursor++;
	    }
	}

	@Override
	public Object getCursor() {
	    return list.get(cursor);
	}

	@Override
	public boolean hasNext() {
	    if(cursor<list.size()){
		return true;
	    }
	    return false;
	}
	
    }
}
