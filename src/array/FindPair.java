package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://www.techiedelight.com/find-pair-with-given-sum-array/">Find Pair with given Sum in the Array</a>
 * Given an unsorted array of integers, find a pair with given sum in it.
 */

public class FindPair {

    /*
     * Naive Approach
     * Naive solution would be to consider every pair in given array and return if desired sum is found.
     *
     * Time complexity: O(n^2)
     * Auxiliary Space: O(1)
     */
    public static void naiveFP(int[] arr, int sum) {
        int len = arr.length;
        boolean fp = false;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] + arr[j] == sum) {
                    fp = true;
                    System.out.println("Pair found at index " + i + " and " + j);
                }
            }
        }

        if (!fp) {
            System.out.println("Pair not found! Naive");
        }
    }



    /*
     * O(nlogn) solution using Sorting
     *
     * Time Complexity: O(nlogn)
     * Auxiliary Space: O(1)
     */
    public static void sortFP(int[] arr, int sum) {
        int len = arr.length;
        Arrays.sort(arr);
        int start = 0;
        int end = len - 1;
        boolean fp = false;
        while (start != end) {
            if (arr[start] + arr[end] == sum) {
                fp = true;
                System.out.println("Pair found");
                start++;
                end--;
            } else if (arr[start] + arr[end] > sum) {
                end--;
            } else {
                start++;
            }
        }

        if (!fp) {
            System.out.println("Pair not found! Sorting");
        }
    }


    /*
     * O(n) solution using Hashing
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(n)
     */
    public static void hashFP(int[] arr, int sum) {
        int len = arr.length;
        boolean fp = false;
        Map<Integer, Integer> map = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            if (map.containsKey(sum - arr[i])) {
                System.out.println("Pair found at index " + map.get(sum - arr[i]) + " and " + i);
                fp = true;
            }

            map.put(arr[i], i);
        }

        if (!fp) {
            System.out.println("Pair nor found! Hash");
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int sum = 10;

        long startTime = System.currentTimeMillis();
        naiveFP(arr, sum);
        long endTime = System.currentTimeMillis();
        long totalTime  = (endTime - startTime);
        System.out.println("遍历寻找时间" + totalTime);

        startTime = System.currentTimeMillis();
        sortFP(arr, sum);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("排序寻找时间" + totalTime);

        startTime = System.currentTimeMillis();
        hashFP(arr, sum);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("Hash寻找时间" + totalTime);
    }

}
