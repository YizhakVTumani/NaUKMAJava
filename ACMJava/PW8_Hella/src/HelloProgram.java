import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Програма має рахувати числа Фібоначі і виводити результати на екран
//Програма має рахувати n! Число n вводить користувач.
//Написати программу обчислення кількості (ми не знаємо кількість цифр) десяткових цифр натурального числа.
// Не використовувати стрічки, суто математичні операції.

public class HelloProgram extends ConsoleProgram {
    private RandomGenerator rgen = RandomGenerator.getInstance();
    public void run(){
        do {
            int i = readInt("If you want to play first game: press 1, second game: press 2");
            if (i == 1) {
                while () {

                }
            } else if (i == 2) {
                int dices = readInt("Enter number of dices: ");
                int edge = readInt("Enter number of edges: ");
                for (int j = readInt("Enter quantity of rolls:"); j > 0; j--) {
                    rgen.nextInt(1, edge);
                }
            }
        }while(readInt("If you want to repeat enter 0") == 0);
    }
    public void rollingDice(){

    }
}