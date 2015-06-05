package com.firstwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 实现优先队列
 * @author YR
 *
 * 学号：13121073	姓名：尹榕 (practice 1)
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
	//遍历优先级队列
	System.out.println("最小优先级队列:");
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
    //建立最小堆
    protected int buildHeap(int index){
	int parentIndex = parentIndex(index); //获取父节点索引
	Object element = heap.get(index);
	Object parent = heap.get(parentIndex);
	if(compare(parent, element)>0){		//父节点大于此节点
	    heap.set(parentIndex, element);
	    heap.set(index, parent);
	    return parentIndex;
	}else{
	    return ROOT;	//无需交换
	}
    }
    //增加元素
    public void add(Object o ){
	heap.add(o);
	int index = heap.size()-1; //重新调整堆
	while(index>ROOT){
	    index = buildHeap(index);
	}
    }
    
    
    public int parentIndex(int index){
	return (index+1)/2-1;
    }
    
    //取得优先队列队首元素
    public Object poll() throws Exception{
	if(isEmpty()){
	    throw new Exception("队列为空");
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
	    heap.set(ROOT, element); //交换两个元素
	    heap.remove(index); //删除最后一个元素
	    heapSort(ROOT);
	}
	return o;
    } 
    public void heapSort(int index){
	int p = index;
	int left = 2*p+1;	//左节点
	Object temp = heap.get(p);
	while(left<heap.size()){
	    if(left+1<heap.size()&&compare(heap.get(left),heap.get(left+1))>0){
		left = left+1;
	    }
	    if(compare(temp,heap.get(left))<=0){
		break;
	    }else{
		heap.set(p, heap.get(left));// 较小的孩子节点上浮
		p = left;
		left = 2 * p + 1;// 继续调整
	    }
	}
	heap.set(p, temp);
    }
    
    //比较
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
	return heap.get(0); // 查看队首元素
    } 
}