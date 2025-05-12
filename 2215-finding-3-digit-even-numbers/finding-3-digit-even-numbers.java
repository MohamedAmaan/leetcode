import java.util.*;

public class Solution {
    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> resultSet = new TreeSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int d1 = digits[i];
                    int d2 = digits[j];
                    int d3 = digits[k];

                    if (d1 != 0 && d3 % 2 == 0) {
                        int num = d1 * 100 + d2 * 10 + d3;
                        resultSet.add(num); 
                    }
                }
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] digits = {2, 1, 3, 0};
        int[] result = findEvenNumbers(digits);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
