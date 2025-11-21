import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

public class HelloProgram extends ConsoleProgram {

    public void run(){
        do {
            int number = readInt("Please enter a number: ");
            intToString(number);
        }while(readInt("to repeat press 1: ") == 1);
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
}