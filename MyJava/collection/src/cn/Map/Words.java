package cn.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *统计每个单词出现的次数
 *this is a cat and that is a dog and where is the food
 *存储到Map中
 *key:String 
 *value:Letter
 *1.为所有key 创建容器
 *2.容器中存放对应value
 *
 *1.第一次创建容器并存放值
 *2.第二次之后，直接使用容器放值
 *
 * @author YR
 *
 */
public class Words {
	public static void main(String[] args) {
		Map<String,Letters> letters= new HashMap<String,Letters>();
		String str = ("this is a cat and that is a dog and where is the food");
		String[] strArray = str.split(" ");
		/*	for(String temp:strArray){
			//为所有key创建容器
			if(!letters.containsKey(temp)){
				Letters col = new Letters();
				col.setCount(1); //第一次值存放
				letters.put(temp, col);
			}
			else{
				//第二次之后直接使用容器存放值
				Letters col = new Letters();
				col.setCount(col.getCount()+1);
			}
		}*/
		Letters col =null;
		for(String temp:strArray){
			//为所有key创建容器
			if(null==(col=letters.get(temp))){
				 col = new Letters();
				col.setCount(1); //第一次值存放
				letters.put(temp, col);
			}
			else{
				//第二次之后直接使用容器存放值
				col.setCount(col.getCount()+1);
			}
		Set<String> keys = letters.keySet();
		for(String key:keys){
			 col = letters.get(key);
			System.out.println("字母："+key+"  次数："+col.getCount());
		}
	}
				
}
	public static void test1(){
		Map<String,Letters> letters= new HashMap<String,Letters>();
		String str = ("this is a cat and that is a dog and where is the food");
		String[] strArray = str.split(" ");
		//1.为所有key 创建容器
				for(String temp:strArray){
					if(!letters.containsKey(temp)){
						letters.put(temp, new Letters());
					}
				//2.容器中存放对应value
					Letters col = letters.get(temp);
					col.setCount(col.getCount()+1);
				}
				//输出Map的值
				Set<String> keys = letters.keySet();
				for(String key:keys){
					Letters col = letters.get(key);
					System.out.println("字母："+key+"  次数："+col.getCount());
				}
	}
		
	

}
