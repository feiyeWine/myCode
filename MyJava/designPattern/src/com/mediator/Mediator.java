package com.mediator;
/**
 * �н��߽ӿ�
 * @author YR
 *
 */
public interface Mediator {
    void register(String dname,Department d);
    void command(String dname,String cd);
}
