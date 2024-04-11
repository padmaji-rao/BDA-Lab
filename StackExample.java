import java.util.Stack;
public class StackExample {
    public static void main(String[] args){
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        System.out.println(s);
        s.pop();
        System.out.println(s);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println("Peek element :"+s.peek());
        int pos=s.search(4);
        System.out.println(pos);
    }

}
