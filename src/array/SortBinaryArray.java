package array;

/**
 * <a href="http://www.techiedelight.com/sort-binary-array-linear-time/">Sort Binary Array in Linear Time</a>
 * Given an binary array, sort it in linear time and constant space. Output should print contain
 * all zeroes followed by all ones.
 */

public class SortBinaryArray {
    public static void Sort(int[] arr, int n) {
        int zeros = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        int k = 0;
        while (zeros-- != 0) {
            arr[k++] = 0;
        }
        while (k < n) {
            arr[k++] = 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 1, 0, 1, 0, 0};
        int n = arr.length;

        Sort(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
