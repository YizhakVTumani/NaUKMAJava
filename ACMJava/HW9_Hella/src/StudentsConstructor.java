import acm.program.ConsoleProgram;

//Author: Hella Nikita
//File: HelloProgram.java


public class StudentsConstructor extends Student {

    StudentsConstructor(){
        numberOfStudents++;
    }
    StudentsConstructor(String fio){
        numberOfStudents++;
    }
    StudentsConstructor(String fio, int mark, int course){
        numberOfStudents++;
    }
}