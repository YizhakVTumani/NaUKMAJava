import acm.graphics.*;
import acm.program.*;
import acm.util.ErrorException;

import java.awt.*;
import java.io.*;
import java.util.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Великі числа при друку прийнято розділяти комами. Так наприклад число один мільйон при друку має виглядати - 1,000,000. Напишіть програму, що на вхід приймає число (саме число, INT), а на вихід виводить число в наведеному вище форматі. Числа мають зчитуватися до тих пір, поки користувач не введе 0. String.valueOf використовувати не можна.
//Написати клас який реалізує метод, що видаляє заданий символ з стрічки і повертає результат:
//public String removeAllOccurences(String str, char ch);
//Написати програму, що читає текстову інформацію з файлу і виводить на екран
//Написати програму, що шукає в тексті файлу задану фразу і виводить інформацію про її наявність та кількість.

public class HelloProgram extends ConsoleProgram {

    public void run() {
        do {
            int number = readInt("Please enter a number: ");
            intToString(number);
        } while (readInt("to repeat press 1: ") == 1);

        do {
            String str = readLine("Please enter a string: ");
            String strCh = readLine("Please enter a char: ");
            char ch = strCh.charAt(0);
            println("Res string is: " + removeAllOccurences(str, ch));
        } while (readInt("to repeat press 1: ") == 1);

        BufferedReader myR = fileToString("Print your name of the file: ");
        String s;
        try {
            while (true) {
                s = myR.readLine();
                if (s == null) break;
                println(s);
            }
            myR.close();
        } catch (IOException e) {
            throw new ErrorException(e);
        }



        String text = "";
        BufferedReader myS = fileToString("Print your name of the file: ");
        try {
            while (true) {
                s = myS.readLine();
                text = text + s;
                if (s == null) break;
//                findSubstring(s);
            }
            findSubstring(text);
            myS.close();
        } catch (IOException e) {
            throw new ErrorException(e);
        }

    }



    private void intToString(int number) {
        String res = "";
        String num = " " + number;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) != ' ' && num.charAt(i - 1) != '-' && (num.length() - i) % 3 == 0) {
                res = res + ',';
            }
            res = res + num.charAt(i);
        }
        println(res);
    } // creates coma between numbers

    public String removeAllOccurences(String str, char ch) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                res = res + str.charAt(i);
            }
        }
        return res;
    } // removes all occurences of the char

    private BufferedReader fileToString(String prompt) {

        BufferedReader rd = null;
        while (rd == null) {
            try {
//                String name = readLine(prompt);
                String name = "file.txt";
                rd = new BufferedReader(new FileReader(name));
            } catch (FileNotFoundException e) {
                println("Exeption occurred while trying to open the file.");
//                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rd;
    } // prints the text of the file

    private void findSubstring(String s) {
        int counterOfOccurences = 0;
        String findSub = readLine("Enter a string: ");
        while (findSub.isEmpty()) {
            findSub = readLine("Enter a string: ");
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == findSub.charAt(0)) {
                int f = 0;
                int startOfTheWord = i;
                while (i < s.length() && f < findSub.length() && s.charAt(i) == findSub.charAt(f)) {
                    f++;
                    i++;
                    if (findSub.length() == i-startOfTheWord) {
                        counterOfOccurences++;
                        break;
                    }
                }
            }
        }
        println("You`ve got " + counterOfOccurences + " occurrences of this line;");
    } // counts occurrences of the substring
}
