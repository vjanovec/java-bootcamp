package com.vojtechjanovec;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileClient {

    public final static int SOCKET_PORT = 8086;      // you may change this
//    public final static String SERVER = "127.0.0.1";  // localhost
        public final static String SERVER = "10.0.1.110";


    // different name because i don't want to
    // overwrite the one used by server...



    public static void main (String [] args ) throws IOException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        ServerSocket servsock = null;
        Socket sock = null;
        ObjectOutputStream  oos = null;
        Car car = new Car("Tesla", "Model X", 2020, 200);

        try
        {

//        int working = 0;
//        for(int i=1; i<255; i++) {
//            try {
//                Socket sock2 = new Socket(("10.0.1."+i), SOCKET_PORT);
//                sock2.setSoTimeout(1000);
//                System.out.println("Connecting...");
//                working++;
//            } catch(SocketException e) {
//                System.out.println("Not working");
//            }
//
//        }



            sock = new Socket(SERVER, SOCKET_PORT);
            System.out.println("Connecting...");

            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(car);
            oos.flush();

        } finally {
            if (bis != null) bis.close();
            if (os != null) os.close();
            if (sock != null) sock.close();
            if (oos != null) oos.close();
        }
    }

}