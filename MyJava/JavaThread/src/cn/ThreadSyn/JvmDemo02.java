package cn.ThreadSyn;
/**
 * 单例设计模型：
 * 饿汉式
 * @author YR
 *
 */
public class JvmDemo02 {
    public static void main(String[] args) {
	
    }
}
class Jvm2{
    private static Jvm intance = new Jvm();
    public static  Jvm  getIntance(){
	return intance;
    }
}
class Jvm3{
    private  Jvm3(){
	
    }
    
    private static class JvmTest{
	private static Jvm intance = new Jvm();
    }
    public static Jvm getIntance(){
	return JvmTest.intance ;
    }
}