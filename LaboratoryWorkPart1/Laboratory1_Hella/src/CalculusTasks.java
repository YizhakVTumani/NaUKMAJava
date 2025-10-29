import acm.program.*;
//Author: Hella Nikita

//Filename: CalculusTasks

// (1) Написати програму, що запитує у користувача два числа і обраховує корень квадратний з суми їх квадратів.

// (2) Написати програму, що зчитує з клавіатури цілі числа (по одному числу за раз),
// поки користувач не введе число 0 (ви маєте бути в змозі легко поміняти цю умову на якесь інше число).
// По закінченню вводу ваша програма має вивести найменше і найбільше число.

// (3) Опис алгоритму:
//
//візьміть позитивне ціле число, назвемо його n
//якщо n парне, поділимо його на 2
//якщо n не парне, помножимой його на 3 і додамо 1
//продовжувати цей процес поки n не буде дорівнювати 1
//Напишіть програму, що реалізує вказаний алгоритм і наочно проілюструє його виконання.
// В кінці обов'язково повідомити кількість кроків.

//(4) Послідовність сум {sn}, де sn=1+x+x2/2!+…+xn/n!, за умови 0<=x<1 "достатньо швидко" сходиться до ex.
// Запрограмувати обчислення ex при x [0;1) із точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .
//Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.

//(5) Послідовність сум {sn}, де sn=1-x2/2!+…+(-1)nx2n/(2n)!, за умови |x|<= p /4 "достатньо швидко" сходиться до cos(x).
// Запрограмувати обчислення cos(x) при x [-p /4; p/4] з точністю ep , тобто за потрібне число приймається перше snтаке, що | sn-sn-1 |<ep .
// Розв'язати двома способами: з використанням циклів (але використовуючи рекурентність) та з використанням рекурсивних викликів методів.

public class CalculusTasks extends ConsoleProgram {

    public void run(){
        do {
            int x = readInt("Write value of a: ");
            int y = readInt("Write value of b: ");
            println("Hypotenuse is: " + pythagorCalculus(x, y));
        }while (readInt("Do you want to continue? press 1: ") != 1); //pythagoras task's cycle


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
        }while(readInt("Do you want to continue? press 1: ") != 1); // min and max numbers cycle

        do {
            println("3n+1 algorithm");
            int steps = 0;
            int res = readInt("Enter value of n. It should be positive: ");
            if (res < 0) {
                res = readInt("Enter value of n. It should be positive: ");
            }
            println("The result is: " + 1 + " counter of steps is: " + algorithm(res, steps));
        }while(readInt("Do you want to continue? press 1: ") != 1); // 3n+1 algorithm cycle

        do{
            double res = 1;
            double res1 = 0;
            int i = 0;
            double x = readDouble("Enter the value of x. It should be positive limited as: 0 <= x < 1: ");
            double temp = 1;
            while (0 > x ||  x > 1){
                x = readDouble("Enter the value of x. It should be positive limited as: 0 <= x < 1: ");
            }
            double accuracy = readDouble("Enter the value of accuracy: ");

            println("The value is: " + exOfTheSumNumber7(res, accuracy,  x,  temp,  res1));
            println("The value of Recursion is: " + exOFTheSumNumber7Recursion( res,  accuracy,  x,  res1,  i));
            println("The true resukt is: " + Math.exp(x));
        }while(readInt("Do you want to continue? press 1: ") != 1); // e^x algorithm cycle

        do{
            double res = 1;
            int i = 1;
            double sum = 0;
            double x = readDouble("Enter the value of x. It should be positive limited as: -0.77 <= x <= 0.77: ");
            while (-0.77 > x ||  x > 0.77){
                x = readDouble("Enter the value of x. It should be positive limited as: -0.77 <= x <= 0.77: ");
            }
            double accuracy = readDouble("Enter the value of accuracy: ");
            println("The value is: " + sumEx8(res, accuracy,  x));
            println("The value of Recursion is: " + sumEx8R( res,  accuracy,  x, sum,  i));
        }while(readInt("Do you want to continue? press 1: ") != 1); // cos(x) algorithm cycle
    }

    private double pythagorCalculus(int x, int y){ // this method calculate length of hypotenius
        return Math.sqrt(x * x + y * y);
    } // finds length of hypothenus
    private int min(int x, int min){ // finds min number of entered
        min = Math.min(min, x);
        if(min == 0){
            return x;
        }
        else {
            return min;
        }
    }
    private int max(int x,  int max){ // finds max number of entered
        max = Math.max(max, x);
        if (max == 0){
            return x;
        }
        else {
            return max;
        }
    }
    private int algorithm(int res, int steps){ // does 3n+1 algorithm
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
    private int factorial(int n){ // find factorial of number
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
    private double exOfTheSumNumber7(double res, double accuracy, double x, double temp, double res1){ // finds e^x with accuracy = "accuracy"
        for (int i = 1; accuracy < temp; i++){
            res += Math.pow(x, i)/factorial(i);
            res1 += Math.pow(x, i - 1)/factorial(i - 1);
            temp = res - res1;
//            println("The value is: " + res);
        }
        return res;
    }
    private double exOFTheSumNumber7Recursion(double res, double accuracy, double x, double res1, int i){// finds e^x with accuracy = "accuracy" (Recursion)

        if (res - res1 > accuracy){
            i++;
//            println("The value of Rec is: " + res);
            return exOFTheSumNumber7Recursion(res + Math.pow(x, i)/factorial(i), accuracy, x, res1 + Math.pow(x, i - 1)/factorial(i - 1), i);
        }
        return res;
    }

    private double sumEx8(double res, double accuracy, double x){ // finds cos(x) with precision = "accuracy"
        double sum = 1;
        for (int i = 1; accuracy < Math.abs(res); i++){
            res = res * (-(Math.pow(x, 2)/((2 * i) * (2 * i - 1 ))));
            sum += res;
        }
        return sum;
    }

    private double sumEx8R(double res, double accuracy, double x, double sum, int i) {// finds cos(x) with precision = "accuracy"(Recursion)
        if (Math.abs(res) > accuracy){
            return sumEx8R(res * (-(Math.pow(x, 2)/((2 * i) * (2 * i - 1 )))), accuracy, x, sum + res, i + 1);
        }
        else
            return sum + res;
    }
}