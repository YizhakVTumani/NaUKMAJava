import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class HelloProgram extends GraphicsProgram {
    public void run(){
        this.setSize(500, 500);
        GLabel label = new GLabel("Гелла Нікіта Сергійович", 0, 75);
        label.setFont("SansSerif-30");
        label.setColor(Color.RED);
        add(label);
        GLabel label2 = new GLabel("Гелла Нікіта Сергійович", 175, 250);
        label2.setFont("TimesNewRoman-20");
        label2.setColor(Color.GREEN);
        add(label2);
        GLabel label3 = new GLabel("Гелла Нікіта Сергійович", 350, 450);
        label3.setFont("Calibri-10");
        label3.setColor(Color.BLUE);
        add(label3);
    }
}