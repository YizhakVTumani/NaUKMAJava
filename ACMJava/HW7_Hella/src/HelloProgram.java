import acm.graphics.*;
import acm.program.*;

import java.awt.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Користувач вводить число яке обмежує значення максимального числа Фібоначі, що має бути обраховане.
//Тобто вивід триває поки значення наступного числа фібоначі не перевищує введене користувачем число.

public class HelloProgram extends ConsoleProgram {
    public void run() {
        do {
            int n = readInt("Enter max number of fibonacci numbers: ");
            if(n < 0) {
                println("Value is negative");
            }
            for (int i = 0; n > fibonacciR(i); i++) {
                println(fibonacciR(i));
            }
        }while(readInt("if you want to repeat type 0: ") == 0);
    }
    private double fibonacciR(double n){
        if (n == 1)
            return 1;
        if (n <= 0)
            return 0;
        return fibonacciR(n-1) + fibonacciR(n-2);
    }
}