import acm.graphics.*;
import acm.program.*;

import java.awt.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Обчисліть значення функції та виведіть його на екран.
//
//у=МАХ(a, b, c, d)
//y=x4
//y=ax2+bx+c
//Значення a, b, c, d та х задаються з клавіатури та використовуються для для всіх 3 підзадач
//
//2. Розв'яжіть рівняння та виведіть на екран результат.
//
//y=x4
//y=ax2+bx+c
//y=ax+c
//Значення a, b, c, у задаються з клавіатури та використовуються для для всіх 3 підзадач, значення у - будь-яке.



public class HelloProgram extends ConsoleProgram {
    public void run(){
        setFont(new Font("Arial", Font.PLAIN, 20));
        do {
            println("Write values of 'a', 'b', 'c' and 'd'");
            println("Note: if the value is too high, it could give wrong values");
            int a = readInt("Value of a: "), b = readInt("Value of b: "), c = readInt("Value of c: "), d = readInt("Value of d: "), x = readInt("Value of x: ");
            maxNumberOfFour(a, b, c, d);
            numberInPowerOfFour(x);
            findYInSquareFunction(a, b, c, x);
        } while (readInt("If you want to continue type 0, else another value (1-9): ") == 0);

        println("");
        println("Next part of the task!");
        println("");

        do{
            println("Write values of 'a', 'b', 'c' and 'd'");
            println("Note: if the value is too high, it could give wrong values");
            int a = readInt("Value of a: "), b = readInt("Value of b: "), c = readInt("Value of c: "), y = readInt("Value of y: ");
            findYOfXInFourthPower(y);
            findRootsOfSquaredFunction(a, b, c, y);
            findXofLinearFunction(a, c, y);
        } while (readInt("If you want to continue type 0, else another value (1-9): ") == 0);
    }


    private void maxNumberOfFour(int a, int b, int c, int d){ // searches max number of a, b, c, d
        int value, maxValueOfAAndB, maxValueOfCAndD;
        if(a >= b) maxValueOfAAndB = a;
        else maxValueOfAAndB = b;
        if(c >= d) maxValueOfCAndD = c;
        else maxValueOfCAndD = d;
        if(maxValueOfAAndB >= maxValueOfCAndD) value = maxValueOfAAndB;
        else value = maxValueOfCAndD;
        println("Max value of a, b, c and d is: " + value);
    }
    private void numberInPowerOfFour(int x){ // finds x in 4 power
        double value = x*x*x*x;
        println("4-th power of number a is: " + value);
    }
    private void findYInSquareFunction(int a, int b, int c, int x){ // finds value of function
        double value = a * a * x + b * x + c;
        println("Value of Y is: " + value);
    }



    private void  findYOfXInFourthPower(int y){ // finds root in power of 4
        if (y > 0){
            double value = Math.pow(y, 0.25);
            println("Value of Y is: " + value + " or - " + value);
        }
        else if (y == 0) println("Value of Y is: 0");
        else println("Value of Y is: None, y < 0");
    }
    private void findRootsOfSquaredFunction(int a, int b, int c, int y){ // finds roots of square function
        if (a == 0 && b!= 0){
            int value = (c - y)/b;
            println("Value of X is: " + value);
        }
        else {
            double discriminant = Math.sqrt(Math.pow(b, 2) - (4 * (a * (c - y))));
            if (discriminant > 0) {
                double root1 = (-b - discriminant) / (2 * a);
                double root2 = (-b + discriminant) / (2 * a);
                println("Roots of Squared Function are: " + root1 + " and " + root2);
            }
            else if (discriminant == 0) {
                double root = (double) (-b) / (2 * a);
                println("Roots of Squared Function are: " + root);
            }
            else println("Roots of Squared Function are: " + "None, discriminant is negative");
        }
    }
    private void  findXofLinearFunction(int a, int c, int y){ // finds x of linear function
        if(a != 0){
            int value = (c - y)/a;
            println("Value of X is: " + value);
        }
        else println("Value of X is: Any, a = 0");
    }
}