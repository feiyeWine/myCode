package cn.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *ͳ��ÿ�����ʳ��ֵĴ���
 *this is a cat and that is a dog and where is the food
 *�洢��Map��
 *key:String 
 *value:Letter
 *1.Ϊ����key ��������
 *2.�����д�Ŷ�Ӧvalue
 *
 *1.��һ�δ������������ֵ
 *2.�ڶ���֮��ֱ��ʹ��������ֵ
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
			//Ϊ����key��������
			if(!letters.containsKey(temp)){
				Letters col = new Letters();
				col.setCount(1); //��һ��ֵ���
				letters.put(temp, col);
			}
			else{
				//�ڶ���֮��ֱ��ʹ���������ֵ
				Letters col = new Letters();
				col.setCount(col.getCount()+1);
			}
		}*/
		Letters col =null;
		for(String temp:strArray){
			//Ϊ����key��������
			if(null==(col=letters.get(temp))){
				 col = new Letters();
				col.setCount(1); //��һ��ֵ���
				letters.put(temp, col);
			}
			else{
				//�ڶ���֮��ֱ��ʹ���������ֵ
				col.setCount(col.getCount()+1);
			}
		Set<String> keys = letters.keySet();
		for(String key:keys){
			 col = letters.get(key);
			System.out.println("��ĸ��"+key+"  ������"+col.getCount());
		}
	}
				
}
	public static void test1(){
		Map<String,Letters> letters= new HashMap<String,Letters>();
		String str = ("this is a cat and that is a dog and where is the food");
		String[] strArray = str.split(" ");
		//1.Ϊ����key ��������
				for(String temp:strArray){
					if(!letters.containsKey(temp)){
						letters.put(temp, new Letters());
					}
				//2.�����д�Ŷ�Ӧvalue
					Letters col = letters.get(temp);
					col.setCount(col.getCount()+1);
				}
				//���Map��ֵ
				Set<String> keys = letters.keySet();
				for(String key:keys){
					Letters col = letters.get(key);
					System.out.println("��ĸ��"+key+"  ������"+col.getCount());
				}
	}
		
	

}
