package com.vojtechjanovec;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private Scanner in;

    public Client() {
        try {
            this.clientSocket = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Spuštění klienta proběhlo úspěšně.");
        this.in = new Scanner( System.in );

        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter( this.clientSocket.getOutputStream()));
            while (true) {
                String temp = in.nextLine();
                out.write(temp + "\r\n");
                out.flush();
                System.out.println("Zpráva: \"" + temp + "\" byla odeslána.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main( String[] args ) {
        Client client = new Client(); // vytvoření instance třídy server
    }
}


