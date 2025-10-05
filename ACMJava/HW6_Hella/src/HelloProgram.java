import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class HelloProgram extends GraphicsProgram {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static final int QUANTITYOFTHESQUARESBYX = 15;
    private static final int QUANTITYOFTHESQUARESBYY = 15;

    public void run() {
        int firstRowCounter = 0;
        setSize(WIDTH + 15, HEIGHT + 60);
        for (int i = 0; i < QUANTITYOFTHESQUARESBYY; i ++) {
            for  (int j = 0; j < QUANTITYOFTHESQUARESBYX; j ++) {
                GRect r = new GRect(WIDTH/QUANTITYOFTHESQUARESBYX * j,HEIGHT/QUANTITYOFTHESQUARESBYY * i,WIDTH/QUANTITYOFTHESQUARESBYX,HEIGHT/QUANTITYOFTHESQUARESBYY);
                r.setFillColor(Color.BLACK);
                r.setFilled((j + firstRowCounter) % 2 == 0);
                add(r);
            }
            firstRowCounter++;
        }
    }
}