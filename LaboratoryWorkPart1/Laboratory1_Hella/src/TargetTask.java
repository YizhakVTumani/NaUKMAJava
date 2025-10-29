import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;
//Author: Hella Nikita

//Filename: TargetTask

//Ви маєте написати програму, що малює зображення "мішень для лучника"
//Мішень має розташовуватися по центру вікна. Мають бути використані константи:
//ширира світу;
//висота світу;
//кількість кругів.

public class TargetTask extends GraphicsProgram {

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    private static final int CIRCLES_QUANTITY = 100;
    private static final int DISTANCE = 20;

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