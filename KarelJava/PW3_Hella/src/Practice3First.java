import stanford.karel.SuperKarel;

//Author: Hella Nikita

//Необхідно провести Карела через лабіринт. Але завдання ускладнилося, Карел має зібрати усі біпери.
//Карел починає з клітини 1х1 і має закінчити в верхньому правому кутку обличчям на схід.
//
//Світи в яких Карел має вірно виконувати задачу мають відповідати таким умовам:
//
//Карел починає з клітинки 1х1, обличчям на схід
//Стіни розташовані лише горизонтально як показано на малюнку. В горизонтальній стінці є принаймні один прохід, який може бути будь-де, якщо його немає це кінець.
//Стіни розташовані через будь-яку кількість рядків
//Біпери можуть розташовуватися в будь-якому місці
//Карел має закінчити свою роботу в верхньому правому кутку свого світу обличчям на схід, на карті не має залишитися біперів.


public class Practice3First extends SuperKarel {

	public void run() {
        pickUpBeeper();
        while(frontIsBlocked()){
            if(leftIsBlocked()){
                break;
            }
            pickUpBeeper();
            turnLeft();
            move();
            turnRight();
        }
        while(frontIsClear()) {
            seekForBeeper();
            toTheStartOfTheColumn();
            pickUpBeeper();
            columnSurfing();
            if(leftIsClear()){
                newLevelRoam();
                toTheStartOfTheColumn();
            }
        }
        pickUpBeeper();
    }
    private void seekForBeeper(){ // Karel goes through the column and picks up all the beepers
        while(frontIsClear()){
            move();
            pickUpBeeper();
        }
        turnAround();
    }
    private void toTheStartOfTheColumn() { // moves to the start of the column
        while (frontIsClear()) {
            pickUpBeeper();
            move();
        }
        turnAround();
    }
    private void newLevelRoam() { // changing a line to the next
        turnLeft();
        pickUpBeeper();
        move();
        pickUpBeeper();
        turnLeft();
    }
    private void columnSurfing() { //surfing through a column and looking for an exit
        while(leftIsBlocked()) {
            move();
            pickUpBeeper();
            if(frontIsBlocked()) {
                break;
            }
        }
    }
    private void pickUpBeeper(){   // shortage for picking up beeper
        if(beepersPresent()){
            pickBeeper();
        }
    }
}
