import stanford.karel.SuperKarel;

public class Practice2Second extends SuperKarel {

	public void run() {
        findNewspaper();
        pickBeeper();
        comeBackToStartPoint();
    }
    private void findNewspaper() {
        while (frontIsClear()) {
            move();
        }
        turnRight();
        while (leftIsBlocked()) {
            move();
        }
        turnLeft();
        move();
    }
    private void comeBackToStartPoint() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnRight();
        move();
        turnRight();
    }
}
