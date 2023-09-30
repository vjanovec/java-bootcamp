package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // Triangle
        String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Nulla est. Suspendisse sagittis ultrices augue. Curabitur sagittis hendrerit ante. Morbi leo mi, nonummy eget tristique non, rhoncus non leo. Mauris metus. Nullam lectus justo, vulputate eget mollis sed, tempor sed magna. Maecenas ipsum velit, consectetuer eu lobortis ut, dictum at dui. Nulla non lectus sed nisl molestie malesuada. Maecenas fermentum, sem in pharetra pellentesque, velit turpis volutpat ante, in pharetra metus odio a lectus. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Integer malesuada. Duis viverra diam non justo. Fusce suscipit libero eget elit. Nunc auctor. Curabitur vitae diam non enim vestibulum interdum. Suspendisse nisl. Praesent id justo in neque elementum ultrices.\n" +
                "\n" +
                "Curabitur ligula sapien, pulvinar a vestibulum quis, facilisis vel sapien. Nulla accumsan, elit sit amet varius semper, nulla mauris mollis quam, tempor suscipit diam nulla vel leo. Vivamus porttitor turpis ac leo. Duis pulvinar. Nam quis nulla. Etiam ligula pede, sagittis quis, interdum ultricies, scelerisque eu. Proin pede metus, vulputate nec, fermentum fringilla, vehicula vitae, justo. Aenean placerat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos hymenaeos. Aliquam id dolor. Integer vulputate sem a nibh rutrum consequat. Morbi imperdiet, mauris ac auctor dictum, nisl ligula egestas nulla, et sollicitudin sem purus in lacus. Curabitur sagittis hendrerit ante. Maecenas libero. Integer malesuada. Duis sapien nunc, commodo et, interdum suscipit, sollicitudin et, dolor. Vivamus porttitor turpis ac leo. Fusce suscipit libero eget elit. Duis ante orci, molestie vitae vehicula venenatis, tincidunt ac pede. Nam quis nulla.";
        textAnalysis(text);
    }

    // Triangle
    // ruznostranny
    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }

    // rovnorameny
    public static double trianglePerimeter(double a, double b) {
        return a + (b * 2);
    }

    // rovnostranny
    public static double trianglePerimeter(double a) {
        return a * 3;
    }

//    public static double triangleAria() {
//        return 0;
//    }


    // stěnová uhlopricka
    public static double cuboidDiagonal(double a, double b, double c) {
        return Math.sqrt(a * a + b * b);
    }

    // telesova uhlopricka
    public static double cuboidDiagonal2(double a, double b, double c) {
        return Math.sqrt(a * a + b * b + c * c);
    }





    public static void textAnalysis(String sentence) {
        // length
        int sentenceLenght = sentence.length();
        System.out.println("length: "+sentenceLenght);
        // number of words
        String[] arr = sentence.split("\\s");
        int numOfWords = arr.length;
        System.out.println("Number of words: "+numOfWords);
        // gaps
        int gaps = 0;
        for(char c : sentence.toCharArray()) {
            if(c == ' ') {
                gaps++;
            }
        }
        System.out.println("Number of gaps: "+gaps);
    }
}
