import acm.graphics.*;
import acm.program.*;

import java.awt.*;


public class HouseWork extends GraphicsProgram {

    private static final double height = 500;
    private static final double width = 500;
    private static final double heightOfTheRoof = 100;
    private static final double widthOfTheWindow = 75;
    private static final double heightOfTheWindow = 75;
    private static final int quantityOfSmokes = 2;
    private static final double heightOfTheCloud = 20;
    private static final double widthOfTheCloud = 40;
    private static final int startPositionFromHouse = 100;
    private static final int endPositionFromHouse = 100;
    private static final boolean isDay = true;

    public void run(){
        this.setSize((int) width, (int) height);
        backgroundCreator();
        pipeCreator();
        roofCreator();
        houseCreator();
        windowCreator();
        fenceCreator();
        smokeCreator();
    }
    private void roofCreator(){
        for (double i = 0; i < width/3; i += 1){
            GLine line = new GLine(width/2, height/3 - heightOfTheRoof,2 * width/3 - i , height/3);
            line.setColor(new Color(133, 100, 30));
            add(line);
        }
        for (double i = 0; i < width/3; i += 4){
            GLine line = new GLine(width/2, height/3 - heightOfTheRoof,2 * width/3 - i , height/3);
            line.setColor(new Color(79, 58, 21));
            add(line);
        }
    }
    private void houseCreator(){
        GRect rect = new GRect(width/3, height/3, width/3, height/3);
        rect.setColor(new Color(150, 143, 132));
        rect.setFilled(true);
        add(rect);
    }
    private void pipeCreator(){
        GLine line3 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3, width/2 + width/8, height/3);
        add(line3);
        GLine line4 = new GLine(width/2 + width/12, height/3 - 2 * heightOfTheRoof/3, width/2 + width/12, height/3);
        add(line4);
        for (int i = 0; i < height/3; i += 1){
            GLine line5 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3 + i, width/2 + width/12, height/3 - 2 * heightOfTheRoof/3 + i);
            line5.setColor(Color.GRAY);
            add(line5);
        }
    }
    private void windowCreator(){
        double middleX = width/2;
        double middleY = height/2;
        GRect rect = new GRect(middleX - widthOfTheWindow / 2, middleY - heightOfTheWindow / 2, widthOfTheWindow, heightOfTheWindow);
        rect.setColor(new Color(217, 145, 41));
        rect.setFilled(true);
        add(rect);
        GLine line0 = new GLine (middleX, middleY - heightOfTheWindow / 2, middleX, middleY + heightOfTheWindow / 2);
        GLine line1 = new GLine (middleX - widthOfTheWindow / 2, middleY, middleX + widthOfTheWindow / 2, middleY);
        add(line0);
        add(line1);
    }
    private void fenceCreator(){
        for (double i = 0; i < startPositionFromHouse + endPositionFromHouse + width/3; i += 15 ){
            GLine line5 = new GLine(width/3 - startPositionFromHouse + i - 7, 42 * height/72, width/3 - startPositionFromHouse + i + 15, 21 * height/36);
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
            for (double j = 1; 41 * height/72 + j < 42 * height/72 ; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i - 7, 41 * height/72 + j, width/3 - startPositionFromHouse + i + 15, 41 * height/72 + j);
                filler.setColor(new Color(115, 63, 53));
                add(filler);
            }
            for (double j = 1; 45 * height/72 + j + 1 < 46 * height/72 ; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i - 7, 45 * height/72 + j, width/3 - startPositionFromHouse + i + 15, 45 * height/72 + j);
                filler.setColor(new Color(115, 63, 53));
                add(filler);
            }
            for (int j = 1; j < 6; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i + j, 6 * height/9 - 1,width/3 - startPositionFromHouse + i + j, 5 * height/9);
                filler.setColor(new Color(115, 63, 53));
                add(filler);
            }
            for (int j = 1; j < 6 ; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i + 3, 5 * height/9 - 7 + 2,width/3 - startPositionFromHouse + i + j, 5 * height/9);
                filler.setColor(new Color(115, 63, 53));
                add(filler);
            }
        }
    }
    private void smokeCreator(){
        int distance = 0;
        for (int i = quantityOfSmokes; i > 0; i--){
            for(int j = 0; j < 30; j+=10){
                GOval oval = new GOval(width/2 + width/12 - widthOfTheCloud/5 + j + distance, height/3 - 2 * heightOfTheRoof/3 - 30 - j - distance, widthOfTheCloud, heightOfTheCloud);
                oval.setFilled(true);
                oval.setColor(new Color(151, 170, 184));
                add(oval);
            }
            distance += 50;
        }
    }
    private void backgroundCreator(){
        GRect rectSky = new GRect(0, 0, width, 5 * height/9);
        rectSky.setFilled(true);
        rectSky.setColor(new Color(43, 169, 181));
        add(rectSky);
        GRect rectGround = new GRect(0, 5 * height/9, width, height);
        rectGround.setFilled(true);
        rectGround.setColor(new Color(33, 133, 30));
        add(rectGround);
    }
    private void setCustomColor(){

    }
}