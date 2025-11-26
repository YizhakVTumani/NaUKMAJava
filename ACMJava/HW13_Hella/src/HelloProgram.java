import acm.graphics.*;
import acm.program.*;
import acm.util.ErrorException;

import java.awt.*;
import java.io.*;
import java.util.Locale;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Написати програму, що замінює підстрічку в файлі заданою стрічкою. Всі входження.
//Написати програму, що копіює зміст текстового файлу в інший з розширення ".bak". Назва нового файлу вводиться користувачем.
//Написати програму, що відкриває файл на читання і формує два інших файли. Перший файл формується з непарних стрічок початкового файлу, а інший з парних.
//Здійснити шифрування файлу використовуючи зсув символів. Зсув вводиться користувачем.
//Здійснити розшифрування файлу зашифрованого вище

public class HelloProgram extends ConsoleProgram {

    public void run() {
        String s;
        String text = "";
        BufferedReader myS = fileToString("Print your name of the file: ");
        try {
            while (true) {
                s = myS.readLine();

                if (s == null) break;
                text = text + '\n' + s;
            }
            println(removeAllOccurences(text));
            myS.close();
        } catch (IOException e) {
            throw new ErrorException(e);
        } // замінює підстрічку в файлі заданою стрічкою


        BufferedReader myR = fileToString("Print your name of the file: ");
        try{
            PrintWriter wr = new PrintWriter(new FileWriter(readLine("Enter your new name: ") + ".bak"));
            while (true){
                s = myR.readLine();
                if (s==null) break;
                println(s);
                wr.println(s);
            }
            myR.close();
            wr.close();
        }catch (IOException e){
            throw new ErrorException(e);
        } // копіює зміст текстового файлу в інший з розширення ".bak"


        BufferedReader myF = fileToString("Print your name of the file: ");
        int i = 2;
        try{
            PrintWriter wr = new PrintWriter(new FileWriter(readLine("Enter your new name: ") + ".txt"));
            PrintWriter wr1 = new PrintWriter(new FileWriter(readLine("Enter your new name: ") + ".txt"));
            while (true){
                s = myF.readLine();
                if (s==null) break;
                if(i % 2 == 0){
                    wr.println(s);
                }
                else{
                    wr1.println(s);
                }
                i++;
            }
            myF.close();
            wr.close();
            wr1.close();
        }catch (IOException e){
            throw new ErrorException(e);
        } // відкриває файл на читання і формує два інших файли


        BufferedReader myT = fileToString("Print your name of the file: ");
        int zsuv = readInt("Enter your zsuv: ");
        try{
            PrintWriter wr = new PrintWriter(new FileWriter(readLine("Enter your new name: ") + "chifred.txt"));
            while (true){
                String chifred = "";
                s = myT.readLine();
                if (s==null) break;
                for (int j = 0; j < s.length(); j++){

                    char ch = (char) (s.charAt(j) + zsuv);
                    while (ch >= 127){
                        ch = (char) (ch - 127);
                    }
                    chifred = chifred + ch + " ";
                }
                wr.println(chifred);
            }
            myT.close();
            wr.close();
        }catch (IOException e){
            throw new ErrorException(e);
        } // шифрування файлу використовуючи зсув символів

        BufferedReader myO = fileToString("Print your name of the file: ");
        try{
            PrintWriter wr = new PrintWriter(new FileWriter(readLine("Enter your new name: ") + "UNchifred.txt"));
            while (true){
                String unChifred = "";
                s = myO.readLine();
                if (s==null) break;
                for (int j = 0; j < s.length(); j++){
                    if (s.charAt(j) != ' '){
                        char ch = (char) (s.charAt(j) - zsuv);
                        unChifred = unChifred + ch + " ";
                    }
                }
                wr.println(unChifred);
            }
            myO.close();
            wr.close();
        }catch (IOException e){
            throw new ErrorException(e);
        } // розшифрування файлу

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
                String name = readLine(prompt);
//                String name = "file.txt";
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


}