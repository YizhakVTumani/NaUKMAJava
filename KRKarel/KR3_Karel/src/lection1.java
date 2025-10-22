import stanford.karel.*;

public class lection1 extends SuperKarel {

    public void run() {
        if(beepersPresent()){
            pickBeeper();
        }
        turnLeft();
        surfingThroughTheMaze();
        while(beepersInBag()){
            putBeeper();
        }
    }
    private void surfingThroughTheMaze() {
        while(frontIsClear()){
            move();
            if(beepersPresent()){
                pickBeeper();
            }
            if(frontIsBlocked()){
                turnRight();
            }
        }
    }
}
