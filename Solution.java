
import java.util.Stack;

public class Solution {

    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        if (head.next != null) {
            stack.push(head.next);
        }
        if (head.child != null) {
            stack.push(head.child);
            head.child = null;
        }

        Node previous = head;
        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.next != null) {
                stack.push(current.next);
            }
            if (current.child != null) {
                stack.push(current.child);
                current.child = null;
            }

            previous.next = current;
            current.prev = previous;
            previous = previous.next;

        }
        return head;
    }
}

class Node {

    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
