package com.iterator;
/**
 * �Զ���������ӿ�
 * @author YR
 *
 */
public interface  MyIterator {
    void first();
    void last();
    boolean isFirst();
    boolean isLast();
    boolean hasNext();
    void next();
    Object getCursor();
}
