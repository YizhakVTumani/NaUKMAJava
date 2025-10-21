import stanford.karel.*;

public class lection1 extends SuperKarel {

    public void run() {
        putBeeper();
        turnLeft();
        goingThroughAColumn();
        checkForBeeper();
        goingThroughARow();
        while(frontIsClear()){
            goingThroughAColumn();
            checkForBeeper();
            goingThroughARow();
        }
    }
    public void goingThroughARow() {
        while(frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                putBeeper();
            }
        }
        checkForBeeper();
    }
    public void goingThroughAColumn() {
        while(frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                putBeeper();
            }
        }
    }
    public void checkForBeeper() {
        if(frontIsBlocked()){
            if (beepersPresent()){
                turnRight();
            }
            else{
                turnRight();
                move();
                putBeeper();
            }
        }

    }
}
