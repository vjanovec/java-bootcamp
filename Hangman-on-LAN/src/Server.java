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
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author balikm1
 */
public class Server {

    public static List<String> words = Arrays.asList("rtěnka", "štěnice", "pohovka", "žokej", "nehoda", "modelka", "pěšina", "melodie", "tíha", "svíčková");

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        int randomInt = (int)(Math.random() * words.size());
        String selectedWord = words.get(randomInt);
        System.out.println(selectedWord);

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }

        while (listening)
	    new ServerThread(serverSocket.accept(), new Sibenice(selectedWord)).start();

        serverSocket.close();
    }
    
}
