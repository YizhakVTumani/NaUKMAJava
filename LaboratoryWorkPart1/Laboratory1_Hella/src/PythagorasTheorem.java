import acm.program.*;
//Author: Hella Nikita

//Намалювати сонечко з променями.
//Кількість променів задається константою.
//Промені мають бути розміщені рівномірно.
//

public class PythagorasTheorem extends ConsoleProgram {

    public void run(){
        do {
            int x = readInt("Write value of x: ");
            int y = readInt("Write value of y: ");
            println("Hypotenuse is: " + pythagorCalculus(x, y));
        }while (readInt("Do you want to continue? press 1: ") != 1);


        println("This program finds the smallest and the biggest number");
        println("To stop execution press 0");
        do {
            int max = 0;
            int min = 0;
            int x = 1;
            while (x != 0) {
                x = readInt("Write value of x: ");
                if (x != 0) {
                    min = min(x, min);
                    max = max(x, max);
                }
            }
            println("Min number is: " + min);
            println("Max number is: " + max);
        }while(readInt("Do you want to continue? press 1: ") != 1);

        println("3n+1 algorithm");
        int steps = 0;
        int res = readInt("Enter value of n. It should be positive: ");
        if (res < 0){
             res = readInt("Enter value of n. It should be positive: ");
        }

        println("The result is: " + 1 + " counter of steps is: " + algorithm(res, steps));
    }
    private double pythagorCalculus(int x, int y){
        return Math.sqrt(x * x + y * y);
    }
    private int min(int x, int min){
        min = Math.min(min, x);
        if(min == 0){
            return x;
        }
        else {
            return min;
        }
    }
    private int max(int x,  int max){
        max = Math.max(max, x);
        if (max == 0){
            return x;
        }
        else {
            return max;
        }
    }
    private int algorithm(int res, int steps){
        if (res == 1){
            return steps;
        }
        else if (res % 2 == 0){
            println(res + " / 2");
            return algorithm(res/2, steps + 1);
        }
        else{
            println(res + " * 3 + 1");
            return algorithm(res*3 + 1, steps + 1);
        }
    }
}