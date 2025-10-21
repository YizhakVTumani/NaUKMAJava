import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.awt.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Реалізувати програму з лекції Ханойські вежі.
// З клавіатури вводиться число дисків на першій голці й голка на яку необхідно перенести диски.
// Ваша програма має вивести на екран послідовність дій для перенесення дисків.
// Та кількість кроків.

public class HelloProgram2 extends ConsoleProgram {
    public void run() {
        setFont(new Font("Times New Roman", Font.BOLD, 20));
        do{
            int n = readInt("Enter the quantity of the disks: ");
            int startRode = readInt("Enter the first rode: ");
            int endRode = readInt("Enter the last rode: ");
            println("It takes " + (Math.pow(2, n)-1) + " moves.");
            hanoyanTower(n, startRode, endRode);
        }while(readInt("if you want to repeat type 0: ") == 0);
    }
    private void hanoyanTower(int n, int startRode, int endRode){
        if (n == 1){
            println(startRode + " --> " + endRode);
        }
        else{
            int other = 6 - (startRode + endRode);
            hanoyanTower(n-1, startRode, other);
            println(startRode + " --> " + endRode);
            hanoyanTower(n-1, other, endRode);
        }
    }
}