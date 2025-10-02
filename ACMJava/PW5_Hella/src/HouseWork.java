import acm.graphics.*;
import acm.program.*;

import java.awt.*;

//Author: Hella Nikita

//Намалювати різнокольоровий будинок
//Використовуйте цикли
//Додайте підпис на малюнок



public class HouseWork extends GraphicsProgram {

    private static final double height = 500; // height of the world
    private static final double width = 500;// width of the world

    private static final double heightOfTheRoof = 100; // height of the roof

    private static final double widthOfTheWindow = 75; //width of the window
    private static final double heightOfTheWindow = 75;// height of the window

    private static final int quantityOfSmokes = 2; // quantity of smokes from pipe

    private static final double heightOfTheSmoke = 20; //height of the smoke
    private static final double widthOfTheSmoke = 40; //width of the smoke

    private static final int startPositionFromHouse = 100; //start position of the fence
    private static final int endPositionFromHouse = 100;//end position of the fence

    private static final int starQuantity = 75; // quantity of stars

    private static final boolean isDay = false; // changing day & night

    private static final double heightOfTheCloud = 30;//height of the cloud
    private static final double widthOfTheCloud = 50;//width of the cloud

    private static final int quantityOfClouds = 3; //quantity of the cloud

    public void run(){
        this.setSize((int) width, (int) height);

        backgroundCreator();
        cloudCreator();
        starCreator();
        pipeCreator();
        roofCreator();
        houseCreator();
        windowCreator();
        fenceCreator();
        smokeCreator();

        signCreator();
    }
    private void roofCreator(){ // creates roof
        for (double i = 0; i < width/3; i += 1){
            GLine line = new GLine(width/2, height/3 - heightOfTheRoof,2 * width/3 - i , height/3);
            if(isDay) line.setColor(new Color(133, 100, 30));
            else line.setColor(new Color(38, 27, 9));
            add(line);
        }
        if(isDay) {
            for (double i = 0; i < width / 3; i += 4) {
                GLine line = new GLine(width / 2, height / 3 - heightOfTheRoof, 2 * width / 3 - i, height / 3);
                line.setColor(new Color(79, 58, 21));
                add(line);
            }
        }
    }
    private void houseCreator(){// creates house
        GRect rect = new GRect(width/3, height/3, width/3, height/3);
        if(isDay) rect.setColor(new Color(150, 143, 132));
        else rect.setColor(new Color(64, 62, 57));
        rect.setFilled(true);
        add(rect);
    }
    private void pipeCreator(){// creates pipe
        GLine line3 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3, width/2 + width/8, height/3);
        add(line3);
        GLine line4 = new GLine(width/2 + width/12, height/3 - 2 * heightOfTheRoof/3, width/2 + width/12, height/3);
        add(line4);
        for (int i = 0; i < height/3; i ++){
            GLine line5 = new GLine(width/2 + width/8, height/3 - 2 * heightOfTheRoof/3 + i, width/2 + width/12, height/3 - 2 * heightOfTheRoof/3 + i);
            if(isDay) line5.setColor(new Color(150, 143, 132));
            else line5.setColor(new Color(64, 62, 57));
            add(line5);
        }
    }
    private void windowCreator(){// creates window
        double middleX = width/2;
        double middleY = height/2;
        GRect rect = new GRect(middleX - widthOfTheWindow / 2, middleY - heightOfTheWindow / 2, widthOfTheWindow, heightOfTheWindow);
        if(isDay) rect.setColor(new Color(43, 106, 110));
        else rect.setColor(new Color(217, 145, 41));
        rect.setFilled(true);
        add(rect);
        GLine line0 = new GLine (middleX, middleY - heightOfTheWindow / 2, middleX, middleY + heightOfTheWindow / 2);
        GLine line1 = new GLine (middleX - widthOfTheWindow / 2, middleY, middleX + widthOfTheWindow / 2, middleY);
        add(line0);
        add(line1);
    }
    private void fenceCreator(){// creates fence
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
                if(isDay) filler.setColor(new Color(115, 63, 53));
                else filler.setColor(new Color(36, 20, 16));
                add(filler);
            }
            for (double j = 1; 45 * height/72 + j + 1 < 46 * height/72 ; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i - 7, 45 * height/72 + j, width/3 - startPositionFromHouse + i + 15, 45 * height/72 + j);
                if(isDay) filler.setColor(new Color(115, 63, 53));
                else filler.setColor(new Color(36, 20, 16));
                add(filler);
            }
            for (int j = 1; j < 6; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i + j, 6 * height/9 - 1,width/3 - startPositionFromHouse + i + j, 5 * height/9);
                if(isDay) filler.setColor(new Color(115, 63, 53));
                else filler.setColor(new Color(36, 20, 16));
                add(filler);
            }
            for (int j = 1; j < 6 ; j++){
                GLine filler = new GLine(width/3 - startPositionFromHouse + i + 3, 5 * height/9 - 7 + 2,width/3 - startPositionFromHouse + i + j, 5 * height/9);
                if(isDay) filler.setColor(new Color(115, 63, 53));
                else filler.setColor(new Color(36, 20, 16));
                add(filler);
            }
        }
    }
    private void smokeCreator(){// creates smoke
        int distance = 0;
        for (int i = quantityOfSmokes; i > 0; i--){
            for(int j = 0; j < 30; j+=10){
                GOval oval = new GOval(width/2 + width/12 - widthOfTheSmoke /5 + j + distance, height/3 - 2 * heightOfTheRoof/3 - 30 - j - distance, widthOfTheSmoke, heightOfTheSmoke);
                oval.setFilled(true);
                if(isDay) oval.setColor(new Color(151, 170, 184));
                else oval.setColor(new Color(55, 64, 69));
                add(oval);
            }
            distance += 50;
        }
    }
    private void backgroundCreator(){// creates background
        GRect rectSky = new GRect(0, 0, width, 5 * height/9);
        rectSky.setFilled(true);
        if(isDay)rectSky.setColor(new Color(43, 169, 181));
        else rectSky.setColor(new Color(9, 40, 43));
        add(rectSky);
        GRect rectGround = new GRect(0, 5 * height/9, width, height);
        rectGround.setFilled(true);
        if(isDay){
            rectGround.setColor(new Color(33, 133, 30));
        }
        else {
            rectGround.setColor(new Color(11, 43, 10));
        }
        add(rectGround);
    }
    private void starCreator(){// creates stars
        if(!isDay){
            for(int i = starQuantity; i > 0; i--){
                int j = (int)(Math.random() * 5 * height/9 - 10);
                int k = (int)(Math.random() * width - 10);
                GRect rectStar = new GRect(k, j, 1, 1);
                rectStar.setFilled(true);
                rectStar.setColor(new Color(227, 227, 227));
                add(rectStar);
            }
        }
    }
    private void cloudCreator(){// creates cloud
            for(int j = 0; j < quantityOfClouds; j++){
                int randomYValue = (int)(Math.random() * 100);
                int randomXValue = (int)(Math.random() * width - 50);
                GOval oval = new GOval(width - randomXValue, height/3 - 2 * heightOfTheRoof/3 - randomYValue, widthOfTheCloud, heightOfTheCloud);
                oval.setFilled(true);
                if(isDay) oval.setColor(new Color(212, 212, 212));
                else oval.setColor(new Color(55, 64, 69));
                add(oval);
                GOval oval1 = new GOval(width - randomXValue - 20, height/3 - 2 * heightOfTheRoof/3 - randomYValue + 20, widthOfTheCloud, heightOfTheCloud);
                oval1.setFilled(true);
                if(isDay) oval1.setColor(new Color(212, 212, 212));
                else oval1.setColor(new Color(55, 64, 69));
                add(oval1);
                GOval oval2 = new GOval(width - randomXValue + 20, height/3 - 2 * heightOfTheRoof/3 - randomYValue + 20, widthOfTheCloud, heightOfTheCloud);
                oval2.setFilled(true);
                if(isDay) oval2.setColor(new Color(212, 212, 212));
                else oval2.setColor(new Color(55, 64, 69));
                add(oval2);
                GOval oval3 = new GOval(width - randomXValue - 40, height/3 - 2 * heightOfTheRoof/3 - randomYValue, widthOfTheCloud, heightOfTheCloud);
                oval3.setFilled(true);
                if(isDay) oval3.setColor(new Color(212, 212, 212));
                else oval3.setColor(new Color(55, 64, 69));
                add(oval3);
        }
    }
    private void signCreator(){// creates sign
        GLabel sign = new GLabel("Hella Nikita", 13 * width/20, 15 * height/20);
        if(!isDay) sign.setColor(Color.GREEN);
        sign.setFont(new Font("Arial", Font.ITALIC, 20));
        add(sign);
    }
}