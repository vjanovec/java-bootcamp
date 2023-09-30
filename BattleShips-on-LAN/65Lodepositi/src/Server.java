/*
 * Server.java
 *
 * Created on 24. duben 2007, 0:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */




import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author balikm1
 */
public class Server extends Thread{
    private int port=8086;
    
    
    public Server(int port) {
        this.port=port;
        start();
    }

    public void run() {
        try {
            ServerSocket serverSocket = null;
            boolean listening = true;
            System.out.println("Server");
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.err.println("Could not listen on port: "+port);
                System.exit(-1);
            }
            
            while (listening)
            {
                
                try {
                    new ServerThread(serverSocket.accept()).start();
                } catch (IOException ex) {
              //      Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
            serverSocket.close();
        } catch (IOException ex) {
           // Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
