import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Кількість кубиків, що кидає кожен гравець визначається на початку гри. Кількість сторін у кубика також задається на початку гри.
//
//Реалізувати можливість вибору:
//
//1) гра може тривати визначену кількість кроків,
//2) після кожного ходу питається у гравців, чи продовжувати гру.
//Виводяться також всі проміжні результати.
//
//В кінці має бути визначений переможець. І пропозиція почати грати знову.

public class HelloProgram extends ConsoleProgram {

    RandomGenerator rgen = RandomGenerator.getDefault();

    public void run(){
        int dices = readInt("Enter number of dices: ");
        int edge = readInt("Enter number of edges: ");
        int tempPlayer1 = 0;
        int tempPlayer2 = 0;
        int res;
        do {
            int i = readInt("If you want to play first game: press 1, second game: press 2: ");
            if (i == 1) {
                do {
                    for (int k = 1; k <= dices; k++) {
                        res = rgen.nextInt(1, edge);
                        tempPlayer1 += res;
                        println("Roll for player 1 (you), dice number " + k + ": " + res);
                    }
                    for (int k = 1; k <= dices; k++) {
                        res = rgen.nextInt(1, edge);
                        tempPlayer2 += res;
                        println("Roll for player 2 (bot), dice number " + k + ": " + res);
                    }
                } while (readInt("If you want to continue, press 1. If you want to finish press 2: ") == 1);
                println("Score for player 1: " + tempPlayer1);
                println("Score for player 2: " + tempPlayer2);
                if (tempPlayer1 > tempPlayer2) {
                    println("You Won!");
                }
                else if (tempPlayer1 < tempPlayer2) {
                    println("You Lost!");
                }
                else {
                    println("Draw!");
                }
            } else if (i == 2) {
                int rolls = readInt("Enter quantity of rolls: ");
                for (int j = rolls; j > 0; j--) {
                    for (int k = 1; k <= dices; k++) {
                        res = rgen.nextInt(1, edge);
                        tempPlayer1 += res;
                        println("Roll for player 1 (you), dice number " + k + ": " + res);
                    }
                    for (int k = 1; k <= dices; k++) {
                        res = rgen.nextInt(1, edge);
                        tempPlayer2 += res;
                        println("Roll for player 2 (bot), dice number " + k + ": " + res);
                    }
                }
                println("Score for player 1: " + tempPlayer1);
                println("Score for player 2: " + tempPlayer2);
                if (tempPlayer1 > tempPlayer2) {
                    println("You Won!");
                }
                else if (tempPlayer1 < tempPlayer2) {
                    println("You Lost!");
                }
                else {
                    println("Draw!");
                }
            }
        }while(readInt("If you want to repeat enter 0: ") == 0);
    }
}