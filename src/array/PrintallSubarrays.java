package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://www.techiedelight.com/find-sub-array-with-0-sum/">Print all sub-array with 0 sum</a>
 * Given an array of integers, print all subarrays having 0 sum.
 */

public class PrintallSubarrays {

    /*
     * Naive Solution
     * consider all sub-arrays and find its sum.
     *
     * Time Comlexity: O(n^3) (n^2 sub-arrays and take O(n) time to find sum of its elements)
     *      can be optimized to run in O(n^2) time by calculating syb-array sum in constant time.
     * Auxiliary Space: O(n)
     */
    public static void naivePASA(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int sum = 0;

            for (int j = i; j < len; j++) {
                sum += arr[j];

                if (sum == 0) {
                    System.out.println("Subarray [" + i + ".." + j + "]");
                }
            }
        }
    }



    /*
     * Using multimap to print all subarrays
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */
    protected static void insert(Map<Integer, ArrayList> hashMap,
                                 Integer key, Integer value) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);

            hashMap.put(key, list);
        }
    }
    public static void multimapPASA(int[] arr) {
        int len = arr.length;
        Map<Integer, ArrayList> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (hashMap.containsKey(sum)) {
                ArrayList<Integer> list = hashMap.get(sum);
                for (Integer value : list) {
                    System.out.println("Subarray [" + (value + 1) + ".." + i + "]");
                }
            }
            System.out.println("HashMap: " + hashMap.toString());
            insert(hashMap, sum, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 4, -7, 3, 1, 3, 1, -4, -2, -2};

        long startTime = System.currentTimeMillis();
        naivePASA(arr);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("遍历子数组求和： " + totalTime);

        startTime = System.currentTimeMillis();
        multimapPASA(arr);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("多映射子数组求和： " + totalTime);


    }
}
