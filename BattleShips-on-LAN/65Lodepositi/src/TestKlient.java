

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmasic
 */
public class TestKlient {
    private int port=8086;

    public TestKlient(int port) throws IOException {
        this.port=port;
        
            Car rapid = new Car("škoda", "Rapid", 1996, "chcípáček",140);
            Socket s = new Socket("localhost", port);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            Object objectToSend = rapid;
            out.writeObject(objectToSend);
            out.flush();
        
    }
    
    
}
