import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;
import java.util.random.RandomGenerator;

public class SunWork extends GraphicsProgram {

    private static final int WIDTH = 600;
    private static final int QUANTITY_OF_CIRCLES = 5;

    public void run() {
        this.setSize(WIDTH + 50, WIDTH + 70);
        RandomGenerator gnr = RandomGenerator.getDefault();
        for (int i = 0; i < QUANTITY_OF_CIRCLES * 2; i++){
            int width = gnr.nextInt(1, WIDTH);
            int posX = gnr.nextInt(1, WIDTH - width);
            int posY = gnr.nextInt(1, WIDTH - width);
            GOval g = new GOval(posX, posY, width, width);
            add(g);
        }
    }
}