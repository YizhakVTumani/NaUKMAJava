import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;

public class SunWork extends GraphicsProgram {
    private final static int quantityOfSquares = 1;
    private final static int WIDTH = 500;
    private final static int HEIGHT = 200;


    public void run() {
        setSize(WIDTH + 50, HEIGHT + 70);
        int min = Math.min(WIDTH, HEIGHT);
        for (int i = 0; i < quantityOfSquares; i++){
            squareCreator(i, min);
        }
    }
    public void squareCreator(int n, int min) {
        GRect rect = new GRect(20 + (10 * n), 20 + (10 * n), min - 20 - (20 * n), min - 20 - (20 * n));
        add(rect);
    }
}