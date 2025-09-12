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
        move();
        if(frontIsBlocked()) {
            turnLeft();
        }

    }
    private void mirroredRowRoaming() {
        turnRight();
        move();
        if (frontIsClear()) {
            turnRight();
        }
    }
}
