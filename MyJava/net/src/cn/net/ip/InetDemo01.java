package cn.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress:����װ�˿�
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
