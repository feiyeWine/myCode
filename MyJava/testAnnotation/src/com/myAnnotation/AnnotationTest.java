package com.myAnnotation;
/**
 * ²âÊÔÎÒµÄ×¢½â
 * @author YR
 *
 */
@TestAnnotation(column = "", uname = "")
public class AnnotationTest {
    @TestAnnotation(column = "num", uname = "int",length=20)
    private int num;
    @TestAnnotation(column = "uname", uname = "varchar")
    private String uname;
    @TestAnnotation(column = "age", uname = "int",length=10)
    private int age;
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}
