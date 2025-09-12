import stanford.karel.*;

public class pr2 extends Karel{

	public void run(){

        move();
        pickBeeper();
        turnLeft();
        move();
        move();
        move();
        move();
        turnAround();
        move();
        move();
        putBeeper();
        turnLeft();
        turnLeft();
        move();
        move();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
        turnLeft();
	}
    public void turnAround(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
