import acm.program.*;
import acm.graphics.*;
import acm.util.RandomGenerator;
import acm.util.SoundClip;

import java.awt.*;
import java.awt.event.*;

//написати гру в якій літак має збивати цілі, що розміщені на землі -  Вимоги: цілі - рухомі і нерухомі, розміщення цілей генерується, літак - зображення літака несиметричне, літак летить в одну сторону, долітає до краю вікна і розвертається - летить в іншу сторону, літак при зіткненні з ціллю або землею взривається; додати візуальні та аудіо ефекти.

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

    public static final int RADIUS_OF_DESTRUCTION = 70;

    private static final int DELAY = 10;


    public void run() {
        setup();
        while (!gameOver()) {
            movePlane();
            moveBMP();
            moveBullet();
            checkForCollisions();
            moveBomb();
            pause(DELAY);
            if(quantityOfTargets == 0){
                plane = null;
            }
        }
        finishScreen();
    }


    private void setup() {

        if(rnd.nextBoolean()) {
            background = new GImage("austerlitz-soleil-plateau-de-pratzen-vue-444.png", 0, 0);
        }
        else{
            background = new GImage("la-favorita-champ-444.png", 0, 0);
        }
        background.setSize(WINDOW_WIDTH + 70, WINDOW_HEIGHT + 100);
        add(background);

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
    } // setup

    private boolean gameOver() {
        return (plane == null) || (plane.getY() >= getHeight() - PLANE_HEIGHT);
    } // checks if the game is over

    private void finishScreen() {
        if (quantityOfTargets == 0 || planeCollided){
            GLabel winner = new GLabel("The Plane Won!");
            winner.setFont(new Font("Arial", Font.BOLD, 30));
            add(winner, WINDOW_WIDTH/2 - 100, WINDOW_HEIGHT/2);
        }
        else {
            GLabel winner = new GLabel("The AA Won!");
            winner.setFont(new Font("Arial", Font.BOLD, 30));
            add(winner, WINDOW_WIDTH/2 - 100, WINDOW_HEIGHT/2);
        }
    } // screen with results

    public void mouseClicked(MouseEvent e) {
        if (bullet == null) {
            bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
            bullet.setFilled(true);
            bullet.setColor(Color.RED);
            add(bullet, (getWidth() - BULLET_DIAM) / 2, getHeight() - BULLET_DIAM);
        }
    } // shots a bullet

    public void keyPressed(KeyEvent e){ // drops a bomb
        if (e.getKeyCode() == KeyEvent.VK_SPACE && bomb == null && plane != null) {
            System.out.println("bomb spawned");
            bomb = new GImage("FAB-250_M46_Bomb-removebg-preview.png");
            bomb.setSize(50, 50);
            add(bomb, plane.getX(), plane.getY());
            dropBomb();
        }
    }

    private void dropBomb(){
        horizontalSpeedOfBomb = PLANE_SPEED;
        verticalSpeedOfBomb = 0.5;
    } // speed of the bomb

    private void moveBomb(){
        if(bomb != null) {
            verticalSpeedOfBomb += 0.5;
            horizontalSpeedOfBomb -= 0.01;
            if (horizontalSpeedOfBomb <= 0){
                horizontalSpeedOfBomb = 0;
            }

            if (planeToLeft) {
                bomb.move(-horizontalSpeedOfBomb, verticalSpeedOfBomb);
            }
            else {
                bomb.move(horizontalSpeedOfBomb, verticalSpeedOfBomb);
            }
        }
    } // moves a bomb

    private void movePlane() {
        if (plane != null) {
            if (planeToLeft) {
                plane.move(-PLANE_SPEED, 0);
                if (plane.getX() <= 0) {
                    planeToLeft = false;
                    plane.setSize(PLANE_WIDTH * (-1), PLANE_HEIGHT);
                    plane.move(0, PLANE_HEIGHT);
                }
            }
            else {
                plane.move(PLANE_SPEED, 0);
                if (plane.getX() >= getWidth() - PLANE_WIDTH) {
                    planeToLeft = true;
                    plane.setSize(PLANE_WIDTH, PLANE_HEIGHT);
                    plane.move(0, PLANE_HEIGHT);
                }
            }
        }
    } // moves a plane

    private void moveBMP() {
        if(bmp != null) {
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
        }

        if(bmp2 != null) {
            if (bmp2ToLeft) {
                bmp2.move(-BMP_SPEED, 0);
                if (bmp2.getX() <= 0) {
                    bmp2.setSize(BMP_WIDTH * (-1), BMP_HEIGHT);
                    bmp2ToLeft = false;
                }
            } else {
                bmp2.move(BMP_SPEED, 0);
                if (bmp2.getX() >= getWidth() - BMP_WIDTH) {
                    bmp2.setSize(BMP_WIDTH, BMP_HEIGHT);
                    bmp2ToLeft = true;
                }
            }
        }

        if(bmp3 != null) {
            if (bmp3ToLeft) {
                bmp3.move(-BMP_SPEED, 0);
                if (bmp3.getX() <= 0) {
                    bmp3.setSize(BMP_WIDTH * (-1), BMP_HEIGHT);
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
    } // moves a bmp

    private void moveBullet() {
        if (bullet != null) {
            bullet.move(0, -BULLET_SPEED);
        }
    } // moves a bullet

    private void checkForCollisions() {
        collideWithPlane();
        collideWithTower();
        moveOffScreen();
    } // checks for collisions

    private void collideWithPlane() {
        if (bullet != null && plane != null) {
            if (planeToLeft){
                GObject collObj = getElementAt(bullet.getX(), bullet.getY());
                if (collObj == plane) {
                    remove(plane);
                    remove(bullet);
                    plane = null;
                    bullet = null;
                }
            }
            else
            {
                GObject collObj = getElementAt(bullet.getX(), bullet.getY());
                if (collObj == plane) {
                    remove(plane);
                    remove(bullet);
                    plane = null;
                    bullet = null;
                }
            }
        }
    } // checks collision with a plane

    private void collideWithTower() {
        if(plane != null) {
            GObject collObj = getElementAt(plane.getX(), plane.getY());
            if (tower != null) {
                if (collObj == tower) {
                    fire = new GImage("Без_названия__1_-removebg-preview.png");
                    fire.setSize(70,70);
                    add(fire, plane.getX(), plane.getY());
                    remove(tower);
                    remove(plane);
                    tower = null;
                    plane = null;
                    planeCollided = true;
//                    String file = "C:\\JavaUni\\NaUKMAJava\\ACMJava\\W11_Hella\\images\\explosion-fx-343683.wav";
//                    soundClip = new SoundClip(file);
//                    soundClip.setVolume(2);
//                    soundClip.play();
                }
            }
            if (tower2 != null){
                if (collObj == tower2) {
                    fire = new GImage("Без_названия__1_-removebg-preview.png");
                    fire.setSize(70,70);
                    add(fire, plane.getX(), plane.getY());
                    remove(tower2);
                    remove(plane);
                    tower2 = null;
                    plane = null;
                    planeCollided = true;
                    String file = "C:\\JavaUni\\NaUKMAJava\\ACMJava\\W11_Hella\\images\\explosion-fx-343683.wav";
                    soundClip = new SoundClip(file);
                    soundClip.setVolume(2);
                    soundClip.play();
                }
            }
            if (tower3 != null){
                if (collObj == tower3) {
                    fire = new GImage("Без_названия__1_-removebg-preview.png");
                    fire.setSize(70,70);
                    add(fire, plane.getX(), plane.getY());
                    remove(tower3);
                    remove(plane);
                    tower3 = null;
                    plane = null;
                    planeCollided = true;
                    String file = "C:\\JavaUni\\NaUKMAJava\\ACMJava\\W11_Hella\\images\\explosion-fx-343683.wav";
                    soundClip = new SoundClip(file);
                    soundClip.setVolume(2);
                    soundClip.play();
                }
            }

        }

    } // checks collision with a tower

    private void moveOffScreen() {
        if (bullet != null) {
            if (bullet.getY() <= -BULLET_DIAM) {
                remove(bullet);
                bullet = null;
            }
        }
        if (bomb != null){
            if (bomb.getY() >= WINDOW_HEIGHT) {
                System.out.println(bomb.getY());
                bombDestruction(bomb.getX());
                remove(bomb);
                bomb = null;
            }
        }
    } // checks if a bullet and a bomb are out of the screen

    private void bombDestruction(double x) {
        if (bmp != null && bmp.getX() < x + RADIUS_OF_DESTRUCTION &&  bmp.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(bmp);
            bmp = null;
            quantityOfTargets--;
        }
        if (bmp2 != null && bmp2.getX() < x + RADIUS_OF_DESTRUCTION &&  bmp2.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(bmp2);
            bmp2 = null;
            quantityOfTargets--;
        }
        if(bmp3 != null && bmp3.getX() < x + RADIUS_OF_DESTRUCTION &&  bmp3.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(bmp3);
            bmp3 = null;
            quantityOfTargets--;
        }
        if (tower != null && tower.getX() < x + RADIUS_OF_DESTRUCTION && tower.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(tower);
            tower = null;
            quantityOfTargets--;
        }
        if (tower2 != null && tower2.getX() < x + RADIUS_OF_DESTRUCTION && tower2.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(tower2);
            tower2 = null;
            quantityOfTargets--;
        }
        if (tower3 != null && tower3.getX() < x + RADIUS_OF_DESTRUCTION && tower3.getX() > x - RADIUS_OF_DESTRUCTION) {
            remove(tower3);
            tower3 = null;
            quantityOfTargets--;
        }
        fire = new GImage("Без_названия__1_-removebg-preview.png");
        fire.setSize(70,70);
        if(bomb.getY() > WINDOW_HEIGHT - 70){
            add(fire, bomb.getX() - RADIUS_OF_DESTRUCTION/2, WINDOW_HEIGHT - 30);
        }
        else {
            add(fire, bomb.getX() - RADIUS_OF_DESTRUCTION/2, bomb.getY());
        }
//        String file = "C:\\JavaUni\\NaUKMAJava\\ACMJava\\W11_Hella\\images\\explosion-fx-343683.wav";
//        String file1 = "explosion-fx-343683.wav";
//        soundClip = new SoundClip(file1);
//        soundClip.setVolume(2);
//        soundClip.play();
     } // simulates explosion of the bomb

    RandomGenerator rnd = new RandomGenerator();
    private boolean planeCollided;
    private GImage fire;
    private GImage tower;
    private GImage tower2;
    private GImage tower3;
    private GImage bmp;
    private GImage bmp2;
    private GImage bmp3;
    public GImage plane;
    private GOval bullet;
    private GImage bomb;
    private GImage background;
    double horizontalSpeedOfBomb;
    double verticalSpeedOfBomb;
    private boolean planeToLeft;
    private boolean bmpToLeft = true;
    private boolean bmp2ToLeft = true;
    private boolean bmp3ToLeft = true;
    private int quantityOfTargets = 6;
    public SoundClip soundClip;
}