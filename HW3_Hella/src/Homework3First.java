import stanford.karel.SuperKarel;

public class Homework3First extends SuperKarel {

	public void run() {
        while(frontIsClear()) {
            surfingRow();
            rowRoaming();
            surfingRow();
            mirroredRowRoaming();
        }

    }
    private void surfingRow() {
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
    private void mirroredRowRoaming() {
        turnRight();
        if (frontIsClear()) {
            move();
            turnRight();
        }
    }
}
