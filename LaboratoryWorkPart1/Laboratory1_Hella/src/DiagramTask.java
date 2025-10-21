import acm.graphics.*;
import acm.program.*;

import java.awt.*;
//Author: Hella Nikita

//Намалювати сонечко з променями.
//Кількість променів задається константою.
//Промені мають бути розміщені рівномірно.
//

public class DiagramTask extends GraphicsProgram {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;
    private static final int RECTANGLEWIDTH = WIDTH / 4;
    private static final int RECTANGLEHEIGHT = HEIGHT / 5;

    public void run() {
        setSize(WIDTH + 20, HEIGHT + 60);
        lineCreator();
        rectangleCreator();
    }

    public void lineCreator() {
        for (int i = 0; i < 3; i++) {
            GLine line = new GLine(2 * RECTANGLEWIDTH, RECTANGLEHEIGHT + RECTANGLEHEIGHT, RECTANGLEWIDTH / 4 + RECTANGLEWIDTH / 2 + RECTANGLEWIDTH / 4 * i + RECTANGLEWIDTH * i, RECTANGLEHEIGHT + RECTANGLEHEIGHT * 2);
            add(line);
        }
    }

    public void rectangleCreator() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                if (j == 1 || (j == 0 && (i != 0 && i != 2))) {
                    GRect rect = new GRect(RECTANGLEWIDTH / 4 + RECTANGLEWIDTH / 4 * i + RECTANGLEWIDTH * i, RECTANGLEHEIGHT + RECTANGLEHEIGHT * j * 2, RECTANGLEWIDTH, RECTANGLEHEIGHT);
                    add(rect);
                    textCreator(i, j);
                }
            }
        }
    }

    public void textCreator(int i, int j) {
        if (i == 1 && j == 0) {
            GLabel label = new GLabel("Program", RECTANGLEWIDTH / 4 + RECTANGLEWIDTH / 4 * i + RECTANGLEWIDTH * i, RECTANGLEHEIGHT * 1.5);
            add(label);
        } else if (i == 0 && j == 1) {
            GLabel label = new GLabel("GraphicProgram", RECTANGLEWIDTH / 4, RECTANGLEHEIGHT + RECTANGLEHEIGHT * j * 2.5);
            add(label);
        } else if (i == 1 && j == 1) {
            GLabel label = new GLabel("ConsoleProgram", RECTANGLEWIDTH / 4 + RECTANGLEWIDTH / 4 * i + RECTANGLEWIDTH * i, RECTANGLEHEIGHT + RECTANGLEHEIGHT * j * 2.5);
            add(label);
        } else if (i == 2 && j == 1) {
            GLabel label = new GLabel("DialogProgram", RECTANGLEWIDTH / 4 + RECTANGLEWIDTH / 4 * i + RECTANGLEWIDTH * i, RECTANGLEHEIGHT + RECTANGLEHEIGHT * j * 2.5);
            add(label);
        }
    }
}