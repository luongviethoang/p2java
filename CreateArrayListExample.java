package java1;
import java.util.ArrayList;
import  java.util.List;
public class CreateArrayListExample {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("lions");
        animals.add("Tiger");
        animals.add("cat");
        animals.add("Dog");

        System.out.println(animals);

        animals.add(2,"Elephant ");

        System.out.println(animals);
    }
}
