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
        println("Student fio is: " + student.fio + ". Student mark is: " + student.mark + ". Student course is: " + student.course);

        StudentsConstructor student2 = new StudentsConstructor("Khurschev", 90, 1);
        println("Student fio is: " + student2.fio + ". Student mark is: " + student2.mark + ". Student course is: " + student2.course);

        StudentsConstructor student3 = new StudentsConstructor();
        println("Student fio is: " + student3.fio + ". Student mark is: " + student3.mark + ". Student course is: " + student3.course);


        StudentFromAnotherDemention student4 = new StudentFromAnotherDemention();
        StudentFromAnotherDemention student5 = new StudentFromAnotherDemention("Oleh Lyashko");
        StudentFromAnotherDemention student6 = new StudentFromAnotherDemention("Trokhym Babych", 100, 4, "FI");
        StudentFromAnotherDemention student7 = new StudentFromAnotherDemention("Vozniuk Yaroslav", 95, 5, "FI", "NaUKMA");


        if(student4.nameOfTheFaculty == "FI"){
            println("Student fio is: " + student4.fio + ". Student mark is: " + student4.mark + ". Student course is: " + student4.course + ". Student Faculty is: " + student4.nameOfTheFaculty + ". Students University is: " + student4.nameOfTheUniversity + ". " + student4.howManyLabsDoesHaveTheStudentOfFIFaculty() + " labs are missing!!");

        }
        else{
            println("Student fio is: " + student4.fio + ". Student mark is: " + student4.mark + ". Student course is: " + student4.course + ". Student Faculty is: " + student4.nameOfTheFaculty + ". Students University is: " + student4.nameOfTheUniversity);

        }
        if(student5.nameOfTheFaculty == "FI"){
            println("Student fio is: " + student5.fio + ". Student mark is: " + student5.mark + ". Student course is: " + student5.course + ". Student Faculty is: " + student5.nameOfTheFaculty + ". Students University is: " + student5.nameOfTheUniversity+ ". " + student5.howManyLabsDoesHaveTheStudentOfFIFaculty() + " labs are missing!!");

        }
        else{
            println("Student fio is: " + student5.fio + ". Student mark is: " + student5.mark + ". Student course is: " + student5.course + ". Student Faculty is: " + student5.nameOfTheFaculty + ". Students University is: " + student5.nameOfTheUniversity);

        }
        if(student6.nameOfTheFaculty == "FI"){
            println("Student fio is: " + student6.fio + ". Student mark is: " + student6.mark + ". Student course is: " + student6.course + ". Student Faculty is: " + student6.nameOfTheFaculty + ". Students University is: " + student6.nameOfTheUniversity+ ". " + student6.howManyLabsDoesHaveTheStudentOfFIFaculty() + " labs are missing!!");

        }
        else{
            println("Student fio is: " + student6.fio + ". Student mark is: " + student6.mark + ". Student course is: " + student6.course + ". Student Faculty is: " + student6.nameOfTheFaculty + ". Students University is: " + student6.nameOfTheUniversity);

        }
        if(student7.nameOfTheFaculty == "FI"){
            println("Student fio is: " + student7.fio + ". Student mark is: " + student7.mark + ". Student course is: " + student7.course + ". Student Faculty is: " + student7.nameOfTheFaculty + ". Students University is: " + student7.nameOfTheUniversity+ ". " + student7.howManyLabsDoesHaveTheStudentOfFIFaculty() + " labs are missing!!");
        }
        else{
            println("Student fio is: " + student7.fio + ". Student mark is: " + student7.mark + ". Student course is: " + student7.course + ". Student Faculty is: " + student7.nameOfTheFaculty + ". Students University is: " + student7.nameOfTheUniversity);
        }

    }
}