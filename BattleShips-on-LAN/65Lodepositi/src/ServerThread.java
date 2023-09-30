/*
 * ServerThread.java
 *
 * Created on 24. duben 2007, 0:28
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
public class ServerThread extends Thread implements CreateObject {

    private Socket socket = null;
   

    /**
     * Creates a new instance of ServerThread
     */
    public ServerThread(Socket socket) {
        super("ServerThread");
        this.socket = socket;
      

    }

    public void run() {
        Object objectReceived;
        try {
//            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//            writer.write("Vojtaa");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            String serverName = "Vojtaa";
            out.writeObject(serverName);
            out.flush();


            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            objectReceived =  in.readObject();
            Object objectInstatiated = getObject(objectReceived);
            System.out.println("\n"+objectInstatiated);

//            System.out.println(objectReceived.getClass().getName());

            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Object getObject(Object objectReceived) {

        switch(objectReceived.getClass().getName()) {
            case "Car": {
                return (Car) objectReceived;

            }
            case "Cruiser": {
                return (Cruiser) objectReceived;

            }
            case "Diplomatico": {
                return (Diplomatico) objectReceived;
            }
            case "Dock": {
                return (Dock) objectReceived;
            }
            case "Engine": {
                return (Engine) objectReceived;
            }
            case "Flotile": {
                return (Flotile) objectReceived;
            }
            case "RecueShip": {
                return (RecueShip) objectReceived;
            }
            case "Sea": {
                return (Sea) objectReceived;
            }
            case "Ship": {
                return (Ship) objectReceived;
            }
            case "Simulator": {
                return (Simulator) objectReceived;
            }
            default: {
                System.out.println("Unknown object");
            }
        }
        return null;
    }

}
