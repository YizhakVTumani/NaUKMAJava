import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class SunWork extends GraphicsProgram {

    private static final int QUANTITYOFSQUARES = 4;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;



    public void run() {
        setSize(WIDTH + 50, HEIGHT + 70);
        RandomGenerator rg = new RandomGenerator();
        for (int i = 0; i < QUANTITYOFSQUARES; i++) {
            int posX = rg.nextInt(1, 500);
            int posY = rg.nextInt(1, 500);
            int width = rg.nextInt(1, WIDTH - posX - 20);
            int height = rg.nextInt(1, HEIGHT - posY - 20);
            GRect rect = new GRect(posX, posY, width, height);
            add(rect);
        }
    }
}