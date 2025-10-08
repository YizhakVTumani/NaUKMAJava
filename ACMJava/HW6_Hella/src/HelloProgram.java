import acm.graphics.*;
import acm.program.*;

import java.awt.*;

//Author:Hella Nikita
//file: HelloProgram.java

//1. Написати програму, що намалює шахову доску.
//
//Використати: константи, цикли.
//
//Розмір шахової дошки = розміру вікна. І так, вона може бути не квадратною ;-(
//Можливі варіанти малювання  будь-яких n*m рядків та колонок, які вписуються в розмір дошки

public class HelloProgram extends GraphicsProgram {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private static final double QUANTITYOFTHESQUARESBYX = 15;
    private static final double QUANTITYOFTHESQUARESBYY = 15;

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