import java.util.*;
public class SetExample {
    public static void main(String[] args) {
        // Set demo with HashSet
        Set<String> Colors_Set = new HashSet<>();
        Colors_Set.add("Red");
        Colors_Set.add("Green");
        Colors_Set.add("Blue");
        Colors_Set.add("Cyan");
        Colors_Set.add("Magenta");
        //print set contents
        System.out.print("Set contents:");
        System.out.println(Colors_Set);

        // Set demo with TreeSet
        System.out.print("\nSorted Set after converting to TreeSet:");
        Set<String> tree_Set = new TreeSet<String>(Colors_Set);
        System.out.println(tree_Set);
 }
}