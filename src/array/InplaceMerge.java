package array;

/**
 * <a href="http://www.techiedelight.com/inplace-merge-two-sorted-arrays/">Inplace merge two sorted arrays</a>
 * Given teo sorted arrays X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[] by
 * maintaining the sorted order. i.e. fill X[] with first m smallest elements and fill Y[] with remaining elements.
 */

public class InplaceMerge {

    /*
     *
     * Time Complexity: O(mn)
     * Auxiliary Space: O(1)
     */
    public static void merge(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        int i = 0;

        while (i < m) {
            if (X[i] > Y[0]) {
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                int first = Y[0];

                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }
                Y[k-1] = first;
            }
            i++;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] X = {1, 4, 7, 8, 10};
        int[] Y = {2, 3, 9};

        int m = X.length;
        int n = Y.length;

        merge(X, Y);

        System.out.println("X: ");
        printArray(X);
        System.out.println("Y: ");
        printArray(Y);
    }
}
