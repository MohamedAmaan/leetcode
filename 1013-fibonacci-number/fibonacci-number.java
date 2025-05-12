import java.util.*;

class Solution {
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.print("Give input: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = fib(n);
        System.out.println("Output: " + result);
    }
}
