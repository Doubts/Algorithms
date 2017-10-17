package array;

/**
 * <a href="http://www.techiedelight.com/merge-two-arrays-satisfying-given-constraints/">Merge two array by satisfying given constraints</a>
 * Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells(空置元素),
 * merge elements of Y[] in their correct positon in array X[] i.e. merge (X, Y) keeping the sorted order.
 */

public class ArrayMergeSatisfyingGivenConstraints {

    /*
     * initially move non-empty elements of X[] in the beginning of X[] and then merge X[] with Y[] starting from end.
     *
     * Time Complexity: O(m + n)
     * Auxiliary Space: O(1)
     */
    public static void merge(int[] X, int[] Y, int m, int n) {
        int k = m + n + 1;

        while (m >= 0 && n >= 0) {
            if (X[m] > Y[n]) {
                X[k--] = X[m--];
            } else {
                X[k--] = Y[n--];
            }
        }

        while (n >= 0) {
            X[k--] = Y[n--];
        }
    }
    public static void rearrange(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        int k = 0;
        for (int i = 0; i < m; i++) {
            if (X[i] != 0) {
                X[k++] = X[i];
            }
        }
        merge(X, Y, k-1, n-1);
    }

    public static void main(String[] args) {
        int[] X = {0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] Y = {1, 8, 9, 10, 15};

        rearrange(X, Y);

        for (int i = 0; i < X.length; i++) {
            System.out.print(X[i] + " ");
        }
    }
}
