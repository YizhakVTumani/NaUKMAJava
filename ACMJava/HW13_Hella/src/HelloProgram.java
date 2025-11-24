import acm.graphics.*;
import acm.program.*;
import acm.util.ErrorException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java


public class HelloProgram extends ConsoleProgram {

    public void run() {


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
                text = text + '\n' + s;
                if (s == null) break;
            }
            println(removeAllOccurences(text));
            myS.close();
        } catch (IOException e) {
            throw new ErrorException(e);
        }

    }


    public String removeAllOccurences(String text) {
        String find = readLine("Enter a line you want to be replaced: ");
        String replace = readLine("Enter a line you want to replace: ");
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            int startOfTheWord = 0;
            int f = 0;
            boolean found = false;
            if (text.charAt(i) == find.charAt(0)) {
                startOfTheWord = i - 1;
                while (i < text.length() && f < find.length() && text.charAt(i) == find.charAt(f)) {
                    f++;
                    i++;
                    if (find.length() == i - startOfTheWord) {
                        res = res + replace + " ";
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    i = startOfTheWord + 1;
                    res = res + text.charAt(i);
                }
            }
            else{
                res = res + text.charAt(i);
            }
        }
        return res;
    }


    private BufferedReader fileToString(String prompt) {

        BufferedReader rd = null;
        while (rd == null) {
            try {
//                String name = readLine(prompt);
                String name = "file.txt";
                rd = new BufferedReader(new FileReader(name));
            } catch (FileNotFoundException e) {
                println("Exeption occurred while trying to open the file.");
                //e.printStackTrace();

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