import stanford.karel.SuperKarel;

public class Practice3First extends SuperKarel {

	public void run() {
        pickUpBeeper();
        while(frontIsClear()) {
            rowSurfing();
            if(leftIsClear()){
                newLevelRoam();
                toTheStartOfTheRow();
            }
        }
        pickUpBeeper();
    }
    private void toTheStartOfTheRow() { // moves to the start of the row
        while (frontIsClear()) {
            pickUpBeeper();
            move();
        }
        turnAround();
    }
    private void newLevelRoam() { // changing a line to the next
        turnLeft();
        pickUpBeeper();
        move();
        pickUpBeeper();
        turnLeft();
    }
    private void rowSurfing() { //surfing through a row and looking for an exit
        while(leftIsBlocked()) {
            move();
            pickUpBeeper();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
    private void pickUpBeeper(){   //shortage of picking up beeper
        if(beepersPresent()){
            pickBeeper();
        }
    }

}
