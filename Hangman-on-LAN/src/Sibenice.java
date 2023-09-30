/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lmasic
 */
public class Sibenice {
    
    public Sibenice(String word) {
        this.selectedWord = word;
        for(int i=0; i<word.length(); i++) {
            this.wordProgress+="_";
        }
    }

    private String selectedWord;
    private String wordProgress = "";
    private boolean finished = false;
    private int attemps = 0;


    public boolean isFinished() {
        return finished;
    }

    public int getAttemps() {
        return attemps;
    }

    public String getSelectedWord() {
        return selectedWord;
    }

    public String getWordProgress() {
        return wordProgress;
    }

    public static List<String> words = Arrays.asList("rtěnka", "štěnice", "pohovka", "žokej", "nehoda", "modelka", "pěšina", "melodie", "tíha", "svíčková");


    public String guess(char guess) {
//        System.out.println(this.selectedWord.indexOf(guess));
        if(this.selectedWord.indexOf(guess) != -1) {
            int index = selectedWord.indexOf(guess);
            while (index >= 0) {
//                System.out.println(index);
                char[] guessWord = this.wordProgress.toCharArray();
                guessWord[index] = guess;
                this.wordProgress = new String(guessWord);

                index = selectedWord.indexOf(guess, index + 1);
            }
            if(this.wordProgress.equals(selectedWord)) {
                this.finished = true;
            }



        }
        attemps++;
        return wordProgress;
    }
    
    public int status() {
    
        return 0;
    }
    
    
}
