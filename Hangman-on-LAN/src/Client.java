import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() {
    }

    public static void main(String[] args) {
        connect("localhost", 4444);
    }

    static Scanner sc = new Scanner(System.in);

    public static void connect(String host, int port) {
        try {
            System.out.println("Starting client");
            Socket socket = new Socket(host, port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            String inputLine, outputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                break;
            }
            while(true) {
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    break;
                }
                outputLine=sc.nextLine();
                out.println(outputLine);
            }

//            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//            String serverName = (String) in.readObject();
//            System.out.println(serverName);
//
//            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
////            Object objectToSend = new Sibenice();
////            out.writeObject(objectToSend);
//            out.flush();




//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
