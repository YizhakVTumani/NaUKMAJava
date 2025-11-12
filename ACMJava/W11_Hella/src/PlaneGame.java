import acm.program.*;
import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.*;

public class PlaneGame extends GraphicsProgram {

    private static final int PLANE_WIDTH = 50;
    private static final int PLANE_HEIGHT = PLANE_WIDTH / 2;
    private static final int PLANE_SPEED = 5;

    private static final int BMP_WIDTH = 50;
    private static final int BMP_HEIGHT = BMP_WIDTH / 2;
    private static final int BMP_SPEED = 1;

    private static final int TOWER_WIDTH = 150;
    private static final int TOWER_HEIGHT = 150;

    private static final int BULLET_SPEED = 10;

    private static final int BULLET_DIAM = 5;

    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 400;


    private static final int DELAY = 10;


    public void run() {
        setup();
        while (!gameOver()) {
            movePlane();
            moveBMP();
            moveBullet();
            checkForCollisions();
            moveBomb();
            horizontalSpeedOfBomb--;
            verticalSpeedOfBomb += 0.2;
            pause(DELAY);
        }
    }


    private void setup() {
        this.setSize(WINDOW_WIDTH + 70,WINDOW_HEIGHT + 100);
        plane = new GImage("dogfighter-removebg-preview.png");
        plane.setSize(PLANE_WIDTH, PLANE_HEIGHT);
        add(plane, WINDOW_WIDTH, 0);

        int posX = rnd.nextInt(1, WINDOW_WIDTH);
        bmp = new GImage("e4vxHS.png");
        bmp.setSize(BMP_WIDTH, BMP_HEIGHT);
        add(bmp, posX, WINDOW_HEIGHT);

        posX = rnd.nextInt(1, WINDOW_WIDTH);
        bmp2 = new GImage("e4vxHS.png");
        bmp2.setSize(BMP_WIDTH, BMP_HEIGHT);
        add(bmp2, posX, WINDOW_HEIGHT);

        posX = rnd.nextInt(1, WINDOW_WIDTH);
        bmp3 = new GImage("e4vxHS.png");
        bmp3.setSize(BMP_WIDTH, BMP_HEIGHT);
        add(bmp3, posX, WINDOW_HEIGHT);


        posX = rnd.nextInt(1, WINDOW_WIDTH);
        tower = new GImage("tower.png-removebg-preview.png");
        tower.setSize(TOWER_WIDTH, TOWER_HEIGHT);
        add(tower, posX, WINDOW_HEIGHT - TOWER_HEIGHT + 100);

        posX = rnd.nextInt(1, WINDOW_WIDTH);
        tower2 = new GImage("tower.png-removebg-preview.png");
        tower2.setSize(TOWER_WIDTH, TOWER_HEIGHT);
        add(tower2, posX, WINDOW_HEIGHT - TOWER_HEIGHT + 100);

        posX = rnd.nextInt(1, WINDOW_WIDTH);
        tower3 = new GImage("tower.png-removebg-preview.png");
        tower3.setSize(TOWER_WIDTH, TOWER_HEIGHT);
        add(tower3, posX, WINDOW_HEIGHT - TOWER_HEIGHT + 100);


        planeToLeft = true;
        addMouseListeners();
        addKeyListeners();
    }
//    private void

    private boolean gameOver() {
        return (plane == null) || (plane.getY() >= getHeight() - PLANE_HEIGHT);
    }

    public void mouseClicked(MouseEvent e) {
        if (bullet == null) {
            bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
            bullet.setFilled(true);
            bullet.setColor(Color.RED);
            add(bullet, (getWidth() - BULLET_DIAM) / 2, getHeight() - BULLET_DIAM);
        }
    }

    public void keyTyped(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE && bomb == null) {
            System.out.println("bomb spawned");
            bomb = new GImage("FAB-250_M46_Bomb-removebg-preview.png", 50,50);
            add(bomb, plane.getX(), plane.getY());
            dropBomb();
        }
    }

    private void dropBomb(){
        horizontalSpeedOfBomb = PLANE_SPEED;
        verticalSpeedOfBomb = 0.5;
    }

    private void moveBomb(){
        if(bomb != null) {
            System.out.println("bomb dropped");
            if (planeToLeft) {
                bomb.move(-horizontalSpeedOfBomb, verticalSpeedOfBomb);
            }
            else {
                bomb.move(horizontalSpeedOfBomb, verticalSpeedOfBomb);
            }
        }
    }

    private void movePlane() {
        if (planeToLeft) {
            plane.move(-PLANE_SPEED, 0);
            if (plane.getX() <= 0) {
                planeToLeft = false;
                plane.setSize(PLANE_WIDTH *(-1), PLANE_HEIGHT);
                plane.move(0, PLANE_HEIGHT);
            }
        } else {
            plane.move(PLANE_SPEED, 0);
            if (plane.getX() >= getWidth() - PLANE_WIDTH) {
                planeToLeft = true;
                plane.setSize(PLANE_WIDTH, PLANE_HEIGHT);
                plane.move(0, PLANE_HEIGHT);
            }
        }
    }

    private void moveBMP() {
        if (bmpToLeft) {
            bmp.move(-BMP_SPEED, 0);
            if (bmp.getX() <= 0) {
                bmp.setSize(BMP_WIDTH *(-1), BMP_HEIGHT);
                bmpToLeft = false;
            }
        } else {
            bmp.move(BMP_SPEED, 0);
            if (bmp.getX() >= getWidth() - BMP_WIDTH) {
                bmp.setSize(BMP_WIDTH, BMP_HEIGHT);
                bmpToLeft = true;
            }
        }

        if (bmp2ToLeft) {
            bmp2.move(-BMP_SPEED, 0);
            if (bmp2.getX() <= 0) {
                bmp2.setSize(BMP_WIDTH *(-1), BMP_HEIGHT);
                bmp2ToLeft = false;
            }
        } else {
            bmp2.move(BMP_SPEED, 0);
            if (bmp2.getX() >= getWidth() - BMP_WIDTH) {
                bmp2.setSize(BMP_WIDTH, BMP_HEIGHT);
                bmp2ToLeft = true;
            }
        }

        if (bmp3ToLeft) {
            bmp3.move(-BMP_SPEED, 0);
            if (bmp3.getX() <= 0) {
                bmp3.setSize(BMP_WIDTH *(-1), BMP_HEIGHT);
                bmp3ToLeft = false;
            }
        } else {
            bmp3.move(BMP_SPEED, 0);
            if (bmp3.getX() >= getWidth() - BMP_WIDTH) {
                bmp3.setSize(BMP_WIDTH, BMP_HEIGHT);
                bmp3ToLeft = true;
            }
        }
    }

    private void moveBullet() {
        if (bullet != null) {
            bullet.move(0, -BULLET_SPEED);
        }
    }

    private void checkForCollisions() {
        collideWithPlane();
        collideWithTower();
        moveOffScreen();
    }

    private void collideWithPlane() {
        if (bullet != null) {
            GObject collObj = getElementAt(bullet.getX(), bullet.getY());
            if (collObj == plane) {
                remove(plane);
                remove(bullet);
                plane = null;
                bullet = null;
            }
        }
    }

    private void collideWithTower() {
        GObject collObj = getElementAt(plane.getX(), plane.getY());
        if (collObj == tower) {
            remove(tower);
            remove(plane);
            tower = null;
            plane = null;
        }
        if (collObj == tower2) {
            remove(tower2);
            remove(plane);
            tower2 = null;
            plane = null;
        }
        if (collObj == tower3) {
            remove(tower3);
            remove(plane);
            tower3 = null;
            plane = null;
        }

    }

    private void moveOffScreen() {
        if (bullet != null) {
            if (bullet.getY() <= -BULLET_DIAM) {
                remove(bullet);
                bullet = null;
            }
        }
        if (bomb != null){
            if (bomb.getY() >= HEIGHT){
                bombDestruction(bomb.getX());
                remove(bomb);
                bomb = null;
            }
        }
    }
     private void bombDestruction(double x) {
        int radiusOfDestruction = 30;
        if (bmp.getX() < x + radiusOfDestruction &&  bmp.getX() > x - radiusOfDestruction) {
            remove(bmp);
            bmp = null;
        }
        if (bmp2.getX() < x + radiusOfDestruction &&  bmp2.getX() > x - radiusOfDestruction) {
            remove(bmp2);
            bmp2 = null;
        }
        if(bmp3.getX() < x + radiusOfDestruction &&  bmp3.getX() > x - radiusOfDestruction) {
            remove(bmp3);
            bmp3 = null;
        }
        if (tower.getX() < x + radiusOfDestruction && tower.getX() > x - radiusOfDestruction){
            remove(tower);
            tower = null;
        }
        if (tower2.getX() < x + radiusOfDestruction &&  tower2.getX() > x - radiusOfDestruction) {
            remove(tower2);
            tower2 = null;
        }
        if (tower3.getX() < x + radiusOfDestruction && tower3.getX() > x - radiusOfDestruction) {
            remove(tower3);
            tower3 = null;
        }
     }

    RandomGenerator rnd = new RandomGenerator();
    private GImage tower;
    private GImage tower2;
    private GImage tower3;
    private GImage bmp;
    private GImage bmp2;
    private GImage bmp3;
    private GImage plane;
    private GOval bullet;
    private GImage bomb;
    int horizontalSpeedOfBomb;
    double verticalSpeedOfBomb;
    private boolean planeToLeft;
    private boolean bmpToLeft = true;
    private boolean bmp2ToLeft = true;
    private boolean bmp3ToLeft = true;
}