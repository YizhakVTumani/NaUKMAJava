import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;

public class Work2 extends ConsoleProgram {
    public void run() {
        int n = readInt("Enter the number of n: ");
        int x = 1;
        int y = 1;
        for (int i =0; i < n; i++) {
            println("x: " + x + " y: " + y);
            int temp = x;
            x = x*(y+1);
            y = temp;
        }
    }
}