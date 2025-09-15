import stanford.karel.SuperKarel;

public class Practice2Third extends SuperKarel {

	public void run() {
        renewColumn();
        moveBackToTheBottom();
        moveToTheNextColumn();
        while(frontIsClear()) {
            renewColumn();
            moveBackToTheBottom();
            moveToTheNextColumn();
        }
        renewColumn();
        moveBackToTheBottom();
    }
    private void renewColumn() {
        turnLeft();
        while(frontIsClear()) {
            if (noBeepersPresent()){
                putBeeper();
                move();
            }
            else{
                move();
            }
        }
        if (noBeepersPresent()){
            putBeeper();
        }
    }
    private void moveBackToTheBottom() {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }
    private void moveToTheNextColumn() {
        for (int i = 0; i < 4; i++){
            move();
        }
    }
}
