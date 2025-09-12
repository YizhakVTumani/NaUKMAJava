import stanford.karel.*;

public class Practice2First extends SuperKarel {

	public void run() {
        turnLeft();
        putBeeper();
        for (int i = 0; i < 4; i++) {
            move();
            putBeeper();
        }
        turnRight();
        for (int i = 0; i < 4; i++) {
            move();
            turnRight();
            move();
            putBeeper();
            turnLeft();
        }
        turnLeft();
        for (int i = 0; i < 4; i++) {
            move();
            putBeeper();
        }
    }
}
