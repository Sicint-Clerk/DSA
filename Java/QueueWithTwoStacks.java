import java.util.Stack;

public class QueueWithTwoStacks {
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();

    public void enqueue(int item){
        s1.push(item);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return s2.pop();
    }

    private void moveStack1ToStack2() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return s2.peek();
    }

    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
