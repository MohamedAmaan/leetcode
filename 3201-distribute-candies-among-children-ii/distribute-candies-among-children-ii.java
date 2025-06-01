class Solution {
  public long distributeCandies(int n, int limit) {
    int maxCandies = 3 * limit;
    if (n > maxCandies) return 0;

    int l = limit + 1;
    long total = ways(n);
    long subtract1 = ways(n - l);
    long subtract2 = ways(n - 2 * l);
    long subtract3 = ways(n - 3 * l);

    // Inclusion-Exclusion Principle
    return total - 3 * subtract1 + 3 * subtract2 - subtract3;
  }

  private long ways(int n) {
    return n < 0 ? 0 : nCk(n + 2, 2);
  }

  private long nCk(int n, int k) {
    // C(n, k) = n! / (k! * (n-k)!)
    if (k > n) return 0;
    k = Math.min(k, n - k);  // Use symmetry for fewer multiplications
    long res = 1;
    for (int i = 1; i <= k; ++i) {
      res = res * (n - i + 1) / i;
    }
    return res;
  }
}
