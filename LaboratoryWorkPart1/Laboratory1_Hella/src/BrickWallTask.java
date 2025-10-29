import acm.graphics.GRect;
import acm.program.*;
//Author: Hella Nikita

//Filename: BrickWallTask

// Напишіть програму що малює піраміду. Піраміда складається з горизонтальних рядів цеглин. В кожному наступному ряду кількість цеглин зменшується на один.
//Піраміда має розташовуватися по центру горизонталі вікна. Мають бути використані наступні константи (тестувати при різних значеннях констант):
//
//BRICK_WIDTH - 30 пікселів
//BRICK_HEIGHT - 12 пікселів
//BRICKS_IN_BASE - 14

public class BrickWallTask extends GraphicsProgram {

    private final static int BRICK_HEIGHT = 75;
    private final static int BRICK_WIDTH = 100;

    private final static int BRICK_IN_BASE = 7;
    private final static int WIDTH = 750;
    private final static int HEIGHT = 500;

    public void run(){
        setSize(WIDTH + 20, HEIGHT + 55);
        for (int j = 1; j <= BRICK_IN_BASE; j++) {
            int terminalBricks = BRICK_IN_BASE - j + 1;
            for(int i = 0; i < terminalBricks; i++){
                if ((HEIGHT - BRICK_HEIGHT - j * BRICK_HEIGHT) > 0 & ((WIDTH - (terminalBricks * BRICK_WIDTH))/2 + BRICK_WIDTH * i) + BRICK_WIDTH < WIDTH & ((WIDTH - (terminalBricks * BRICK_WIDTH))/2 + BRICK_WIDTH * i) > 0 ){
                    brickCreator(i, j, terminalBricks);
                }
            }
        }
    }
    private void brickCreator(int w, int h, int bricks){
        GRect rect = new GRect((WIDTH - (bricks * BRICK_WIDTH))/2 + BRICK_WIDTH * w, HEIGHT - BRICK_HEIGHT - h * BRICK_HEIGHT , BRICK_WIDTH, BRICK_HEIGHT);
        add(rect);
    }
}