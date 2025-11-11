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
    private static final int BMP_SPEED = 2;

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
            pause(DELAY); }
    }


    private void setup() {
        this.setSize(WINDOW_WIDTH + 70,WINDOW_HEIGHT + 100);
        plane = new GImage("dogfighter-removebg-preview.png");
        plane.setSize(PLANE_WIDTH, PLANE_HEIGHT);
        add(plane, WINDOW_WIDTH, 0);

        for (int i = 0; i < 3; i++) {
            int posX = rnd.nextInt(1, WINDOW_WIDTH);
            bmp = new GImage("e4vxHS.png");
            bmp.setSize(BMP_WIDTH, BMP_HEIGHT);
            add(bmp, posX, WINDOW_HEIGHT);
        }

        for  (int i = 0; i < 3; i++) {
            int posX = rnd.nextInt(1, WINDOW_WIDTH);
            tower = new GImage("tower.png-removebg-preview.png");
            tower.setSize(TOWER_WIDTH, TOWER_HEIGHT);
            add(tower, posX, WINDOW_HEIGHT - TOWER_HEIGHT + 100);
        }


        planeToLeft = true;
        addMouseListeners();
    }

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
                plane.setSize(PLANE_WIDTH /(-1), PLANE_HEIGHT);
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
                bmp.setSize(BMP_WIDTH /(-1), BMP_HEIGHT);
                bmpToLeft = true;
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
    }



    private void moveOffScreen() {
        if (bullet != null) {
            if (bullet.getY() <= -BULLET_DIAM) {
                remove(bullet);
                bullet = null;
            }
        }
    }

    RandomGenerator rnd = new RandomGenerator();
    private GImage tower;
    private GImage bmp;
    private GImage plane;
    private GOval bullet;
    private boolean planeToLeft;
    private boolean bmpToLeft;
}