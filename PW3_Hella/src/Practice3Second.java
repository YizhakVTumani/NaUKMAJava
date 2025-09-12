import stanford.karel.*;

public class Practice3Second extends SuperKarel {

	public void run() {
        turnLeft();
        pickUpBeeper();
        while(frontIsClear()) {
            columnSurfing();
            if(rightIsClear()){
                newLevelRoam();
                toTheStartOfTheRow();
            }
        }
        pickUpBeeper();
    }
    private void pickUpBeeper() {
        if (beepersPresent()){
            pickBeeper();
        }
    }
    private void toTheStartOfTheRow() {
        while (frontIsClear()) {
            move();
            pickUpBeeper();
        }
        turnAround();

    }
    private void columnSurfing() {
        while(rightIsBlocked()) {
            move();
            pickUpBeeper();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
    private void newLevelRoam() {
        pickUpBeeper();
        turnRight();
        move();
        turnLeft();
        turnAround();
        pickUpBeeper();
        
    }
}
