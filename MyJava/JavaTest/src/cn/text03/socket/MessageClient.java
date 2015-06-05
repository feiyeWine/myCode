package cn.text03.socket;

import java.io.IOException;

public class MessageClient {
    public static void main(String[] args) throws IOException, Exception {
	Message.clientStart("localhost",9999);
    }

}
