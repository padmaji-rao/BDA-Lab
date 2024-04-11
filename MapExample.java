import java.util.LinkedHashMap;
public class MapExample {
    public static void main(String[] args)
    {
        // Creating an empty Linked Hash Map
        LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
        // Adding data to Linked Hash Map in key-value pair
        students.put(101, "Aaliyah");
        students.put(102, "Taylor");
        students.put(103, "Zayn");
        students.put(104, "Sabrina");
        students.put(105, "Paul");
        // Showing size and data of the Linked Hash Map
        System.out.println("The size of the Linked Hash Map is:- "+ students.size());
        System.out.println(students);
        // Checking whether a certaint key is available or not
        if (students.containsKey(105)) {
            String name = students.get(105);
            System.out.println("The name of the student having Id 105 is:- " + name);
        }
    }
}