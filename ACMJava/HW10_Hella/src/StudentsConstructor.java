import acm.program.ConsoleProgram;

//Author: Hella Nikita
//File: StudentsConstructor.java

//У Вас мають бути різні конструктори класів (обов'язково: порожній; частковий - тільки ПІБ; та  повний - з усіма параметрами)

public class StudentsConstructor extends Student {
    public static int numberOfStudents;

    public String fio;
    public int mark;
    public int course;

    /**
     * empty constructor
     */
    StudentsConstructor(){
        numberOfStudents++;
    }

    /**
     * one only parameter constructor
     * @param fio - Name and Surname strings
     */
    StudentsConstructor(String fio){
        numberOfStudents++;
        this.fio = fio;
    }

    /**
     * A full parameter constructor
     * @param fio - Name and Surname strings
     * @param mark - int of the mark
     * @param course - number of course
     */
    StudentsConstructor(String fio, int mark, int course){
        numberOfStudents++;
        this.fio = fio;
        this.course = course;
        this.mark = mark;
    }
}

