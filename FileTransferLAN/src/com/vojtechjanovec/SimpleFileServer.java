package com.vojtechjanovec;

import java.io.*;
import java.net.Socket;

public class SimpleFileServer implements Runnable {

    // you may change this
    public final static String FILE_TO_SEND = "src/com/vojtechjanovec/soubor.txt";  // you may change this
    public final static int FILE_SIZE = 6022386; // file size temporary hard coded
    // should bigger than the file to be downloaded
    public final static String
            FILE_TO_RECEIVED = "src/com/vojtechjanovec/soubor2.txt";  // you may change this, I give a

    //        ObjectToSend obj = new ObjectToSend(1);
    int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;
    ObjectInputStream in = null;
    Car car = null;

    public SimpleFileServer(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try {
            try {
                System.out.println("Accepted connection : " + sock);

//                    String filename = "src/com/vojtechjanovec/soubor3.ser";
//                    FileOutputStream file = new FileOutputStream(filename);
//                    ObjectOutputStream out = new ObjectOutputStream(file);

//                oos = new ObjectOutputStream(sock.getOutputStream());
//                oos.writeObject(car);
//                oos.flush();


                // send file
//                    File myFile = new File (FILE_TO_SEND);
//                    byte [] mybytearray  = new byte [(int)myFile.length()];
//                    fis = new FileInputStream(myFile);
//                    bis = new BufferedInputStream(fis);
//                    bis.read(mybytearray,0,mybytearray.length);
//                    os = sock.getOutputStream();
//                    System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
//                    os.write(mybytearray,0,mybytearray.length);
//                    os.flush();


                // receive file
                byte[] mybytearray = new byte[FILE_SIZE];
                InputStream is = sock.getInputStream();

                fos = new FileOutputStream(FILE_TO_RECEIVED);
                bos = new BufferedOutputStream(fos);
                bytesRead = is.read(mybytearray, 0, mybytearray.length);
                current = bytesRead;

                do {
                    bytesRead =
                            is.read(mybytearray, current, (mybytearray.length - current));
                    if (bytesRead >= 0) current += bytesRead;
                } while (bytesRead > -1);

                bos.write(mybytearray, 0, current);
                bos.flush();
                System.out.println("File " + FILE_TO_RECEIVED
                        + " downloaded (" + current + " bytes read)");

//            InputStream is2 = sock.getInputStream();
//            FileInputStream file = new FileInputStream
//                    (FILE_TO_RECEIVED);
//            file.close();
                ByteArrayInputStream byt = new ByteArrayInputStream(mybytearray);
                in = new ObjectInputStream(byt);

                // Method for deserialization of object
                Car car2 = (Car) in.readObject();
                System.out.println(car2);

                System.out.println("Object has been deserialized ");

                System.out.println("Done.");


            } finally {

                if (fos != null) fos.close();
                if (bos != null) bos.close();
                if (sock != null) sock.close();
                if(in != null) in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}