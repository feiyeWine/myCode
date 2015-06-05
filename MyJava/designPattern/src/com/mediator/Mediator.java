package com.mediator;
/**
 * 中介者接口
 * @author YR
 *
 */
public interface Mediator {
    void register(String dname,Department d);
    void command(String dname,String cd);
}
