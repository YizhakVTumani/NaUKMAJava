package practice8;

import java.util.*;

//public class ListClass {
//    public static <T> T firstOrNull(List<T> list){
//        if(list.get(0) == null){
//            return null;
//        }
//        return list.get(0);
//    }
//    public <T> int sum(List<? extends Number> list){
//        int item = (int) list.get(0);
//        int item1 = (int) list.get(1);
//        return item + item1;
//    }
//
//    public void addDefaultIds(List<? super Integer> list){
//        list.add(0);
//        list.add(1);
//        list.add(2);
//    }
//
//}

//static void main() {
//    List list = new ArrayList();
//    List<String> list = new ArrayList<String>();
//    list.add(42);
//    list.add("Alice");
//
//    for (Object item : list)
//    {
//        System.out.println(item);
//    }
//    ListClass.firstOrNull(list);

//}
class Student{
    public String name;
    public String mail;
    public String id;

    Student(String id, String name, String mail){
        this.name = name;
        this.mail = mail;
        this.id = id;
    }
    public String getEmail(){
        return mail;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Name " + this.name + "Email = " + this.mail;
    }

}
class StudentRegistry{
    void main() {
        addStudent("123", "Bob", "Bob.mail");
        addStudent("23", "Steve", "Steve.mail");
        for (Object o : st){
            System.out.println(o);
        }
        for (Object o : str){
            System.out.println(o);
        }
        removeById("23");
        for (Object o : st){
            System.out.println(o);
        }
        for (Object o : str){
            System.out.println(o);
        }
    }

    static List <Student> st = new ArrayList<Student>();
    static Set<String> str = new HashSet<String>();
    static Map<String, Student> dict = new HashMap<String, Student>();



    public static void addStudent(String id, String name, String mail){
        mail = containsEmail(mail);
        id = findById(id);
        if(id == null || mail == null){
            System.out.println("Mail or id is already taken!");
            return;
        }
        Student s1 = new Student(id, name, mail);
        st.add(s1);
        str.add(mail);
        dict.put(id, s1);
    }
    public static String findById(String id){
        for (String s : dict.keySet()){
            if(s.equals(id)){
                return null;
            }
        }
        return id;
    }
    public static String containsEmail(String mail){
        for (String s : str){
            if(mail.equals(s)){
                return null;
            }
        }
        return mail;
    }
    public void removeById(String id){
        Student s = dict.get(id);
        String mail = s.getEmail();
        st.remove(s);
        str.remove(mail);
        dict.remove(id, s);
    }

}

