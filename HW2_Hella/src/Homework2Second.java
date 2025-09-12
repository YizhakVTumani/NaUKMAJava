import stanford.karel.SuperKarel;

public class Homework2Second extends SuperKarel {

	public void run() {
        while(frontIsClear()) {
            rowSurfing();
            if(leftIsClear()){
                newLevelRoam();
                toTheStartOfTheRow();
            }
        }
    }
    private void toTheStartOfTheRow() {
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }
    private void newLevelRoam() {
        turnLeft();
        move();
        turnLeft();
    }
    private void rowSurfing() {
        while(leftIsBlocked()) {
            move();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
}
