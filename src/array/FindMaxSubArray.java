package array;

/**
 * <a href="http://www.techiedelight.com/find-largest-sub-array-formed-by-consecutive-integers/">Find largest sub-array formed by consecutive integers</a>
 * Given an array of integers, find largest sub-array formed by consecutive（连续） integers. The sub-array should
 * contain all distinct values.
 */

public class FindMaxSubArray {
    /*
     * Time Complexity: O(n^3)
     * Auxiliary Space: O(n)
     */

    protected static boolean isConsecutive(int[] arr, int i, int j,
                                           int min, int max) {
        if (max - min != j - i) {
            return false;
        }

        boolean visited[] = new boolean[j - i + 1];

        for (int k = i; k <= j; k++) {
            if (visited[arr[k] - min])
                return false;

            visited[arr[k] - min] = true;
        }

        return true;
    }

    public static void findMaxSubArray(int[] arr) {
        int len = 1;
        int start = 0;
        int end = 0;

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_val = arr[i];
            int max_val = arr[i];

            for (int j = i + 1; j < n; j++) {
                min_val = Math.min(min_val, arr[j]);
                max_val = Math.max(max_val, arr[j]);

                if (isConsecutive(arr, i, j, min_val, max_val)) {
                    if (len < max_val - min_val + 1) {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        System.out.println("The largest sub-array is [" + start + ", " + end + "]");
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 4, 3, 1, 0};

        int[] A = {1, -2, 3, 4, -5, 6, -7};
        findMaxSubArray(arr);
        findMaxSubArray(A);
    }
}
