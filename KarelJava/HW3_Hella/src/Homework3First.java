import stanford.karel.SuperKarel;


//Author: Hella Nikita

//В цьому завданні задачею Карела є розставити біпери в шаховому порядку в середині порожнього прямокутника


public class Homework3First extends SuperKarel {

	public void run() {
        putBeeper();
        while(frontIsClear()) {

            surfingRow();
            if (leftIsClear()) {
                rowRoaming();
                toTheStartPoint();
                mirroredSurfingRow();
            }
            if (leftIsClear()) {
                rowRoaming();
                toTheStartPoint();
            }
        }
        turnLeft();
        while(frontIsClear()) {
            surfingRow();
        }
        turnRight();
    }
    private void toTheStartPoint() { // karel moves to the start of the row
        while(frontIsClear()) {
            move();
        }
        turnAround();
    }
    private void surfingRow() {// karel moves along the row and puts beepers
        if (noBeepersPresent()){
            putBeeper();
        }

        while(frontIsClear()) {
            move();
            if(frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }
    private void mirroredSurfingRow() { // karel moves along the row and puts beepers (another way as method surfing row)
        while(frontIsClear()) {
            move();
            putBeeper();
            if(frontIsClear()) {
                move();
            }
        }
    }
    private void rowRoaming() { // karel switches lines to the next
        turnLeft();
        if (frontIsClear()) {
            move();
            turnLeft();
        }
    }
}
