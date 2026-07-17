import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        // Move all elements except the last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        // Last element in q1 is the "top" of the stack
        int top = q1.remove();

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Get the top element
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int top = q1.peek(); // peek instead of remove
        q2.add(q1.remove()); // move it to q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Returns whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}
