import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;

public class Work2 extends ConsoleProgram {
    public void run() {
        int k = readInt("Enter K: ");
        double x = readInt("Enter X: ");
        for (int i = 0; i < k; i++){
            x = (Math.pow(x, 2*k))/factorial(k * 2);
            println("X: " + x);
        }
    }
    private int factorial(int k){
        int f = 1;
        for (int i = 1; i <= k; i++){
            f *= i;
            println("Factorial of " + k + " is " + f);
        }
        return f;
    }
}