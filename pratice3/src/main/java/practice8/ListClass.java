import java.util.ArrayList;
import java.util.List;

public class ListClass {

}

static void main() {
//    List list = new ArrayList();
    List<String> list = new ArrayList<String>();
    list.add(42);
    list.add("Alice");

    for (Object item : list)
    {
        System.out.println(item);
    }

//    private void firstOrNull(List<T>){
//
//    }
}
