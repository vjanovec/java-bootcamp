package com.vojtechjanovec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    static ServerSocket servsock = null;
    Socket sock = null;
    public final static int SOCKET_PORT = 8086;
    public final static String SERVER = "127.0.0.1";
    static Car car = new Car("Tesla", "Model X", 2020, 200);

    public static void main(String[] args) throws IOException {

    try {
        servsock = new ServerSocket(SOCKET_PORT);
        while(true) {
            System.out.println("Waiting");
            new Thread(new SimpleFileServer(servsock.accept())).start();
        }
    } finally {
        servsock.close();
    }
    }
}
