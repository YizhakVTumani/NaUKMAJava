import acm.graphics.*;
import acm.program.*;
import acm.util.ErrorException;

import java.awt.*;
import java.io.*;
import java.util.*;

//Author: Hella Nikita
//File: HelloProgram.java

public class HelloProgram extends ConsoleProgram {

    public void run(){
        do {
            int number = readInt("Please enter a number: ");
            intToString(number);
        }while(readInt("to repeat press 1: ") == 1);

        do{
            String str = readLine("Please enter a string: ");
            String strCh = readLine("Please enter a char: ");
            char ch = strCh.charAt(0);
            println("Res string is: " + removeAllOccurences(str, ch));
        }while(readInt("to repeat press 1: ") == 1);

        BufferedReader myR = fileToString("Print your name of the file: ");
        try {
            while (true){
                String s;
                s = myR.readLine();
                if (s==null) break;
                println(s);
            }
            myR.close();
        }catch (IOException e) {
            throw new ErrorException(e);
        }
    }


    private void intToString(int number){
        String res = "";
        String num = " " + number;
            for (int i = 1; i < num.length(); i++){
                    if (num.charAt(i - 1) != ' ' && num.charAt(i - 1) != '-' && (num.length() - i) % 3 == 0){
                        res = res + ',';
                    }
                res = res + num.charAt(i);
            }
        println(res);
    }


    public String removeAllOccurences(String str, char ch){
        String res = "";
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ch){
                res = res + str.charAt(i);
            }
        }
        return res;
    }


    private BufferedReader fileToString(String prompt){
        BufferedReader rd = null;
        while (rd == null){
            try{
                String name = readLine(prompt);
                rd = new BufferedReader( new FileReader(name));
            } catch (FileNotFoundException e){
                println("Exeption occurred while trying to open the file.");
                //e.printStackTrace();

            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return rd;
    }
}