import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class HelloProgram1 extends GraphicsProgram {

    private static final double numberOfTheBeeperInTheStart = 10;
    private static final double beepersAddingNumber = -2;

    private static final int gapX = 50;
    private static final int gapY = 50;

    private static final int Width = 500;
    private static final int Height = 500;

    public void run() {
        setSize(Width, Height + 50);
        for (double i = 0; i < numberOfTheBeeperInTheStart + beepersAddingNumber; i++) {
            if (50 + (gapX * i) < Width) {
                double f = numberOfTheBeeperInTheStart + (beepersAddingNumber * i);
                for (int j = 0; j < f; j++) {
                    if(Height - 60 - (gapY * j) > 0) {
                        GLine l = new GLine(40 + (gapX * i), Height - 60 - (gapY * j), 30 + (gapX * i), Height - 40 - (gapY * j));
                        GLine l1 = new GLine(30 + (gapX * i), Height - 40 - (gapY * j), 40 + (gapX * i), Height - 20 - (gapY * j));
                        GLine l2 = new GLine(40 + (gapX * i), Height - 60 - (gapY * j), 50 + (gapX * i), Height - 40 - (gapY * j));
                        GLine l3 = new GLine(50 + (gapX * i), Height - 40 - (gapY * j), 40 + (gapX * i), Height - 20 - (gapY * j));
                        if ( j % 3 == 0){
                            l.setColor(Color.RED);
                            l1.setColor(Color.RED);
                            l2.setColor(Color.RED);
                            l3.setColor(Color.RED);
                        }
                        else if ( j % 2 == 0){
                            l1.setColor(Color.YELLOW);
                            l2.setColor(Color.YELLOW);
                            l3.setColor(Color.YELLOW);
                            l.setColor(Color.YELLOW);
                        }
                        else {
                            l.setColor(Color.GREEN);
                            l1.setColor(Color.GREEN);
                            l2.setColor(Color.GREEN);
                            l3.setColor(Color.GREEN);
                        }
                        add(l);
                        add(l1);
                        add(l2);
                        add(l3);
                    }
                    else break;
                }
            }
            else break;
        }
    }
}