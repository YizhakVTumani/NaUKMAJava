import stanford.karel.*;

//Author: Hella Nikita

//Та ж сама задача, лише тепер стіни розташовані лише вертикально.


public class Practice3Second extends SuperKarel {

	public void run() {
        pickBeeper();
        while(frontIsClear()) {
            if(leftIsBlocked()) {
                move();
                pickBeeper();
            }
            else{
                break;
            }
        }
        turnLeft();
        pickUpBeeper();
        while(frontIsClear()) {
            seekForBeepers();
            toTheStartOfTheRow();
            rowSurfing();
            if(rightIsClear()){
                newLevelRoam();
                toTheStartOfTheRow();
            }
        }
        turnRight();
        pickUpBeeper();
    }
    private void seekForBeepers(){ // Karel goes through the row and picks up all the beepers
        while(frontIsClear()){
            move();
            pickUpBeeper();
        }
        turnAround();
    }
    private void pickUpBeeper() { // shortage for picking up beeper
        if (beepersPresent()){
            pickBeeper();
        }
    }
    private void toTheStartOfTheRow() { // moves to the start of the row
        while (frontIsClear()) {
            move();
            pickUpBeeper();
        }
        turnAround();

    }
    private void rowSurfing() { // surfing through a column and looking for an exit
        while(rightIsBlocked()) {
            move();
            pickUpBeeper();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
    private void newLevelRoam() { // changing a line to the next
        pickUpBeeper();
        turnRight();
        move();
        turnLeft();
        turnAround();
        pickUpBeeper();
        
    }
}
