import stanford.karel.SuperKarel;

public class Practice3First extends SuperKarel {

	public void run() {
        pickUpBeeper();
        while(frontIsClear()) {
            seekForBeeper();
            toTheStartOfTheColumn();
            columnSurfing();
            if(leftIsClear()){
                newLevelRoam();
                toTheStartOfTheColumn();
            }
        }
        pickUpBeeper();
    }
    private void seekForBeeper(){ // Karel goes through the column and picks up all the beepers
        while(frontIsClear()){
            move();
            pickUpBeeper();
        }
        turnAround();
    }
    private void toTheStartOfTheColumn() { // moves to the start of the column
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
    private void columnSurfing() { //surfing through a column and looking for an exit
        while(leftIsBlocked()) {
            move();
            pickUpBeeper();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
    private void pickUpBeeper(){   // shortage for picking up beeper
        if(beepersPresent()){
            pickBeeper();
        }
    }

}
