package com.vojtechjanovc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer extends Player {

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public int[] chooseTile() {
        try {
            Scanner sc = new Scanner(System.in, "UTF-8");
            System.out.println(super.getName()+"\'s turn!");
            System.out.println("Insert x position");
            int xPosition = sc.nextInt();
            System.out.println("Insert y position");
            int yPosition = sc.nextInt();
            int[] position = {xPosition, yPosition};
            return position;
        } catch (InputMismatchException e) {
            System.out.println("Insert only numbers!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException!");

        }
        return null;
    }
    }
