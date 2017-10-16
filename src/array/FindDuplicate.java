package array;

import java.util.stream.IntStream;

/**
 * <a href="http://www.techiedelight.com/find-duplicate-element-limited-range-array/">Find a duplicate element in a limited range array</a>
 * Given a limited range array of size n where array contains elements between 1 to n-1 with one element repeating, find
 * the duplicate number in it.
 */
public class FindDuplicate {

    /*
     * Hashing
     * boolean array
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */
    public static int hashFD(int[] arr) {
        int len = arr.length;
        boolean[] visited = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            if (visited[arr[i]]) {
                return arr[i];
            }
            visited[arr[i]] = true;
        }

        return -1;
    }

    /*
     * Time Complexity: O(n)
     * Constant Space(Auxiliary Space: O(1))
     */
    public static int constantFD(int[] arr) {
        int len = arr.length;
        int duplicate = -1;

        for (int i = 0; i < len; i++) {
            int absVal = (arr[i] < 0)? -arr[i] : arr[i];

            if (arr[absVal - 1] >= 0) {
                arr[absVal - 1] = -arr[absVal - 1];
            } else {
                duplicate = absVal;
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
            }
        }

        return duplicate;
    }


    /*
     * Using XOR
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static int xorFD(int[] arr) {
        int len = arr.length;

        int XOR = 0;

        for (int i = 0; i < len; i++) {
            XOR ^= arr[i];
        }

        for (int i = 0; i < len; i++) {
            XOR ^= i;
        }

        return XOR;
    }

    /*
     * Sum
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static int sumFD(int[] arr) {
        int len = arr.length;

        int actual_sum = IntStream.of(arr).sum();
        int expected_sum = len * (len - 1) / 2;

        return (actual_sum - expected_sum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 3};

        System.out.println("Duplicate element is " + hashFD(arr) + "(Hash)");

        System.out.println("Duplicate element is " + constantFD(arr) + "(Constant)");

        System.out.println("Duplicate element is " + xorFD(arr) + "(XOR)");

        System.out.println("Duplicate element is " + sumFD(arr) + "(Math Sum)");
    }
}
