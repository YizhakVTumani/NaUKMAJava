import stanford.karel.*;

public class lection1 extends SuperKarel {

    public void run() {
        if (frontIsClear()) {
            firstRowCenterX();
            move();
            while (noBeepersPresent()) {
                xCenter();
            }
            pickBeeper();
            turnAround();
            move();
            turnRight();
            firstRowCenterY();
            move();
            while (noBeepersPresent()) {
                yCenter();
            }
            pickBeeper();
            turnAround();
            move();
            for (int i = 0; i < 4; i++) {
                putBeeper();
            }
            turnLeft();
        }
        else {
            for (int i = 0; i < 5; i++) {
                putBeeper();
            }
        }
    }
    public void xCenter() {
        while(noBeepersPresent()) {
            move();
        }
        pickBeeper();
        turnAround();
        move();
        putBeeper();
        move();
    }
    public void firstRowCenterX() {
        putBeeper();
        while(frontIsClear()) {
            move();
        }
        putBeeper();
        turnAround();
    }
    public void yCenter() {
        while(noBeepersPresent()) {
            move();
        }
        pickBeeper();
        turnAround();
        move();
        putBeeper();
        move();
    }
    public void firstRowCenterY() {
        while(frontIsClear()) {
            move();
        }
        putBeeper();
        turnAround();
    }
}
