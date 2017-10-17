package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://www.techiedelight.com/find-maximum-length-sub-array-equal-number-0s-1s/">Find maximum length sub-array having equal number
 * of 0's and 1's</a>
 * Given an binary array containing 0 and 1, find maximum length sub-array having equal number of 0's and 1's
 */

public class MaxLengthSubArrayEqualNumber {

    /*
     * Map Solution
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */

    public static void maxLengthSubArrayEqualNumber(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int len = 0;

        int ending_index = -1;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (arr[i] == 0)? -1 : 1;
            if (map.containsKey(sum)) {
                if (len < i - map.get(sum)) {
                    len = i - map.get(sum);
                    ending_index = i;
                }
            } else {
                map.put(sum, i);
            }
        }

        if (ending_index != -1) {
            System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
        } else {
            System.out.println("No sub-array exists");
        }
    }


    public static void main(String[] args) {
        int arr[]  = {0, 0, 1, 0, 1, 0, 0, 1, 0};

        maxLengthSubArrayEqualNumber(arr);
    }
}
