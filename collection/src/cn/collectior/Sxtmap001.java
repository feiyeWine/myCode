package cn.collectior;
/**
 * �Զ���ʵ��Map�Ĺ���
 * Map��ż�ֵ�ԣ����ݼ������Ҷ�Ӧ��ֵ����
 * @author YR
 *
 */

public class Sxtmap001 {
	
		SxtEntry[] arr = new SxtEntry[990];	
		int size;
		public void put(Object key,Object value){
			SxtEntry e = new SxtEntry(key, value);
			
			//��ֵ�ظ�������ļ�ֵ����ǰ��ļ�ֵ
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
			


