import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;

public class Work2 extends ConsoleProgram {
    public void run() {
        int n = readInt("Enter value of n: ");
        int res = 0;
        int x1 = 1;
        int x2 = 3;
        for (int i = 0; i < n; i++){
            res = 2*x1 + 2*x2 + 3;
            x1 = x2;
            x2 = res;
        }
        println("Result is: " + res);
    }
}