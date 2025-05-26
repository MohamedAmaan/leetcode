class Solution {
    public double myPow(double x, int n) {
        return pow(x, (long) n);  // Convert n to long to handle overflow
    }

    public static double pow(double x, long n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / pow(x, -n);

        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
