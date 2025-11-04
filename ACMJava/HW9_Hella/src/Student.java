import acm.program.*;

//Author: Hella Nikita
//File: Student.java

//Написати клас, який описує студента НаУКМА використовуючи наступні елементи:
//
//змінні екземпляра
//змінні класу
//public і private методи
//javadoc
//toString
//Та клас який використовує клас Student.

public class Student extends ConsoleProgram {


    public void run(){
        println("Welcome to the Student Program");

        StudentsConstructor student = new StudentsConstructor("Nikita Serhiyovych" );
//        student.setFio("Hella Nikita");
        println("Student fio is: " + student.fio + ". Student mark is: " + student.mark + ". Student course is: " + student.course);

        StudentsConstructor student2 = new StudentsConstructor("Khurschev", 90, 1);
//        student2.setFio("Oleh Lyashko");
//        student2.setMark(90);
//        student2.setCourse(1);
        println("Student fio is: " + student2.fio + ". Student mark is: " + student2.mark + ". Student course is: " + student2.course);

        StudentsConstructor student3 = new StudentsConstructor();
        println("Student fio is: " + student3.fio + ". Student mark is: " + student3.mark + ". Student course is: " + student3.course);
    }


}