import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // Set demo with HashSet
        Set<String> colorsSet = new HashSet<String>();
        colorsSet.add("Red");
        colorsSet.add("Green");
        colorsSet.add("Blue");
        colorsSet.add("Cyan");
        colorsSet.add("Magenta");

        // Print set contents
        System.out.print("Set contents: ");
        System.out.println(colorsSet);

        // Set demo with TreeSet
        System.out.print("\nSorted Set after converting to TreeSet: ");
        Set<String> treeSet = new TreeSet<String>(colorsSet);
        System.out.println(treeSet);
    }
}
