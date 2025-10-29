import acm.program.*;

//Author: Hella Nikita
//File: HelloProgram.java


public class Student extends ConsoleProgram {
 public static int numberOfStudents;
 private String fio;
 private int mark;
 private int course;

    public void run(){
        println("Welcome to the Student Program");

        StudentsConstructor student = new StudentsConstructor(fio);
        student.setFio("Hella Nikita");
        println("Student fio is: " + student.getFio() + ". Student mark is: " + student.getMark() + ". Student course is: " + student.getCourse());

        StudentsConstructor student2 = new StudentsConstructor(fio, mark, course);
        student2.setFio("Sophia Karachentseva");
        student2.setMark(90);
        student2.setCourse(1);
        println("Student fio is: " + student2.getFio() + ". Student mark is: " + student2.getMark() + ". Student course is: " + student2.getCourse());

        StudentsConstructor student3 = new StudentsConstructor();
        println("Student fio is: " + student3.getFio() + ". Student mark is: " + student3.getMark() + ". Student course is: " + student3.getCourse());
    }

    public int getMark(){
        return mark;
    }
    public int getCourse(){
        return course;
    }
    public void setMark(int mark){
        this.mark = mark;
    }
    public void setCourse(int course){
        this.course = course;
    }
    public String getFio(){
        return fio;
    }
    public void setFio(String fio){
        this.fio = fio;
    }
}