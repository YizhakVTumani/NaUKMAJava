import stanford.karel.*;

public class lection1 extends SuperKarel {

    public void run() {
        putBeeper();
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
        if(facingWest()){
            turnAround();
        }
        else if(facingNorth()){
            turnRight();
        }
        else if(facingSouth()){
            turnLeft();
        }
    }
    public void goingThroughARow() {
        while(frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                putBeeper();
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
                if (frontIsClear()){
                    move();
                    putBeeper();
                    putBeeper();
                }
            }
        }
    }
}
