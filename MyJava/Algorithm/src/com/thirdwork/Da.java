package com.thirdwork;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Da {
    public static void main(String[] args) throws IOException {
	DataInputStream f = new DataInputStream(new FileInputStream(new  File("test")));
	int a;
	
	f.close();
    }
}
