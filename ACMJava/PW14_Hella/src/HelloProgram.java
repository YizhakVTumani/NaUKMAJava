import acm.graphics.*;
import acm.program.*;
import acm.util.ErrorException;

import java.awt.*;
import java.io.*;
import java.util.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Написати програму, що шукає в тексті файлу задану фразу і виводить інформацію про її наявність та кількість.

public class HelloProgram extends ConsoleProgram {

    public void run() {
        String s;
        String text = "";
        BufferedReader myS = fileToString("Print your name of the file: ");
        try {
            while (true) {
                s = myS.readLine();
                text = text + s;
                if (s == null) break;
            }
            findSubstring(text);
            myS.close();
        } catch (IOException e) {
            throw new ErrorException(e);
        }
    }

    private BufferedReader fileToString(String prompt) {

        BufferedReader rd = null;
        while (rd == null) {
            try {
                String name = "file.txt";
                rd = new BufferedReader(new FileReader(name));
            } catch (FileNotFoundException e) {
                println("Exeption occurred while trying to open the file.");

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

        String wordFind = "";
        for (int i = 0; i < findSub.length(); i++) {
            if(findSub.charAt(i) != ' ')
            {
                wordFind = wordFind + findSub.charAt(i);
            }
            else {
                break;
            }

        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == wordFind.charAt(0)) {
                int f = 0;
                int startOfTheWord = i;
                while (i < s.length() && f < wordFind.length() && s.charAt(i) == wordFind.charAt(f)) {
                    f++;
                    i++;
                    if (wordFind.length() == i-startOfTheWord) {
                        counterOfOccurences++;
                        break;
                    }
                }
            }
        }
        println("You`ve got " + counterOfOccurences + " occurrences of this line;");
    } // counts occurrences of the substring
}
