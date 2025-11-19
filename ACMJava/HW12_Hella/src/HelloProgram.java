import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java


public class HelloProgram extends ConsoleProgram {

    public void run() {
        String str = readLine("Please enter your text: ");
        if (str == null || str.equals("")) {
            str = readLine("Please enter your text: ");
        }
        quantityOfWords(str);
        quantityOfNumbers(str);
//        strNoDoubleSpaces(str);
    }

    private void quantityOfWords(String str) {
        int quantityOfWords = 0;
        int lastWordIndex = 0;
        int thisWordIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                thisWordIndex = i;
                for (int j = lastWordIndex; j < thisWordIndex; j++) {
                    if ((str.charAt(j) >= ':' && str.charAt(j) <= '~') || (str.charAt(j) >= '=' &&  str.charAt(j) <= '/')) {
                        quantityOfWords++;
                        break;
                    }
                }
                lastWordIndex = i;
            }
        }
        println("You have " + quantityOfWords + " words in your text.");
    }

    private void quantityOfNumbers(String str) {
        int quantityOfWords = 0;
        int lastWordIndex = 0;
        int thisWordIndex = 0;
        boolean isNotANumber = false;
        for (int i = 0; i < str.length(); i++) {
            isNotANumber = false;
            if (str.charAt(i) == ' ') {
                thisWordIndex = i;
                for (int j = lastWordIndex; j < thisWordIndex; j++) {
                    if ((str.charAt(j) >= ':' && str.charAt(j) <= '~') || (str.charAt(j) > ' ' &&  str.charAt(j) <= '/')) {
                        isNotANumber = true;
                        break;
                    }
                }
                if (!isNotANumber)
                {
                    quantityOfWords++;
                }
                lastWordIndex = thisWordIndex;
            }

        }
        println("You have " + quantityOfWords + " numbers in your text.");
    }

    private void strOnlyLetters() {

    }

//    private String strNoDoubleSpaces(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
//
//            }
//        }
//    }

    private void strOnlyCapLettersWords() {

    }

}