package cn.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * InetSocketAddress·â×° ¶Ë¿Ú
 * @author YR
 *
 */
public class InetSocketDemo01 {
    public static void main(String[] args) {
	InetSocketAddress ad = new InetSocketAddress("10.127.127.1", 999);
	System.out.println(ad.getHostName());
	System.out.println(ad.getPort());
	InetAddress addr = ad.getAddress();
	System.out.println(addr.getHostAddress());
	System.out.println(addr.getHostName());
    }
}
