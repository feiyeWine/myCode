package com.firstwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ʵ�����ȶ���
 * @author YR
 *
 * ѧ�ţ�13121073	���������� (practice 1)
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
	Comparator<Object> c = comparableComparator();
	PQueue pq = new PQueue(c);
	pq.add(5);
	pq.add(10);
	pq.add(6);
	pq.add(2);
	pq.add(8);
	//�������ȼ�����
	System.out.println("��С���ȼ�����:");
	while(!pq.isEmpty())
	System.out.print(pq.poll()+"\t");
    }
    static Comparator<Object> comparableComparator() {
   	return new Comparator<Object>() {
   	    public int compare(Object x, Object y) {
   		return ((Comparable<Object>) x).compareTo(y);
   	    }
   	};
       }
}
class PQueue{
    protected Comparator<Object>  comparator;
    private List<Object> heap;
    final static int ROOT = 0;
    
    public PQueue() {
	heap = new ArrayList<Object>();
    }
    public PQueue(Comparator<Object> comparator){
	heap = new ArrayList<Object>();
	this.comparator = comparator;
    }
    //������С��
    protected int buildHeap(int index){
	int parentIndex = parentIndex(index); //��ȡ���ڵ�����
	Object element = heap.get(index);
	Object parent = heap.get(parentIndex);
	if(compare(parent, element)>0){		//���ڵ���ڴ˽ڵ�
	    heap.set(parentIndex, element);
	    heap.set(index, parent);
	    return parentIndex;
	}else{
	    return ROOT;	//���轻��
	}
    }
    //����Ԫ��
    public void add(Object o ){
	heap.add(o);
	int index = heap.size()-1; //���µ�����
	while(index>ROOT){
	    index = buildHeap(index);
	}
    }
    
    
    public int parentIndex(int index){
	return (index+1)/2-1;
    }
    
    //ȡ�����ȶ��ж���Ԫ��
    public Object poll() throws Exception{
	if(isEmpty()){
	    throw new Exception("����Ϊ��");
	}
	Object o;
	int index = heap.size()-1;
	if(index==0){
	     o = heap.get(index);
	    heap.remove(index);
	}else{
	    Object element = heap.get(index);
	    o = heap.get(ROOT);
	    heap.set(index, o);
	    heap.set(ROOT, element); //��������Ԫ��
	    heap.remove(index); //ɾ�����һ��Ԫ��
	    heapSort(ROOT);
	}
	return o;
    } 
    public void heapSort(int index){
	int p = index;
	int left = 2*p+1;	//��ڵ�
	Object temp = heap.get(p);
	while(left<heap.size()){
	    if(left+1<heap.size()&&compare(heap.get(left),heap.get(left+1))>0){
		left = left+1;
	    }
	    if(compare(temp,heap.get(left))<=0){
		break;
	    }else{
		heap.set(p, heap.get(left));// ��С�ĺ��ӽڵ��ϸ�
		p = left;
		left = 2 * p + 1;// ��������
	    }
	}
	heap.set(p, temp);
    }
    
    //�Ƚ�
    public int compare(Object element,Object other){
	
	if(this.comparator==null){
	    Comparable<Object> e = (Comparable<Object>) element;
	    Comparable<Object> o = (Comparable<Object>) other;
	    return e.compareTo(o);
	}else{
	    return comparator.compare(element, other);
	}
    }
    
    public String toString() {
	return heap.toString();
    }

    public boolean isEmpty() {
	return heap.isEmpty();
    }

    public int size() {
	return heap.size();
    }

    public Object peek() throws RuntimeException {
	if (isEmpty())
	    throw new RuntimeException();
	return heap.get(0); // �鿴����Ԫ��
    } 
}