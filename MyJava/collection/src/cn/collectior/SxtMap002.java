package cn.collectior;

import java.util.LinkedList;

/**
 * 自定义实现Map的升级版
 * @author YR
 *
 */
public class SxtMap002 
{
	LinkedList arr[] = new LinkedList[999];
	
	int size;
	public void put(Object key,Object value)
	{
		SxtEntry e = new SxtEntry(key,value);
		int a = key.hashCode()%arr.length;
		if(arr[a] ==null)
		{
			LinkedList list  = new LinkedList();
			arr[a] = list;
			list.add(e);
		}
		else
		{
			LinkedList list = arr[a];
			for(int i = 0;i<list.size();i++)
			{
				
				SxtEntry e2 = (SxtEntry) list.get(i);
				if(e2.key.equals(key))
				{
					 e2.value = value;
					 return ;
				}	
			}
			arr[a].add(e);
		}
	}
	
	public Object get(Object key)
	{
		int a = key.hashCode()%arr.length;
		if(arr[a] !=null)
		{
			LinkedList list = arr[a];
			for(int i = 0;i<list.size();i++)
			{
				SxtEntry e = (SxtEntry) list.get(i);
				if(e.key.equals(key))
				{
					return e.value;
				}
			}
		}
		return null;
	}	
	public static void main(String[] args) 
	{
		SxtMap002 m = new SxtMap002();
		m.put("Mr Gao",new Wife("Mrs Huang"));
		m.put("Mr Gao",new Wife("Mrs Zhao"));
		Wife w = (Wife) m.get("Mr Gao");
		System.out.println(w.name);
	}
}
