package cn.net.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    public static void main(String[] args) throws MalformedURLException {
	URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=customer");
	System.out.println("Э�飺"+url.getProtocol());
	System.out.println("������"+url.getHost());
	System.out.println("�˿ڣ�"+url.getPort());
	System.out.println("��Դ��"+url.getFile());
	System.out.println("���·��"+url.getPath());
	System.out.println("ê�㣺"+url.getRef());
	System.out.println("������"+url.getQuery());//?����������ê��  ����null,������ ������ȷ��
	
	URL url1 = new URL("http://www.baidu.com:80/a");
	URL url2 = new URL(url1,"b.txt");
	System.out.println(url2.toString());
    
    }
}
