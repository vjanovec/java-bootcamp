/*
 * File name: ClientHandler.java
 * Date:      2006/11/27 21:23
 * Author:    Jan Faigl
 */

import java.util.Date;
import java.net.Socket;
import java.io.IOException;

class ClientHandler extends ParseMessage implements Runnable {
   static final int UNKNOWN = -1;
   static final int TIME = 0;
   static final int BYE = 1;
   static final int NUMBER = 2;
   static final String[] STRCMD = {
      "time", "bye"
   }; 

   static int parseCmd(String str) {
       //System.out.println(str);
      int ret = UNKNOWN;
      str = str.trim();
      for (int i = 0; i < NUMBER; i++) {
	 if (str.compareTo(STRCMD[i]) == 0) {
	    ret = i;
	    break;
	 }
      }
      return ret;
   }


   Socket sock;
   int id;
   ClientHandler(Socket iSocket, int iID) throws IOException {
      sock = iSocket;
      id = iID;
      out = sock.getOutputStream();
      in = sock.getInputStream();
     
   }
   
   public void start() {
        new Thread(this).start();
   }

  void log(String str) {
     System.out.println(str);
  }

   @Override
   public void run() {
      String cID = "client["+id+"] ";
      try {
	 log(cID + "Accepted");
	 write("Login:");
	 log(cID + "Username:" + read("", "\n"));
	 write("Password:");
	 log(cID + "Password:" + read("", "\n"));
	 write("Welcome\n");
	 boolean quit = false;
	 while (!quit) {
	     String input = read("", "\n");
 	    switch(parseCmd(input)) {
	       case TIME:
		  write("time is:"+ new Date().toString() + "\n");
		  break;
	       case BYE:
		  log(cID + "Client sends bye");
		  quit = true;
		  break;
	       default:
	           // OWN MESSAGE
               char[] charArr = input.toCharArray();
               for(int i=0; i<charArr.length; i++) {
                   charArr[i] = (char) (charArr[i]-1);
               }
               log(cID + "Message: "+String.valueOf(charArr));
		  //log(cID + "Unknown message, disconnect");
		 // quit = true;
		  break;
	    }
	 }
	 sock.shutdownOutput();
	 sock.close();
      } catch (Exception e) {
	 System.out.println(cID + "Exception:" + e.getMessage());
	 e.printStackTrace();
      }
   }
}
