package com.iterator;
/**
 * 自定义迭代器接口
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
