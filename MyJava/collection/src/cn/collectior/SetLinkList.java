package cn.collectior;

import java.util.List;

public class SetLinkList /*implements List */{
	private Node first;
	private Node last;
	private int size;
	public void add(Object obj){
		Node n = new Node();
		if(first == null ){
			
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			first = n;
			last = n;
		}else{
			//直接往last节点后增加新的节点
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			last.setNext(n);
			last = n;
			}
		size++;
	}
	public int size(){
		return (size);	
	}
	public Object get(int index){
		rangeCheck(index);
		Node temp = node(index);
		
		//index 越界
		if(temp!=null)
		return temp.obj;
		return null;
	}
	
	public Node node(int index){
		Node temp = null;
		if(first != null){
			temp = first;
			for(int i = 0;i<index;i++){
				temp = temp.next;
			}
		}
		return temp;
	}
	
	public void  remove(int index){
		Node temp = node(index);
		if(temp!=null){
		Node up = temp.previous;
		Node down = temp.next;
		up.next = down;
		down.previous = up.next;
		size--;
		}
	}
	public void add(int index, Object obj){
		Node temp = node(index);
		Node newNode= new Node();
		newNode.obj = obj;
		if(temp!=null){
			Node up = temp.previous;
			up.next = newNode;
			newNode.previous = up;
			newNode.next = temp;
			temp.previous = newNode;
			size++;
		}
	}
	
	
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try {
				throw new Exception();
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		} 
	}
	
	public static void main(String[] args) {
		SetLinkList list = new SetLinkList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(1, "fff");
		//list.remove(1);
		//System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

}


	