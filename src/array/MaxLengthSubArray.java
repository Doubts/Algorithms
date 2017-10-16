package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://www.techiedelight.com/find-maximum-length-sub-array-having-given-sum/">Find maximum length sub-array having given sum</a>
 * Given an array of integers, find maximum length sub-array having given sum.
 */

public class MaxLengthSubArray {

    /*
     * Naive Solution
     * Time Complexity: O(n^2)
     * Auxiliary Space: O(1)
     */
    public static void naiveMLSA(int[] arr, int S) {
        int n = arr.length;

        int len = 0;

        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if(sum == S) {
                    if (len < j - i + 1) {
                        len = j - i + 1;
                        ending_index = j;
                    }
                }
            }
        }

        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }


    /*
     * use map to solve this problem in linear time.
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */
    public static void mapMLSA(int[] arr, int S) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        int len = 0;

        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum -S) && len < i - map.get(sum -S)) {
                len = i - map.get(sum - S);
                ending_index = i;
            }
        }

        System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, -5, 5, 3, 5, 3, -2, 0};
        int sum = 8;

        naiveMLSA(arr, sum);

        mapMLSA(arr, sum);
    }

}
