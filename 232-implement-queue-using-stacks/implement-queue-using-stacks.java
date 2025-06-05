import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;  // for pushing new elements
    Stack<Integer> stack2;  // for popping and peeking

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Step 1: Push element to the queue
    public void push(int x) {
        stack1.push(x);  // Simply push to stack1
    }

    // Step 2: Pop element from front of queue
    public int pop() {
        shiftStacks();  // Shift only if stack2 is empty
        return stack2.pop();  // Now top of stack2 is the front of queue
    }

    // Step 3: Peek the front element of queue
    public int peek() {
        shiftStacks();
        return stack2.peek();
    }

    // Step 4: Check if queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Helper method: Transfer elements from stack1 to stack2 if stack2 is empty
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // Reverse the order
            }
        }
    }
}
