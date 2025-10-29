import acm.program.*;
//Author: Hella Nikita



public class PythagorasTheorem extends ConsoleProgram {

    public void run(){
//        do {
//            int x = readInt("Write value of a: ");
//            int y = readInt("Write value of b: ");
//            println("Hypotenuse is: " + pythagorCalculus(x, y));
//        }while (readInt("Do you want to continue? press 1: ") != 1);
//
//
//        println("This program finds the smallest and the biggest number");
//        println("To stop execution press 0");
//        do {
//            int max = 0;
//            int min = 0;
//            int x = 1;
//            while (x != 0) {
//                x = readInt("Write value of x: ");
//                if (x != 0) {
//                    min = min(x, min);
//                    max = max(x, max);
//                }
//            }
//            println("Min number is: " + min);
//            println("Max number is: " + max);
//        }while(readInt("Do you want to continue? press 1: ") != 1);
//
//        do {
//            println("3n+1 algorithm");
//            int steps = 0;
//            int res = readInt("Enter value of n. It should be positive: ");
//            if (res < 0) {
//                res = readInt("Enter value of n. It should be positive: ");
//            }
//            println("The result is: " + 1 + " counter of steps is: " + algorithm(res, steps));
//        }while(readInt("Do you want to continue? press 1: ") != 1);
//
//        do{
//            double res = 1;
//            double res1 = 0;
//            int i = 0;
//            double x = readDouble("Enter the value of x. It should be positive limited as: 0 <= x < 1: ");
//            double temp = 1;
//            while (0 > x ||  x > 1){
//                x = readDouble("Enter the value of x. It should be positive limited as: 0 <= x < 1: ");
//            }
//            double accuracy = readDouble("Enter the value of accuracy: ");
//
//            println("The value is: " + exOfTheSumNumber7(res, accuracy,  x,  temp,  res1));
//            println("The value of Recursion is: " + exOFTheSumNumber7Recursion( res,  accuracy,  x,  res1,  i));
//            println("The true resukt is: " + Math.exp(x));
//        }while(readInt("Do you want to continue? press 1: ") != 1);

        do{
            double res = 1;
            double res1 = 0;
            int i = 0;
            double x = Math.cos(readDouble("Enter the value of x. It should be positive limited as: -0.77 <= x <= 0.77: "));
            double temp = 1;
            while (-0.77 > Math.cos(x) ||  Math.cos(x) > 0.77){
                x = readDouble("Enter the value of x. It should be positive limited as: -0.77 <= x <= 0.77: ");
            }
            double accuracy = readDouble("Enter the value of accuracy: ");
            println("The value is: " + sumEx8(res, accuracy,  x,  temp,  res1));
//            println("The value of Recursion is: " + sumEx8R( res,  accuracy,  x,  res1,  i));
        }while(readInt("Do you want to continue? press 1: ") != 1);
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
    private int factorial(int n){
        for(int i = n - 1; i > 0; i--){
            n *= i;
        }
        if(n == 0){
            return 1;
        }
        else{
            return n;
        }
    }
    private double exOfTheSumNumber7(double res, double accuracy, double x, double temp, double res1){
        for (int i = 1; accuracy < temp; i++){
            res += Math.pow(x, i)/factorial(i);
            res1 += Math.pow(x, i - 1)/factorial(i - 1);
            temp = res - res1;
//            println("The value is: " + res);
        }
        return res;
    }
    private double exOFTheSumNumber7Recursion(double res, double accuracy, double x, double res1, int i){

        if (res - res1 > accuracy){
            i++;
//            println("The value of Rec is: " + res);
            return exOFTheSumNumber7Recursion(res + Math.pow(x, i)/factorial(i), accuracy, x, res1 + Math.pow(x, i - 1)/factorial(i - 1), i);
        }
        return res;
    }

    private double sumEx8(double res, double accuracy, double x,double temp, double res1){
        double sum = 1;
        for (int i = 1; accuracy < Math.abs(res); i++){
//            res += Math.pow(-1, i) * (Math.pow(x, 2 * i)/factorial(2 * i));
            res = res * (-(Math.pow(x, 2)/((2 * i) * (2 * i - 1 ))));
            sum += res;

//            res1 = Math.pow(-1, i) * (Math.pow(x, 2 * i)/factorial(2 * i));
//            res1 = (-(Math.pow(x, 2)/((2 * i) * (2 * i - 1 ))));
            println("The value is: " + res);
            println("The value is: " + sum);
//            temp = Math.abs(res1);
//            println("The value is: " + temp);
        }
        return sum;
    }
    private double sumEx8R(double res, double accuracy, double x, double res1, int i){
        if (res - res1 > accuracy){
            i++;
            println("The value of Rec is: " + res);
            return sumEx8R(res + Math.pow(x, i)/factorial(i), accuracy, x, res1 + Math.pow(x, i - 1)/factorial(i - 1), i);
        }
        return res;
    }
}