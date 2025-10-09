import acm.graphics.*;
import acm.program.*;

import java.awt.*;

//Author: Hella Nikita
//File: HelloProgram.java


public class HelloProgram extends ConsoleProgram {
    public void run(){
        do{
            println("is not recommended to use numbers superior than 40");
            int n = readInt("Please enter a number: ");
            if (n < 0) println("Negative number is not included!");

            for (int i = 0; i < n; i++){
                println(n - i + " - " + fibonacciR(n - i) + " - " + fibonacci(n - i));
            }
            println("0 - 0 - 0");
        }while(readInt("if you want to repeat type 0: ") == 0);

        do{
            println("is not recommended to use numbers superior than 40");
            int n = readInt("Please enter a number: ");
            if (n < 0) println("Negative number is not included!");
            for (int i = 0; i < n; i++){
                println(factorialR(n - i) + " - " + (factorial(n - i)));
            }
        }while(readInt("if you want to repeat type 0: ") == 0);

        do{
            println("is not recommended to use numbers superior than int could possibly contain");
            int n = readInt("Please enter a number: ");
            //if (n < 0) println("Negative number is not included!");
            println(decimalR(n));
        }while(readInt("if you want to repeat type 0: ") == 0);

    }
    private double fibonacciR(double n){
        if (n == 1)
            return 1;
        if (n <= 0)
            return 0;
        return fibonacciR(n-1) + fibonacciR(n-2);
    }
    private double fibonacci(int n){
        int a = 0, b = 1;
        for (int i = 0; i < n; i++){
            b = a + b;
            a = b - a;
        }
        return a;
    }
    private double factorialR(int n){
        if (n <= 1)
            return 1;
        return factorialR(n-1) * n;
    }
    private double factorial(int n){
        int a = 1;
        for (int i = 0; i < n; i++){
            a *= i + 1;
        }
        return a;
    }
    private int decimalR(double n){
        if (-1 < n & n < 1)
            return 0;
        return decimalR(n/10) + 1;
    }
}