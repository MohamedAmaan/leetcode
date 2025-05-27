class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) return true;        // Found perfect square
            else if (square < num) left = mid + 1; // Search right half
            else right = mid - 1;                  // Search left half
        }

        return false; // Not a perfect square
    }
}
