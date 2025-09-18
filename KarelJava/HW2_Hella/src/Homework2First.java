import stanford.karel.*;

public class Homework2First extends SuperKarel {

	public void run() {
        moveToTheWall();
        comeBack();
    }
    private void moveToTheWall() {
        while (leftIsBlocked()) {
            if (frontIsClear()){
                move();
            }
            else {
                turnRight();
                while (leftIsBlocked()){
                    move();
                }
                turnLeft();
                move();
            }
        }
        pickBeeper();
    }
    private void comeBack(){
        turnAround();
        move();
        turnRight();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while(frontIsClear()){
            move();
        }
        turnAround();
    }
}
