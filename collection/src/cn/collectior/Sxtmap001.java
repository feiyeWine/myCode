package cn.collectior;
/**
 * 自定义实现Map的功能
 * Map存放键值对，根据键对象找对应的值对象
 * @author YR
 *
 */

public class Sxtmap001 {
	
		SxtEntry[] arr = new SxtEntry[990];	
		int size;
		public void put(Object key,Object value){
			SxtEntry e = new SxtEntry(key, value);
			
			//键值重复，后面的键值覆盖前面的键值
			for(int i = 0;i<size;i++)
			{
				if(arr[i].key.equals(key))
				arr[i].value = value;
				return ;
			}	
			
			arr[size++]= e;
			
		}
		public Object get (Object key)
		{
			for(int i = 0;i<size; i++)
			{
				if(arr[i].key.equals(key))
				{
					return  arr[i].value;
				}	
			}
			return null;
		}
		
		public boolean containsKey(Object key)
		{
			for(int i = 0;i<size;i++)
			{
				if(arr[i].key.equals(key))
				{
					return  true;
				}	
			}
			return false;
		}
		
		
		
	public static void main(String[] args) {
		
		Sxtmap001 m = new Sxtmap001();
		m.put("Mr Li", new Wife("Mrs Wang"));
		m.put("Mr Gao",new Wife("Mrs Huang"));
		Wife w = (Wife) m.get("Mr Li");
		System.out.println(w.name);
		
	}
}

class  SxtEntry{
	Object key;			
	Object value;
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
}
			


