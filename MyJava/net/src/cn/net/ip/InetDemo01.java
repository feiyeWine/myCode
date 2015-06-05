package cn.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:²»·â×°¶Ë¿Ú
 * @author YR
 *
 */
public class InetDemo01 {
    public static void main(String[] args) throws UnknownHostException {
	InetAddress address = InetAddress.getLocalHost();
	System.out.println(address.getHostAddress());
	System.out.println(address.getHostName());
    }
}
