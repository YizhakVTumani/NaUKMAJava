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
        }while (readInt("Do you want to continue? press 1 ") != 1);


        println("This program finds the smallest and the biggest number");
        println("To stop execution press 0");
        int max = -99999;
        int min = 99999;
        int x = 1;
        while(x != 0) {
            x = readInt("Write value of x: ");
            if(x != 0){
                min = min(x, min);
                max = max(x, max);
            }
            else if(x == 0){
                println("Min number is: " + min);
                println("Max number is: " + max);
                break;
            }
        }
    }
    private double pythagorCalculus(int x, int y){
        return Math.sqrt(x * x + y * y);
    }
    private int min(int x, int min){
        min = Math.min(min, x);
        return min;
    }
    private int max(int x,  int max){
        max = Math.max(max, x);
        return max;
    }
}