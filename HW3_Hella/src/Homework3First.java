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
            surfingRow();
            //mirroredSurfingRow();
            if (rightIsClear()) {
                mirroredRowRoaming();
            }
            else{
                break;
            }
        }

    }
    private void surfingRow() {
        while(frontIsClear()) {
            putBeeper();
            move();
            if(frontIsBlocked()) {
                break;
            }
            move();
        }
    }
    private void mirroredSurfingRow() {
        while(frontIsClear()) {
            putBeeper();
            move();
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
    private void mirroredRowRoaming() {
        turnRight();
        if (frontIsClear()) {
            move();
            turnRight();
        }
    }
}
