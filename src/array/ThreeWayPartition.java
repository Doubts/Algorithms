package array;

/**
 * <a href="http://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/">Sort an array containing 0's,
 * 1's and 2's(Dutch national flag problem荷兰国旗问题)</a>
 * Given an array containing only 0's, 1's and 2's, sort the array in linear time and using constant space.
 */

public class ThreeWayPartition {

    /*
     * in sigle traversal using an alternative linear-time partition routine can be used that separates the values into three groups:
     *   * values less than the pivot
     *   * values equal to the pivot
     *   * values greater than the pivot
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static void threeWayPartition(int[] arr, int end) {
        int start = 0, mid = 0;
        int pivot = 1;
        int temp;

        while (mid <= end) {
            if (arr[mid] < pivot) {
                temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;

                start++;
                mid++;
            } else if (arr[mid] > pivot) {
                temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;

                end--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0};
        int len = arr.length;

        threeWayPartition(arr, len - 1);

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
