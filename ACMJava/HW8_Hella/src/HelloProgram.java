import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Гра "Вгадай число"
//
//Одна з найпростіших ігор для двох гравців є "Вгадай число".
// Перший гравець задумує таємне число в деякому відомому діапазоні, а другий гравець намагається вгадати число.
// Після кожного намагання вгадати число, перший гравець відповідає «Більше», «Менше» або «Вірно!" .
// У цьому проекті, ви будете будувати просту інтерактивну програму, де комп'ютер візьме на себе роль першого гравця в той час як ви граєте, як другій гравець.
//
//Ви маєте написати програму, що загадує число строго в діапазоні від 1 до 100 і очікує відповідей користувача.
//Ви маєте рахувати кількість спроб користувача.В кінці гри вивести за скільки спроб вгадали число.
//
//По завершенні гри пропонуєте розпочати її знову.

public class HelloProgram extends ConsoleProgram {

    RandomGenerator rgen = RandomGenerator.getDefault();

    public void run(){
        int result = rgen.nextInt(0, 100);
        int steps = 0;
        while (true){
            steps ++;
            int guess = readInt("Guess: ");
            if (result == guess){
                println("Congratulations! You win!");
                break;
            }
            else if (result > guess){
                println("Take higher!");
            }
            else if (result < guess){
                println("Take lower!");
            }
        }
        println("It took you " + steps + " steps.");
    }
}