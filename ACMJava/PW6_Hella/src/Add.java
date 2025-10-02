/*
 * Програма призначена для демонстрації цикла While
 * Програма знаходить суму чисел, що вводить користувач
 */


import acm.program.*;

public class Add extends ConsoleProgram{

	private static final int SENTINEL = 0; //число яке означає кінець введення
	
	public void run(){
		
		int total = 0;
		int val = readInt("Введіть число:");
		
		while (val != SENTINEL){
			total += val;
			val = readInt("Введіть число:");
		}
		println("Сума = " + total);
	}
	
}
