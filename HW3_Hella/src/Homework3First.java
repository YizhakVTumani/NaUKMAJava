import stanford.karel.SuperKarel;

public class Homework3First extends SuperKarel {

	public void run() {
        while(frontIsClear()) {
            surfingRow();
            if (leftIsClear()) {
                rowRoaming();
            }
            else {
                break;
            }
            toTheStartPoint();
            mirroredSurfingRow();
            if (leftIsClear()) {
                rowRoaming();
                toTheStartPoint();
            }
            else{
                break;
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
            if(frontIsBlocked()) {
                break;
            }
            move();
            putBeeper();
        }
    }
    private void mirroredSurfingRow() {
        while(frontIsClear()) {
            move();
            putBeeper();
            if(frontIsBlocked()) {
                break;
            }
            move();
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
