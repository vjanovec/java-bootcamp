/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piskvorky2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author vojte
 */
public class AdjustableVersion extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public AdjustableVersion() {
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
    **/
    
    public static JButton[][] board;
    public static void setBoard(JButton[][] newBoard) {
        board = newBoard;
    }

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert x value: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("Insert y value: ");
        int y = Integer.parseInt(sc.nextLine());
        JFrame frame = new JFrame("Piškvorky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension((x*50), (y*50)));
        Container pane = frame.getContentPane();
        setBoard(new JButton[x][y]);
        pane.setLayout(new GridLayout(y, x));
        
        
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
        
        
    }

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
            for (int j = 0; j < board.length; j++) {
                // get nested arr
                // declare streaks
                int streakX = 0;
                int streakY = 0;
                // get nested arr
                for (int k = 0; k < board[0].length; k++) {
                    // X
                    if (board[j][k].getText() == icon) { 
                        streakX++;
                    }
                    // Y
//                    if (board[k][j].getText() == icon) {
//                        streakY++;
//                    }
//                    // Diag
//                    if (board[0][0].getText() == icon && board[1][1].getText() == icon && board[2][2].getText() == icon) {
//                        return true;
//                    }
//                    // Reverse diag
//                    if (board[0][2].getText() == icon && board[1][1].getText() == icon && board[2][0].getText() == icon) {
//                        return true;
//                    }
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
