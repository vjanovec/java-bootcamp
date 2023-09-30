package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) {
        // ASCII table
        // a = 097
        // z = 122

        // Phrase we want to encrypt
        String message = "moribundus";
        // Encryption password
        String password = "ahoj";
        System.out.println((0 % 20 - 'a' + 1));
        System.out.println("Encypted message: " + encyptMessage2(message, password));

    }

    public static String encyptMessage(String message, String password) {

        // Transfer String into character arrays
        char[] messageArray = message.toCharArray();
        char[] passwordArray = password.toCharArray();
        String newPassword = "";

        // Determinate which is longer
        if (messageArray.length < passwordArray.length) {
            System.out.println("Input < Password");
            // Input < Password

            // Calculate lenght difference between message and password
            int lenghtDiff = passwordArray.length - messageArray.length;
            // Short the password
            for (int i = 0; i < (passwordArray.length - lenghtDiff); i++) {
                newPassword += passwordArray[i];
            }
            return encypt(messageArray, newPassword.toCharArray());

        } else if (messageArray.length > passwordArray.length) {
            System.out.println("Input > Password");
            // Input > Password
            // Determinate how many times is Input longer than Password
            for (int i = 0; i < (messageArray.length / password.length()); i++) {
                for (char c : passwordArray) {
                    newPassword += c;
                }
            }
            // Calculate the remainder
            for (int i = 0; i < (messageArray.length % passwordArray.length); i++) {
                newPassword += passwordArray[i];
            }
            // Now we have message and password with the same lenght,
            // Lets encypt
            System.out.println("New shorter password: " + newPassword);

            return encypt(messageArray, newPassword.toCharArray());
        } else {
            System.out.println("Input = Password (length)");
            // Input = Password (length)
            return encypt(messageArray, passwordArray);
        }
    }

    //
    public static String encypt(char[] input, char[] password) {
        for (int i = 0; i < input.length; i++) {
            input[i] += (int) password[i] - 96;
            if (input[i] > 122) {
                input[i] -= 26;
            }
        }
        String encyptedMessage = "";
        for (char c : input) {
            encyptedMessage += c;
        }
        return encyptedMessage;
    }

    public static String encyptMessage2(String message, String password) {
        char[] newMessage = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int x = (int) password.charAt(i % password.length()) - 'a' + 1;
            newMessage[i] = message.charAt(i);
            if (newMessage[i] + x > 122) {
                newMessage[i] += x - 26;
            } else {
                newMessage[i] += x;
            }
        }
        return String.valueOf(newMessage);
    }
}
