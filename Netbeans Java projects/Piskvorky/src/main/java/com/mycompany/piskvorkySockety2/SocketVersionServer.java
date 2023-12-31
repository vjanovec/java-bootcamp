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
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
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
public class SocketVersionServer extends javax.swing.JFrame {

    static ServerSocket servsock = null;
    static Socket sock = null;
    static ObjectOutputStream oos = null;
    public final static int SOCKET_PORT = 25565;
    static int i;
    static int j;
    static String position = null;
    
    public static void setPosition(String position) {
        SocketVersionServer.position = position;
    }

    public static int getI() {
        return i;
    }

    public static int getJ() {
        return j;
    }
    
    
    

    /**
     * Creates new form Main
     */
    public SocketVersionServer() {
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
                i=i;
                j=j;
                board[i][j] = new JButton();
                board[i][j].addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText() == "") {
                            
                            ((JButton) e.getSource()).setText(setIcon());
                            setPosition(getI()+getJ()+((JButton) e.getSource()).getText());
                            synchronized(board) {
                                //notifyAll();
                            }
                        }
                        System.out.println(gameEnd());
                        
                    }
                });
                pane.add(board[i][j]);
            };
        }
        frame.setVisible(true);
        server.start();
    }

    static Thread server = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Waiting...");

                    try {
                        servsock = new ServerSocket(SOCKET_PORT);
                        sock = servsock.accept();
                        while(true) {
                        System.out.println("Accepted connection : " + sock);

                        oos = new ObjectOutputStream(sock.getOutputStream());
                        oos.writeObject(position);
                        oos.flush();
                        System.out.println("Done.");
                        synchronized(board) {
                            Thread.currentThread().sleep(1000);
                        }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(SocketVersionServer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SocketVersionServer.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {

                        if (sock != null) {
                            try {
                                sock.close();
                            } catch (IOException ex) {
                                Logger.getLogger(SocketVersionServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (oos != null) {
                            try {
                                oos.close();
                            } catch (IOException ex) {
                                Logger.getLogger(SocketVersionServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            } finally {
                if (servsock != null) {
                    try {
                        servsock.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SocketVersionServer.class.getName()).log(Level.SEVERE, null, ex);
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
