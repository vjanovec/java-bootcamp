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
    private Sibenice sibenice = null;
    public int minAttemps = Integer.MAX_VALUE;
    
    /** Creates a new instance of ServerThread */
    public ServerThread(Socket socket, Sibenice sibenice) {
        super("ServerThread");
	this.socket = socket;
	this.sibenice = sibenice;

    }
    
    public void run() {

	try {
		System.out.println("Hráč se připojil");

	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));


	    String inputLine, outputLine;
	    outputLine="Sibenice";
	    out.println(outputLine);

			while(!sibenice.isFinished()) {
				out.println("Hledane slovo: "+sibenice.getWordProgress());
				while ((inputLine = in.readLine()) != null) {
					if(inputLine.length() == 1) {
						sibenice.guess(inputLine.charAt(0));
					}
					break;
				}
			}
		out.println("Našel jsi hledané slovo: "+sibenice.getSelectedWord());
		System.out.println("Finished");
//		if(sibenice.getAttemps() < minAttemps) {
//			minAttemps = sibenice.getAttemps();
//		}
		System.out.println("Vaše skore: "+sibenice.getAttemps());



//
//	    while ((inputLine = in.readLine()) != null) {
//		if (inputLine.equals("Bye."))
//		    break;
////                out.println(sb.Ges(inputLine));
//
//		out.println(outputLine);
//
//	    }
	    out.close();
	    in.close();
	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}

