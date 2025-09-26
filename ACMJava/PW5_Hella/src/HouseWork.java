import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.graphics.GRectangle;
import acm.program.*;

import java.awt.*;


public class HouseWork extends GraphicsProgram {

    private static final double height = 500;
    private static final double width = 500;
    private static final double heightOfTheRoof = 100;
    private static final double widthOfTheWindow = 100;
    private static final double heightOfTheWindow = 100;

    public void run(){
        this.setSize((int) width, (int) height);

        pipeCreator();
        roofCreator();
        houseCreator();
        windowCreator();
        fenceCreator();

    }
    private void roofCreator(){
        for (int i = 0; i < width/3; i += 3){
            GLine line = new GLine(width/2, height/3 - heightOfTheRoof,2 * width/3 - i , height/3);
            line.setColor(Color.RED);
            add(line);
        }
    }
    private void houseCreator(){
        GRect rect = new GRect(width/3, height/3, width/3, height/3);
        rect.setFillColor(Color.GRAY);
        rect.setFilled(true);
        add(rect);
    }
    private void pipeCreator(){
        GLine line3 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3, width/2 + width/8, height/3);
        add(line3);
        GLine line4 = new GLine(width/2 + width/12, height/3 - 2 * heightOfTheRoof/3, width/2 + width/12, height/3);
        add(line4);
        for (int i = 0; i < height/3 - 2 * heightOfTheRoof; i += 1){
            GLine line5 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3 + i, width/2 + width/12, height/3 - 2 * heightOfTheRoof/3 + i);
            line5.setColor(Color.GRAY);
            add(line5);
        }
    }
    private void windowCreator(){
        double middleX = width/2;
        double middleY = height/2;
        GRect rect = new GRect(middleX - widthOfTheWindow / 2, middleY - heightOfTheWindow / 2, widthOfTheWindow, heightOfTheWindow);
        rect.setFillColor(Color.CYAN);
        rect.setFilled(true);
        add(rect);
        GLine line0 = new GLine (middleX, middleY - heightOfTheWindow / 2, middleX, middleY + heightOfTheWindow / 2);
        GLine line1 = new GLine (middleX - widthOfTheWindow / 2, middleY, middleX + widthOfTheWindow / 2, middleY);
        add(line0);
        add(line1);
    }
    private void fenceCreator(){
        int startPositionFromHouse = 100;
        int endPositionFromHouse = 100;
        for (double i = 0; i < startPositionFromHouse + endPositionFromHouse + width/3; i += 15 ){
            GLine line5 = new GLine(width/3 - startPositionFromHouse + i - 7, 21 * height/36, width/3 - startPositionFromHouse + i + 15, 21 * height/36);
            add(line5);
            GLine line6 = new GLine(width/3 - startPositionFromHouse + i - 7, 41 * height/72, width/3 - startPositionFromHouse + i + 15, 41 * height/72);
            add(line6);
            GLine line7 = new GLine(width/3 - startPositionFromHouse + i - 7, 46 * height/72, width/3 - startPositionFromHouse + i + 15, 46 * height/72);
            add(line7);
            GLine line8 = new GLine(width/3 - startPositionFromHouse + i - 7, 45 * height/72, width/3 - startPositionFromHouse + i + 15, 45 * height/72);
            add(line8);
            GLine line = new GLine(width/3 - startPositionFromHouse + i, 6 * height/9,width/3 - startPositionFromHouse + i, 5 * height/9);
            add(line);
            GLine line1 = new GLine(width/3 - startPositionFromHouse + i + 6, 6 * height/9,width/3 - startPositionFromHouse + i + 6, 5 * height/9);
            add(line1);
            GLine line2 = new GLine(width/3 - startPositionFromHouse + i + 3, 5 * height/9 - 7,width/3 - startPositionFromHouse + i, 5 * height/9);
            add(line2);
            GLine line3 = new GLine(width/3 - startPositionFromHouse + i + 3, 5 * height/9 - 7,width/3 - startPositionFromHouse + i + 6, 5 * height/9);
            add(line3);
            GLine line4 = new GLine(width/3 - startPositionFromHouse + i, 6 * height/9, width/3 - startPositionFromHouse + i + 6, 6 * height/9);
            add(line4);
        }
    }
}