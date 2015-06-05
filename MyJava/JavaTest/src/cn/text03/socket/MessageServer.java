package cn.text03.socket;

import java.io.IOException;

public class MessageServer {
    public static void main(String[] args) throws IOException, Exception {
	Message.startServer(9999);
    }
}
