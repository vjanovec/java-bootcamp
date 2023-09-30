/*
 * File name: Client.java
 * Date:      2006/11/27 21:12
 * Author:    Jan Faigl
 */

import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Client extends ParseMessage {

    Socket sock;

    Client(String host, int port) {
        try {
            sock = new Socket();
            sock.connect(new InetSocketAddress(host, port));
            out = sock.getOutputStream();
            in = sock.getInputStream();
            write("user\n");
            read("", "Password:");
            System.out.println("Password prompt readed");
            write("heslo\n");
            read("", "Welcome\n");
            write("time\n");
            out.flush();
            System.out.println("Time on server is " + read("time is:", "\n"));
            Scanner sc = new Scanner(System.in);
            String msg = "";
            while(msg != "bye") {
                msg = sc.nextLine();
                char[] msgArr = msg.toCharArray();
                for(int i = 0; i<msgArr.length; i++) {
                    msgArr[i] = (char) (msgArr[i]+1);
                }
                write(String.valueOf(msgArr) +"\n");
            }

            write("bye\n");
            sock.shutdownOutput();
            sock.close();
            System.out.println("Communication END");
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client c = new Client(
                args.length > 0 ? args[0] : "localhost",
                args.length > 1 ? Integer.parseInt(args[1]) : 8080
        );
    }
}
