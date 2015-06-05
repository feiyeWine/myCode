package com.firstwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PQTest {

    public static void main(String[] args) {
	Comparator c = comparableComparator();
	PriorityQueue pq = new PriorityQueue(c);
	pq.add(2);
	pq.add(101);
	pq.add(1);
	System.out.println(pq.peek());
	System.out.println("------");
	while(!pq.isEmpty())
	System.out.println(pq.poll());
    }

    static Comparator comparableComparator() {
	return new Comparator() {
	    public int compare(Object x, Object y) {
		return ((Comparable) x).compareTo(y);
	    }
	};
    }
}

class PriorityQueue {
    protected Comparator comparator;
    final static int ROOT_INDEX = 0;
    final static int PRE_ROOT_INDEX = ROOT_INDEX - 1;
    List heap;// ��Ŷ���Ԫ�صĶ�

    public PriorityQueue() {
	heap = new ArrayList();
    }

    public PriorityQueue(Comparator c) {
	heap = new ArrayList();
	comparator = c;
    }

    public void add(Object o) {
	heap.add(o);// ���������һ��Ԫ��
	int index = heap.size() - 1;// ���һ��Ԫ�ص�����
	while (index > ROOT_INDEX) {// �ڶ��м�һ��Ԫ�غ�,������ʹ���ٳ�Ϊһ����
	    index = stepUpHeap(index);// �ϸ�
	}
    }

    /*
     * public void offer(Object o){ add(o); }
     */
    protected int stepUpHeap(int index) {
	int parentIndex = parent(index);// ��ȡ���ڵ������
	Object element = heap.get(index);
	Object parent = heap.get(parentIndex);
	if (compare(parent, element) > 0) { // ���ڵ���ڶ��ӽڵ�,����
	    heap.set(parentIndex, element);
	    heap.set(index, parent);
	    return parentIndex; // ����������
	} else
	    return ROOT_INDEX; // ����Ҫ����
    }

    // �Ƚ���
    protected int compare(Object element, Object other) {
	if (comparator == null) {
	    Comparable e = (Comparable) element;
	    Comparable o = (Comparable) other;
	    return e.compareTo(o);
	} else
	    return comparator.compare(element, other);
    }

    protected int parent(int index) {
	return (index - PRE_ROOT_INDEX) / 2 + PRE_ROOT_INDEX;
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
	return heap.get(0); // �鿴���Ԫ��
    }

    public Object poll() throws RuntimeException {// ȡ���ȶ���ͷԪ��
	if (isEmpty())
	    throw new RuntimeException();
	int index = heap.size() - 1;// ���һ��Ԫ�ص�����
	Object least;
	if (index == 0) {
	    least = heap.get(index);
	    heap.remove(index);
	} else {
	    Object element = heap.get(index);// ȡ���һ��Ԫ��
	    least = heap.get(ROOT_INDEX);// ȡ�ѵĸ�Ԫ��
	    heap.set(ROOT_INDEX, element);// ����������Ԫ��
	    heap.set(index, least);
	    heap.remove(index);// ɾ�����һ��Ԫ��
	    stepDownHeap(ROOT_INDEX);// �³�����,ʹ֮�ٴγ�Ϊ��
	}
	return least;
    }

    public void stepDownHeap(int index) {
	int p = index;
	int c = 2 * p + 1;// ���ӽڵ�
	Object temp = heap.get(p);//
	while (c < heap.size()) {
	    if (c + 1 < heap.size()
		    && compare(heap.get(c + 1), heap.get(c)) < 0)// �ҽڵ����ڵ�С
		c = c + 1;// ȡ�������ӽڵ���С��һ��
	    if (compare(temp, heap.get(c)) <= 0)// ����Ҫ������
		break;
	    else {
		heap.set(p, heap.get(c));// ��С�Ķ��ӽڵ��ϸ�
		p = c;
		c = 2 * p + 1;// ��������
	    }
	}
	heap.set(p, temp);// ���Ҫ��temp�ŵ�p
    }
}