import acm.program.*;
import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.*;

//author: Hella Nikita
//filename: XandO.java

//написати гру в хрестики нулики на дошці розмірності 3*3 - Вимоги: в кінці гри візуально виділити лінію перемоги, виводиться хто переміг, можливість грати знову.


public class XandO extends GraphicsProgram {
    private static final int  WIDTH = 600;
    private static final int HEIGHT = 600;

    public void run(){
        this.setSize(WIDTH+15,HEIGHT+60);

        addMouseListeners();
        DrawMap();

        while(!gameEnded){
            checkForWin();
        }
        pause(1000);
        resultScreen();
    }

    private void DrawMap(){ // draws a map
        GRect rect1 = new GRect(0,0,WIDTH/3,HEIGHT/3);
        GRect rect2 = new GRect(WIDTH/3,0,WIDTH/3,HEIGHT/3);
        GRect rect3 = new GRect(2*(WIDTH/3),0,WIDTH/3,HEIGHT/3);
        GRect rect4 = new GRect(0,HEIGHT/3,WIDTH/3,HEIGHT/3);
        GRect rect5 = new GRect(WIDTH/3,HEIGHT/3,WIDTH/3,HEIGHT/3);
        GRect rect6 = new GRect(2*(WIDTH/3),HEIGHT/3,WIDTH/3,HEIGHT/3);
        GRect rect7 = new GRect(0,2*(HEIGHT/3),WIDTH/3,HEIGHT/3);
        GRect rect8 = new GRect(WIDTH/3,2*(HEIGHT/3),WIDTH/3,HEIGHT/3);
        GRect rect9 = new GRect(2*(WIDTH/3),2*(HEIGHT/3),WIDTH/3,HEIGHT/3);


        add(rect1);
        add(rect2);
        add(rect3);
        add(rect4);
        add(rect5);
        add(rect6);
        add(rect7);
        add(rect8);
        add(rect9);
    }

    public void mouseClicked(MouseEvent e) { // checks the position of mouse and adds crosses or circles
        int x = e.getX();
        int y = e.getY();

            if (!gameEnded) {
                if (x < WIDTH / 3 && y < HEIGHT / 3) {
                    if (step == 1 && spot11 != 2 && spot11 != 1) {
                        spot11 = 1;
                        step++;
                        line1 = new GLine(0, 0, WIDTH / 3, HEIGHT / 3);
                        line2 = new GLine(WIDTH / 3, 0, 0, HEIGHT / 3);
                    } else if (step == 2 && spot11 != 2 && spot11 != 1) {
                        spot11 = 2;
                        step--;
                        oval1 = new GOval(0, 0, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > WIDTH / 3 && x < (2 * WIDTH) / 3 && y < HEIGHT / 3) {
                    if (step == 1 && spot12 != 2 && spot12 != 1) {
                        spot12 = 1;
                        step++;
                        line1 = new GLine(WIDTH / 3, 0, 2 * WIDTH / 3, HEIGHT / 3);
                        line2 = new GLine(2 * WIDTH / 3, 0, WIDTH / 3, HEIGHT / 3);
                    } else if (step == 2 && spot12 != 2 && spot12 != 1) {
                        spot12 = 2;
                        step--;
                        oval1 = new GOval(WIDTH / 3, 0, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > (2 * WIDTH) / 3 && y < HEIGHT / 3) {
                    if (step == 1 && spot13 != 2 && spot13 != 1) {
                        spot13 = 1;
                        step++;
                        line1 = new GLine(2 * WIDTH / 3, 0, WIDTH, HEIGHT / 3);
                        line2 = new GLine(WIDTH, 0, 2 * WIDTH / 3, HEIGHT / 3);
                    } else if (step == 2 && spot13 != 2 && spot13 != 1) {
                        spot13 = 2;
                        step--;
                        oval1 = new GOval(2 * WIDTH / 3, 0, WIDTH / 3, HEIGHT / 3);

                    }
                } else if (x < WIDTH / 3 && y > HEIGHT / 3 && y < (2 * HEIGHT) / 3) {
                    if (step == 1 && spot21 != 2 && spot21 != 1) {
                        spot21 = 1;
                        step++;
                        line1 = new GLine(0, HEIGHT / 3, WIDTH / 3, 2 * HEIGHT / 3);
                        line2 = new GLine(WIDTH / 3, HEIGHT / 3, 0, 2 * HEIGHT / 3);
                    } else if (step == 2 && spot21 != 2 && spot21 != 1) {
                        spot21 = 2;
                        step--;
                        oval1 = new GOval(0, HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > WIDTH / 3 && x < (2 * WIDTH) / 3 && y > HEIGHT / 3 && y < (2 * HEIGHT) / 3) {
                    if (step == 1 && spot22 != 2 && spot22 != 1) {
                        spot22 = 1;
                        step++;
                        line1 = new GLine(WIDTH / 3, HEIGHT / 3, 2 * WIDTH / 3, 2 * HEIGHT / 3);
                        line2 = new GLine(2 * WIDTH / 3, HEIGHT / 3, WIDTH / 3, 2 * HEIGHT / 3);
                    } else if (step == 2 && spot22 != 2 && spot22 != 1) {
                        spot22 = 2;
                        step--;
                        oval1 = new GOval(WIDTH / 3, HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > (2 * WIDTH) / 3 && y > HEIGHT / 3 && y < (2 * HEIGHT) / 3) {
                    if (step == 1 && spot23 != 2 && spot23 != 1) {
                        spot23 = 1;
                        step++;
                        line1 = new GLine(2 * WIDTH / 3, HEIGHT / 3, WIDTH, 2 * HEIGHT / 3);
                        line2 = new GLine(WIDTH, HEIGHT / 3, 2 * WIDTH / 3, 2 * HEIGHT / 3);
                    } else if (step == 2 && spot23 != 2 && spot23 != 1) {
                        spot23 = 2;
                        step--;
                        oval1 = new GOval(2 * WIDTH / 3, HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x < WIDTH / 3 && y > (2 * HEIGHT) / 3) {
                    if (step == 1 && spot31 != 2 && spot31 != 1) {
                        spot31 = 1;
                        step++;
                        line1 = new GLine(0, 2 * HEIGHT / 3, WIDTH / 3, HEIGHT);
                        line2 = new GLine(WIDTH / 3, 2 * HEIGHT / 3, 0, HEIGHT);
                    } else if (step == 2 && spot31 != 2 && spot31 != 1) {
                        spot31 = 2;
                        step--;
                        oval1 = new GOval(0, 2 * HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > WIDTH / 3 && x < (2 * WIDTH) / 3 && y > (2 * HEIGHT) / 3) {
                    if (step == 1 && spot32 != 2 && spot32 != 1) {
                        spot32 = 1;
                        step++;
                        line1 = new GLine(WIDTH / 3, 2 * HEIGHT / 3, 2 * WIDTH / 3, HEIGHT);
                        line2 = new GLine(2 * WIDTH / 3, 2 * HEIGHT / 3, WIDTH / 3, HEIGHT);
                    } else if (step == 2 && spot32 != 2 && spot32 != 1) {
                        spot32 = 2;
                        step--;
                        oval1 = new GOval(WIDTH / 3, 2 * HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                } else if (x > (2 * WIDTH) / 3 && y > (2 * HEIGHT) / 3) {
                    if (step == 1 && spot33 != 2 && spot33 != 1) {
                        spot33 = 1;
                        step++;
                        line1 = new GLine(2 * WIDTH / 3, 2 * HEIGHT / 3, WIDTH, HEIGHT);
                        line2 = new GLine(WIDTH, 2 * HEIGHT / 3, 2 * WIDTH / 3, HEIGHT);
                    } else if (step == 2 && spot33 != 2 && spot33 != 1) {
                        spot33 = 2;
                        step--;
                        oval1 = new GOval(2 * WIDTH / 3, 2 * HEIGHT / 3, WIDTH / 3, HEIGHT / 3);
                    }
                }


                add(line1);
                add(line2);
                add(oval1);
            }
    }

    private void checkForWin(){
        if(spot11 == spot12 && spot11 == spot13 && spot11 != 0){
            winnerLine = new GLine(0, HEIGHT/6, WIDTH, HEIGHT/6);
            if (spot11 == 1){
                winner = 1;
            }
            else if (spot11 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else if(spot21 == spot22 && spot21 == spot23 && spot21 != 0){
            winnerLine = new GLine(0, HEIGHT/2, WIDTH, HEIGHT/2);
            if (spot21 == 1){
                winner = 1;
            }
            else if (spot21 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else if (spot31 == spot32 && spot31 == spot33 && spot31 != 0){
            winnerLine = new GLine(0, 5*HEIGHT/6, WIDTH, 5*HEIGHT/6);
            if (spot31 == 1){
                winner = 1;
            }
            else if (spot31 == 2){
                winner = 2;
            }
            gameEnded = true;
        }


        else if (spot11 == spot21 && spot11 == spot31 && spot11 != 0){
            winnerLine = new GLine(WIDTH/6, 0, WIDTH/6, HEIGHT);
            if (spot11 == 1){
                winner = 1;
            }
            else if (spot11 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else  if (spot12 == spot22 && spot12 == spot32 && spot12 != 0){
            winnerLine = new GLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
            if (spot12 == 1){
                winner = 1;
            }
            else if (spot12 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else if (spot13 == spot23 && spot23 == spot33 && spot13 != 0){
            winnerLine = new GLine(5*WIDTH/6, 0, 5*WIDTH/6, HEIGHT);
            if (spot13 == 1){
                winner = 1;
            }
            else if (spot13 == 2){
                winner = 2;
            }
            gameEnded = true;
        }


        else if (spot11 == spot22 && spot11 == spot33 && spot11 != 0){
            winnerLine = new GLine(0, 0, WIDTH, HEIGHT);
            if (spot11 == 1){
                winner = 1;
            }
            else if (spot11 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else if (spot31 == spot22 && spot22 == spot13 && spot13 != 0){
            winnerLine = new GLine(WIDTH, 0, 0, HEIGHT);
            if (spot31 == 1){
                winner = 1;
            }
            else if (spot31 == 2){
                winner = 2;
            }
            gameEnded = true;
        }
        else if(spot11 != 0 && spot21 != 0 && spot12 != 0 && spot13 != 0 && spot22 !=0 && spot23 != 0 && spot31 != 0 && spot32 != 0 && spot33 != 0){
            gameEnded = true;
        }

        if(gameEnded && winner != 0){
            winnerLine.setColor(Color.RED);
            add(winnerLine);
        }
    } // checks if conditions for win are got


    private void resultScreen(){
        GRect resultScreen = new GRect(0, 0, WIDTH, HEIGHT);
        GLabel resultScreenLine;
        resultScreen.setFilled(true);
        resultScreen.setFillColor(Color.white);
        if (winner == 2){
            add(resultScreen);
            resultScreenLine= new GLabel("Circles WON!",WIDTH/2, HEIGHT/2);
            add(resultScreenLine);
        }
        else if (winner == 1){
            add(resultScreen);
            resultScreenLine= new GLabel("Crosses WON!",WIDTH/2, HEIGHT/2);
            add(resultScreenLine);
        }
        else {
            add(resultScreen);
            resultScreenLine= new GLabel("DRAW",WIDTH/2, HEIGHT/2);
            add(resultScreenLine);
        }
        pause(500);
    } // screen with result



    private int winner = 0;

    private GLine winnerLine;

    private GLine line1;
    private GLine line2;
    private GOval oval1;

    // if the step counter = 1 -- turn of christ, if 2 -- turn of circle
    public int step = 1;

    // if spot (row)(column) = 0 -- it's free, if 1 -- there is a christ, if 2 -- there is a circle
    private int spot11 = 0;
    private int spot12 = 0;
    private int spot13 = 0;

    private int spot21 = 0;
    private int spot22 = 0;
    private int spot23 = 0;

    private int spot31 = 0;
    private int spot32 = 0;
    private int spot33 = 0;

    private boolean gameEnded = false;

}
