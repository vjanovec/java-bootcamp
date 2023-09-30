package com.vojtechjanovec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server {

    // privátní atribut serverSocket
    private ServerSocket serverSocket;
    private ConcurrentLinkedQueue<BufferedReader> clientBufReaders;

    // konstruktor třídy Server
    public Server() {
        try {
            this.serverSocket = new ServerSocket(8080);
            System.out.print("Spuštění serveru proběhlo úspěšně.\nČekám na připojení klienta...\n");
            this.clientBufReaders = new ConcurrentLinkedQueue<BufferedReader>();

            this.clients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(); // vytvoření instance třídy Server
    }

    private void clients() {
        Thread acceptThread = new Thread(() -> {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientBufReaders.add(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
                    System.out.println("Klient se připojil.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        acceptThread.start();

        while (true) {
            synchronized (clientBufReaders) {
                for (BufferedReader in : clientBufReaders) {
                    try {
                        if (in.ready()) {
                            System.out.println(in.readLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
