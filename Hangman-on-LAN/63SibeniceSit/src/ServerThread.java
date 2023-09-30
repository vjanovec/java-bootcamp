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

/**
 *
 * @author balikm1
 */
public class ServerThread extends Thread {
    
    private Socket socket = null;
    
    /** Creates a new instance of ServerThread */
    public ServerThread(Socket socket) {
        super("ServerThread");
	this.socket = socket;
    }
    
    public void run() {

	try {
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));

	    String inputLine, outputLine;
	    
	    outputLine="Sibenice";
	    out.println(outputLine);
            
            Sibenice sb  = new Sibenice();
            
	    while ((inputLine = in.readLine()) != null) {
		if (inputLine.equals("Bye."))
		    break;
                out.println(sb.Ges(inputLine));
                
		out.println(outputLine);
		
	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}

