import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.*;

import java.awt.*;


public class SunWork extends GraphicsProgram {

    private static final double sunraysQuantity = 50;

    public void run(){
        this.setSize(800,800);
        sunCreation();
        sunraysQuantityCalculator();
    }
    private void sunCreation(){
        GOval sun = new GOval(250,250,300,300);
        sun.setFilled(true);
        sun.setColor(Color.YELLOW);
        add(sun);
    }
    private void sunraysQuantityCalculator(){
        for (double i = 1; i <= sunraysQuantity; i ++){
            double rays = Math.toRadians(360) / sunraysQuantity * i;
            double xPoint = 400 + 400 * Math.cos(rays);
            double yPoint = 400 + 400 * Math.sin(rays);
            GLine line = new GLine(400,400,xPoint,yPoint);
            line.setColor(Color.YELLOW);
            add(line);
        }
    }
}