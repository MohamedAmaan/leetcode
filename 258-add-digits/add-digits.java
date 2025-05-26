class Solution {
    public int addDigits(int num) {
        if (num < 10) return num;  // Base case: already a single digit
        return addDigits(sumOfDigits(num));  // Recursive call
    }

    // Helper method to sum digits of a number
    public int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }
}
