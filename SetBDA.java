import java.util.*; 

public class SetBDA { 

    public static void main(String[] args)  { 

        // Set demo with HashSet

        Set<String> Colors_Set = new HashSet<String>(); 
        Colors_Set.add("Red"); 
        Colors_Set.add("Green"); 
        Colors_Set.add("Blue"); 
        Colors_Set.add("Cyan"); 
        Colors_Set.add("Magenta"); 
        //print set contents
        System.out.println("Set contents :"+Colors_Set); 
      
   
        // Set demo with TreeSet 
        Set<String> tree_Set = new TreeSet<String>(Colors_Set); 
        System.out.println("Sorted Set after converting to Tree Set :"+tree_Set); 
        
    } 

} 