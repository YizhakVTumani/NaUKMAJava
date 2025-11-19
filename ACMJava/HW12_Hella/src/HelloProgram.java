import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.Locale;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Написати програму, що зчитує з клавіатури стрічку і повертає одразу всі результати (кожен пункт оформити у вигляді методу)
//
//кількість слів (в слові можуть зустрічатися: тільки літери; тільки символи; літери+символи+цифри; літери+символи; літери+цифри; символи(окрім крапки та коми)+цифри; якщо відділені пропусками символи цифри, або цифри та кома чи крапка, то даний ланцюжок є числом)
//кількість чисел
//стрічку в якій прибрані усі символи крім літер
//стрічку в якій множинні проміжки перетворені в один проміжок ("А   пр" ="А пр")
//стрічку яка містить лише слова, що починаються з великої літери ("А   пр" ="А")
public class HelloProgram extends ConsoleProgram {

    public void run() {
//        String str = readLine("Please enter your text: ");
//        if (str == null || str.equals("")) {
//            str = readLine("Please enter your text: ");
//        }
        String str = "Rdhfjf   DGFFHGDDF!!!##  f555     12345     23456.345     98765,678   345d46  dfg456fgh   2345.2345.4567    456,456,567,567   ASD345   ZXC!   @#$%    !@#$%^ ";
        quantityOfWords(str);
        quantityOfNumbers(str);
        strNoDoubleSpaces(str);
//        strOnlyLetters(str);
        strOnlyCapLettersWords(str);
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
    } // quantify words

    private void quantityOfNumbers(String str) {
        int quantityOfWords = 0;
        int lastWordIndex = 0;
        int thisWordIndex = 0;
        boolean isNotANumber = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {

                while(i < str.length() && str.charAt(i) == ' '){
                    i++;
                }
                thisWordIndex = i;
                isNotANumber = false;
                for (int j = lastWordIndex; j < thisWordIndex; j++) {
                    if ((str.charAt(j) >= ':' && str.charAt(j) <= '~') || (str.charAt(j) > ' ' &&  str.charAt(j) <= '+')) {
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
    } // quantify numbers

    private void strOnlyLetters(String str) {
        String res = "";
        int startOfTheWord = 0;
        for (int i = 0; i < str.length(); i++) {
            while (i < str.length() && ((str.charAt(i) >= 'A' && str.charAt(i) <= 'z'))) {
                for (int j = startOfTheWord; j < i; j++) {
                    res = res + str.charAt(j);
                }
//                i ++;
                startOfTheWord = i;
            }
        }
        println(res);
    } // quantify only letters

    private void strNoDoubleSpaces(String str) {
        String res = "";
        int startOfTheWord = 0;
        for (int i = 0; i < str.length(); i++) {
            while (i+1 < str.length() && str.charAt(i) == ' ' && str.charAt(i + 1) == ' ') {
                for (int j = startOfTheWord; j < i; j++) {
                    res = res + str.charAt(j);
                }
                i ++;
                startOfTheWord = i;
            }
        }
        println(res);
    } // deletes double spaces

    private void strOnlyCapLettersWords(String str) { // leaves only cap let words
        String res = "";
        int startOfTheWord = 0;
        int endOfTheWord = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                while(i < str.length() && str.charAt(i) == ' '){
                    i++;
                }
                endOfTheWord = i;
                if (str.charAt(startOfTheWord) >= 'A' && str.charAt(startOfTheWord) <= 'Z') {
                    for (int j = startOfTheWord; j < endOfTheWord; j++) {
                        res = res + str.charAt(j);
                    }

                }
                startOfTheWord = endOfTheWord;
            }
        }
        println(res);
    }
}