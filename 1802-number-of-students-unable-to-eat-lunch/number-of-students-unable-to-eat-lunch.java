import java.util.*;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int s : students) {
            queue.offer(s);  // sab students queue mein add
        }
        int index = 0;  // sandwich pointer
        int attempts = 0;  // consecutive failed attempts

        while (!queue.isEmpty()) {
            if (queue.peek() == sandwiches[index]) {
                queue.poll();  // student sandwich le leta hai
                index++;       // next sandwich
                attempts = 0;  // reset attempts
            } else {
                queue.offer(queue.poll());  // student end mein chala jaata hai
                attempts++;
            }
            // Agar sab students ek round mein reject kar rahe hain
            if (attempts == queue.size()) {
                break;
            }
        }
        return queue.size();  // jitne students bache, wo nahi kha paaye
    }
}