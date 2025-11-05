import acm.program.*;
import acm.util.RandomGenerator;

import java.util.Random;

//Author: Hella Nikita
//File: StudentsFromAnotherDemention.java

//напишіть розширення (extends) попереднього класу студенту (наприклад студентів різних факультетів, або навіть університетів)
//визначіть особливі методи притаманні новим класам студентів
//напишіть клас тестувальник який створить цих студентів, викличе їх методи і виведе на екран результати роботи



public class StudentFromAnotherDemention extends StudentsConstructor{

    public String nameOfTheFaculty;
    public String nameOfTheUniversity;
    RandomGenerator random = new RandomGenerator();

    /**
     * empty const
     */
    StudentFromAnotherDemention(){
        numberOfStudents++;
    }

    /**
     * one only parameter constructor
     * @param fio - Name and Surname strings
     */
    StudentFromAnotherDemention(String fio){
        numberOfStudents++;
        this.fio = fio;
    }

    /**
     * multiple param const
     * @param fio -  Name and Surname strings
     * @param mark - int of the mark
     * @param course - number of course
     * @param nameOfTheFaculty - name of the faculty
     */
    StudentFromAnotherDemention(String fio, int mark, int course, String nameOfTheFaculty){
        numberOfStudents++;
        this.fio = fio;
        this.course = course;
        this.mark = mark;
        this.nameOfTheFaculty = nameOfTheFaculty;
    }

    /**
     * A full parameter constructor
     * @param fio -  Name and Surname strings
     * @param mark - int of the mark
     * @param course - number of course
     * @param nameOfTheFaculty - name of the faculty
     * @param nameOfTheUniversity - name of the university where the student studies
     */
    StudentFromAnotherDemention(String fio, int mark, int course, String nameOfTheFaculty, String nameOfTheUniversity){
        numberOfStudents++;
        this.fio = fio;
        this.course = course;
        this.mark = mark;
        this.nameOfTheFaculty = nameOfTheFaculty;
        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    public int howManyLabsDoesHaveTheStudentOfFIFaculty(){ // method that generate random number of the labs that student is missing
        return random.nextInt(0, 10);
    }
}
