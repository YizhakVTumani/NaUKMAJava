package practice8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass {
    @Test
    void test(){
        Student s1 = new Student("123", "sad", "sad");
        StudentRegistry.addStudent(s1.getId(), s1.getName(), s1.getEmail());
        assertEquals(null, StudentRegistry.findById("123"));
    }
    @Test
    void test2(){
        Student s1 = new Student("123", "sad", "sad");
        StudentRegistry.addStudent(s1.getId(), s1.getName(), s1.getEmail());
        assertEquals(null, StudentRegistry.containsEmail("sad"));



    }
}
