import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.awt.*;

//Author: Hella Nikita
//File: HelloProgram.java

//Намалювати обличчя робота.
//
//Обличчя складається з чотирьох частинок - голова, два ока, і рот
//
//Використати константи HEAD_WIDTH, HEAD_HEIGHT, EYE_RADIUS, MOUTH_WIDTH, MOUTH_HEIGHT
//
//Малюнок розміщується по центру вікна. При зміні розмірів вікна обличчя розміщується по центру вікна

public class HelloProgram1 extends GraphicsProgram {
    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;
    private static final int CENTER_X = WIDTH/2;
    private static final int CENTER_Y = HEIGHT/2;

    private static final int HEAD_WIDTH = 300;
    private static final int HEAD_HEIGHT = 300;

    private static final int EYE_RADIUS = 100;

    private static final int MOUTH_WIDTH = 100;
    private static final int MOUTH_HEIGHT = 30;
    private static final int ANTENRADIUS = 30;

    public void run() {
        this.setSize(WIDTH, HEIGHT);
        headCreator();
        eyesCreator();
        mouthCreator();
        antenCreator();
    }
    private void eyesCreator(){ // creates eyes
        GRect r = new GRect(CENTER_X - HEAD_WIDTH/2, CENTER_Y - HEAD_HEIGHT/3, EYE_RADIUS, EYE_RADIUS );
        r.setFillColor(Color.RED);
        r.setFilled(true);
        add(r);
        GRect r1 = new GRect(CENTER_X + HEAD_WIDTH/2 - EYE_RADIUS, CENTER_Y - HEAD_HEIGHT/3, EYE_RADIUS, EYE_RADIUS );
        r1.setFillColor(Color.RED);
        r1.setFilled(true);
        add(r1);
    }
    private void headCreator(){ // creates head
        GRect r = new GRect(CENTER_X - HEAD_WIDTH/2, CENTER_Y - HEAD_HEIGHT/2, HEAD_WIDTH, HEAD_HEIGHT );
        r.setFillColor(Color.BLUE);
        r.setFilled(true);
        add(r);
    }
    private void mouthCreator(){// creates mouth
        GRect r = new GRect(CENTER_X - MOUTH_WIDTH/2, CENTER_Y + HEAD_HEIGHT/3  , MOUTH_WIDTH, MOUTH_HEIGHT );
        r.setFillColor(Color.WHITE);
        r.setFilled(true);
        add(r);
    }
    private void antenCreator(){// creates anten
        for (int i = 0; i < 5; i++){
            GLine l = new GLine(CENTER_X - HEAD_WIDTH/3 + i, CENTER_Y - HEAD_HEIGHT/2, CENTER_X - HEAD_WIDTH/3 + i, CENTER_Y - 2*HEAD_HEIGHT/3);
            add(l);
        }
        GOval o = new GOval(CENTER_X - HEAD_WIDTH/3 - ANTENRADIUS/2 + 2.5, CENTER_Y - 2*HEAD_HEIGHT/3 - ANTENRADIUS, ANTENRADIUS, ANTENRADIUS);
        o.setFilled(true);
        add(o);

    }

}