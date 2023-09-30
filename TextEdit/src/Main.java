import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Rozveselovac textu
        String sentence = "Prvni veta. Druha veta? Treti veta a dalsi! Uz me to nebavi. Nejsem moc kreativni? Dalsi veta s teckou. Posledni veta!";
        String smile = "";
        String smile1 = " :)";
        String smile2 = " :D";
        String smile3 = " :P";
        int index = 0;
        int count = 0;
        String newSentence = "";

        while (sentence.indexOf('.', index) != -1) {
            char[] sentenceArr = sentence.toCharArray();

            index = sentence.indexOf(".");
            switch (count % 3) {
                case 0:
                    smile = smile1;
                    break;
                case 1:
                    smile = smile2;
                    break;
                case 2:
                    smile = smile3;
                    break;
            }
            count++;
            newSentence = String.valueOf(Arrays.copyOfRange(sentenceArr, 0, index)) + smile + String.valueOf(Arrays.copyOfRange(sentenceArr, index + 1, sentenceArr.length));
            sentence = newSentence;
            System.out.println(newSentence);
        }

        while (sentence.indexOf('!') != -1) {
            char[] sentenceArr = sentence.toCharArray();
            index = sentence.indexOf('!');
            switch (count % 3) {
                case 0:
                    smile = smile1;
                    break;
                case 1:
                    smile = smile2;
                    break;
                case 2:
                    smile = smile3;
                    break;
            }
            count++;
            newSentence = String.valueOf(Arrays.copyOfRange(sentenceArr, 0, index)) + smile + String.valueOf(Arrays.copyOfRange(sentenceArr, index + 1, sentenceArr.length));
            sentence = newSentence;
            System.out.println(newSentence);
        }

        while (sentence.indexOf('?') != -1) {
            char[] sentenceArr = sentence.toCharArray();
            index = sentence.indexOf('?');
            switch (count % 3) {
                case 0:
                    smile = smile1;
                    break;
                case 1:
                    smile = smile2;
                    break;
                case 2:
                    smile = smile3;
                    break;
            }
            count++;
            newSentence = String.valueOf(Arrays.copyOfRange(sentenceArr, 0, index)) + smile + String.valueOf(Arrays.copyOfRange(sentenceArr, index + 1, sentenceArr.length));
            sentence = newSentence;
            System.out.println(newSentence);
        }

        // Šachovnice
        int x = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x % 2 == 0) {
                    System.out.print("█");
                } else {
                    System.out.print("  ");
                }
                x++;

            }
            x++;
            System.out.print("\n");
        }

    }
}
