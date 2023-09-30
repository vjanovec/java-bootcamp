/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piskvorkySockety2;

import com.mycompany.piskvorky.*;
import com.mycompany.piskvorky2.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author vojte
 */
public class SocketVersionClient extends javax.swing.JFrame {

    public final static int SOCKET_PORT = 25565;
    public final static String SERVER = "127.0.0.1";
    static Socket sock = null;
    static ObjectInputStream in = null;
    static String position = "";
    public final static int FILE_SIZE = 6022386;
    static int bytesRead;
    static int current = 0;

    /**
     * Creates new form Main
     */
    public SocketVersionClient() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static JButton[][] board = new JButton[3][3];

    public static void main(String args[]) {

        JFrame frame = new JFrame("Piškvorky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(320, 320));
        Container pane = frame.getContentPane();
        pane.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < board.length; i++) { // x - horizontal
            for (int j = 0; j < board[0].length; j++) { // y - vertical
                board[i][j] = new JButton();
                board[i][j].addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText() == "") {
                            ((JButton) e.getSource()).setText(setIcon());
                        }
                        System.out.println(gameEnd());
                    }
                });
                pane.add(board[i][j]);
            };
        }
        frame.setVisible(true);
        client.start();
    }

    static Thread client = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    sock = new Socket(SERVER, SOCKET_PORT);
                    System.out.println("Connecting...");
                    while (true) {
                        byte[] mybytearray = new byte[FILE_SIZE];
                        InputStream is = sock.getInputStream();
                        // Method for deserialization of object
                        bytesRead = is.read(mybytearray, 0, mybytearray.length);
                        current = bytesRead;

//                    do {
//                        bytesRead
//                                = is.read(mybytearray, current, (mybytearray.length - current));
//                        if (bytesRead >= 0) {
//                            current += bytesRead;
//                        }
//                    } while (bytesRead > -1);
                        //ByteArrayInputStream byt = new ByteArrayInputStream(mybytearray);
                        in = new ObjectInputStream(is);
                        System.out.println("one more time");
                        position = (String) in.readObject();
                        if (position != null) {
                            String[] positionValues = position.split("");
                            board[Integer.parseInt(positionValues[0])][Integer.parseInt(positionValues[1])].setText(positionValues[2]);
                            System.out.println("Object has been deserialized ");
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(SocketVersionClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SocketVersionClient.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (sock != null) {
                    try {
                        sock.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SocketVersionClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SocketVersionClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    });

    public static String lastIcon = "X";

    public static String setIcon() {
        if (lastIcon == "X") {
            lastIcon = "O";
        } else {
            lastIcon = "X";
        }
        return lastIcon;
    }

    public static ArrayList<String> icons = new ArrayList<>(Arrays.asList("X", "O"));

    public static boolean gameEnd() {
        // 2 players = 2 times repeat
        for (String icon : icons) {
            // get fist arr
            for (int j = 0; j < 3; j++) {
                // get nested arr
                // declare streaks
                int streakX = 0;
                int streakY = 0;
                // get nested arr
                for (int k = 0; k < 3; k++) {
                    // X
                    if (board[j][k].getText() == icon) {
                        streakX++;
                    }
                    // Y
                    if (board[k][j].getText() == icon) {
                        streakY++;
                    }
                    // Diag
                    if (board[0][0].getText() == icon && board[1][1].getText() == icon && board[2][2].getText() == icon) {
                        return true;
                    }
                    // Reverse diag
                    if (board[0][2].getText() == icon && board[1][1].getText() == icon && board[2][0].getText() == icon) {
                        return true;
                    }
                }
                if (streakX == 3 || streakY == 3) {
                    return true;
                }
            }

        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
