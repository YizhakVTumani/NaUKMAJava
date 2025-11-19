import acm.graphics.*;
import acm.program.*;

import java.awt.*;
import java.util.Random;
import java.util.random.*;

//Author: Hella Nikita
//File: HelloProgram.java

// Написати программу, що робить перевірку, чи є значення символьної змінної, що введена з клавіатури (повертаються одразу всі три результати) :
//
//цифрою від '0' до '9';
//малою латинською літерою;
//латинською літерою (великою чи малою)
//2. У розкладі рейсів літаків дні тижня позначаються номерами від 1 до 7. Припустимо, що в програмі дні тижня подаються enum типом Weekd. Написати програму, що у відповідь на введення номера дня виводить текстове подання дня тижня.
//
//3. За понеділком іде вівторок тощо, а за неділею – понеділок. Написати функцію обчислення за днем тижня (типу Weekd) наступного за ним дня.
//
//4. Написати "найпростіший калькулятор", що отримує на вхід 2 числа і операцію над ними після чого повертає результат обчислень.
//
//5. Написати процедуру обчислення за цілим N>3 таких натуральних A і B, що 5A-2B=N, причому A+B мінімально.

public class HelloProgram extends ConsoleProgram {

    public void run(){
        do {
            String str = readLine("Please enter your char: ");
            while (str.length() != 1) {
                str = readLine("Please enter your char: ");
            }
            char ch = str.charAt(0);

            ifTheWordIsANumber(ch);
            ifTheWordIsALetter(ch);
            ifTheWordIsALilLetter(ch);
        }while(readInt("if you want to contionue press 1 ") != 1); // Написати программу, що робить перевірку, чи є значення символьної змінної

        do {
            enum Weekday {
                Monday,
                Tuesday,
                Wednesday,
                Thursday,
                Friday,
                Saturday,
                Sunday,
            }
            int i = readInt("Please enter the day of the week: ");
            while(i < 1 || i > 7) {
                i = readInt("Please enter the day of the week: ");
            }
            println(Weekday.values()[i - 1]);
        }while(readInt("if you want to contionue press 1 ") != 1); //У розкладі рейсів літаків дні тижня позначаються номерами від 1 до 7

        do {
            enum Weekday {
                Monday,
                Tuesday,
                Wednesday,
                Thursday,
                Friday,
                Saturday,
                Sunday,
            }
            int i = readInt("Please enter the day of the week: ");
            while(i < 1) {
                i = readInt("Please enter the day of the week: ");
            }
            if (i >= 7){
                i %= 7;
            }
            println(Weekday.values()[i]);
        }while(readInt("if you want to contionue press 1 ") != 1);// За понеділком іде вівторок тощо

        do {
            int a = readInt("Please enter the first number: ");
            int b = readInt("Please enter the second number: ");
            char c = readLine("Please enter the operator: ").charAt(0);
            while(c != '+' && c != '-' && c != '*' && c != '/') {
                c = readLine("Please enter the operator: ").charAt(0);
            }
            int res = 0;
            if (c == '+'){
                 res = a + b;
            }
            else if (c == '-'){
                 res = a - b;
            }
            else if (c == '*'){
                 res = a * b;
            }
            else if (c == '/'){
                 res = a / b;
            }
            println(a + " " + c + " " + b + " = " + res);
        }while(readInt("if you want to contionue press 1 ") != 1); //Написати "найпростіший калькулятор"

        do {
            int n = readInt("Please enter the N: ");
            while(n <= 3){
                n = readInt("Please enter the N: ");
            }
            int res;
            int time = 999999999;
            int a = 0;
            int b = 0;
            for(;5 * a - 2 * b != n; b++){
                for (; 5 * a - 2 * b < n; a++){
                }
                if(time > a+b && 5 * a - 2 * b == n){
                    time = a+b;
                }
            }
            if(time > a+b && 5 * a - 2 * b == n){
                time = a+b;
            }
            println("result a + b = " + time);
            println(a + " : a " + b + " : b = " + time);
        }while(readInt("if you want to contionue press 1 ") != 1); // Написати процедуру обчислення за цілим N>3
    }


    public void ifTheWordIsANumber(char ch){
        if (ch >= '0' && ch <= '9'){
            println("It is a number");
        }
    }
    public void ifTheWordIsALetter(char ch){
        if (ch >= 'A' && ch <= 'Z'){
            println("It is a letter");
        }
    }
    public void ifTheWordIsALilLetter(char ch){
        if (ch >= 'a' && ch <= 'z'){
            println("It is a lil letter");
        }
    }

}