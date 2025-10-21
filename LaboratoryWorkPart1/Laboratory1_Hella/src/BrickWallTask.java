import acm.graphics.GRect;
import acm.program.*;
//Author: Hella Nikita

//Намалювати сонечко з променями.
//Кількість променів задається константою.
//Промені мають бути розміщені рівномірно.
//

public class BrickWallTask extends GraphicsProgram {

    private final static int BRICK_HEIGHT = 12;
    private final static int BRICK_WIDTH = 30;
    private final static int BRICK_IN_BASE = 100;

    private final static int WIDTH = 500;
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