import java.util.LinkedList;

class Main1 {
    public static void main(String[] args) {
        LinkedList<String> languages = new LinkedList<>();
        
        // add elements in LinkedList
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Kotlin");
        languages.add("1");
        
        System.out.println("LinkedList: " + languages);
        
        // remove elements from index 1
        String str = languages.remove(1);
        
        System.out.println("Removed Element: " + str);
        System.out.println("Updated LinkedList: " + languages);
    }
}
