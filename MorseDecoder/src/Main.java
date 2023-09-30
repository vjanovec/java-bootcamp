public class Main {

    public static void main(String[] args) {
        String abecedniZnaky = "abcdefghijklmnopqrstuvwxyz";
        String[] morseovyZnaky = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};

        // řetězec, který chceme dekódovat
        String s = ".. - -. . - .-- --- .-. -.-";
        System.out.printf("Původní zpráva: %s\n", s);
        // řetězec s dekódovanou zprávou
        String zprava = "";

        String[] morseChars = s.split(" ");
        for (String moreseChar : morseChars) {
            for(int i=0; i<morseovyZnaky.length; i++) {
                if(moreseChar.equals(morseovyZnaky[i])) {
                    zprava += abecedniZnaky.charAt(i);
                    break;
                }
            }
        }
        System.out.println(zprava);

        String message = "itstep";
        String encodedMessage = "";
        String[] morseovka = new String[s.length()];
        for(char c : message.toCharArray()) {
            for(int i=0; i<abecedniZnaky.length(); i++) {
                if(c == abecedniZnaky.charAt(i)) {
                    encodedMessage += morseovyZnaky[i]+" ";
                    break;
                }
            }
        }

        char star = '*';
        for(int i=0; i<6; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(star);
            }
            System.out.print("\n");
        }

    }
}
