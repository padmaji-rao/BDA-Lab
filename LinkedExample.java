import java.util.LinkedList;

class LinkedExample {
    public static void main(String args[]) {
        LinkedList<String> s = new LinkedList<>();
        s.add("A");
        s.add("B");
        s.add("C");
        System.out.println(s);
        String str=s.remove(1);
        System.out.println(str);;
    }
}
