import stanford.karel.SuperKarel;

public class Homework3First extends SuperKarel {

	public void run() {
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
    private void toTheStartPoint() {
        while(frontIsClear()) {
            move();
        }
        turnAround();
    }
    private void surfingRow() {
        putBeeper();
        while(frontIsClear()) {
            move();
            if(frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }
    private void mirroredSurfingRow() {
        while(frontIsClear()) {
            move();
            putBeeper();
            if(frontIsClear()) {
                move();
            }
        }
    }
    private void rowRoaming() {
        turnLeft();
        if (frontIsClear()) {
            move();
            turnLeft();
        }
    }
}
