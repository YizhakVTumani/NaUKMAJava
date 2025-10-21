import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;
//Author: Hella Nikita

//Намалювати сонечко з променями.
//Кількість променів задається константою.
//Промені мають бути розміщені рівномірно.
//

public class TargetTask extends GraphicsProgram {

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    private static final int CIRCLES_QUANTITY = 50;
    private static final int DISTANCE = 5;

    public void run(){
        setSize(WIDTH + 20,HEIGHT + 60);
        for (int i = 0; i < CIRCLES_QUANTITY; i++) {
            targetCreator(i);
        }
    }
    public void targetCreator(int i){
        GOval oval = new GOval(WIDTH/2 - DISTANCE*CIRCLES_QUANTITY + i * DISTANCE,HEIGHT/2 - DISTANCE*CIRCLES_QUANTITY + i * DISTANCE,DISTANCE*CIRCLES_QUANTITY*2 - DISTANCE * i * 2,DISTANCE*CIRCLES_QUANTITY * 2- DISTANCE * i * 2);
        oval.setFilled(true);
        if(i % 2 == 0){
            oval.setColor(Color.RED);
        }
        else{
            oval.setColor(Color.YELLOW);
        }
        add(oval);
    }
}