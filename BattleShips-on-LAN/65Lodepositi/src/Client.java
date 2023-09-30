
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lmasic
 */
public class Client {

    private ArrayList<String> ActiveHosts = new ArrayList<String>();
    private static final int port = 8086;

    public Client() {

    }

    private boolean Connect(String host, int port) {

        try {
            Socket s = new Socket(host, port);
            s.setSoTimeout(5*1000);
            s.close();
            return true;
        } catch (IOException ex) {
            return false;
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void scan(String ip, int min, int max, int port) {

        for (int i = min; i <= max; i++) {

            System.out.print(ip + i + ": ");
            if (this.Connect(ip + i, port)) {
                System.out.println("Ok");
                setNum(String.valueOf(i));
                Thread connection = new Thread(() -> contact(ip + getNum()));
                connection.start();
                this.ActiveHosts.add(ip + i);
            } else {
                System.out.println("NOk");
            }

        }
    }
    public void contactAll(List<String> hosts) {
        hosts.stream().forEach(this::contact);
    }

    public void contact(String host) {
        try {
            System.out.println("Starting client");
            Socket s = new Socket(host, port);
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            String serverName = (String) in.readObject();
            System.out.println(serverName);

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            Object objectToSend = new Car("Tesla", "Model X", 2020, "Engine", 300);
            out.writeObject(objectToSend);
            out.flush();


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Connecting terminated");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
