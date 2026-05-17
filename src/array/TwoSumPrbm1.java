package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumPrbm1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complmtnIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complmntKey = target - nums[i];
            if (complmtnIndexMap.containsKey(complmntKey)) {

                return new int[] { complmtnIndexMap.get(complmntKey), i };
            }
            complmtnIndexMap.put(nums[i], i);
        }

        return new int[]{}; 

    }

    public static void main(String[] args) {
        TwoSumPrbm1 solver = new TwoSumPrbm1();

        // Test 1: [2,7,11,15] target=9 → expected [0,1]
        int[] arr1 = { 2, 7, 11, 15 };
        System.out.println("Test 1: " + Arrays.toString(solver.twoSum(arr1, 9))); // [0, 1]

        // Test 2: [3,2,4] target=6 → expected [1,2]
        int[] arr2 = { 3, 2, 4 };
        System.out.println("Test 2: " + Arrays.toString(solver.twoSum(arr2, 6))); // [1, 2]

        // Test 3: [3,3] target=6 → expected [0,1]
        int[] arr3 = { 3, 3 };
        System.out.println("Test 3: " + Arrays.toString(solver.twoSum(arr3, 6))); // [0, 1]

        // Test 4: no solution [1,2,3] target=10 → expected []
        int[] arr4 = { 1, 2, 3 };
        System.out.println("Test 4: " + Arrays.toString(solver.twoSum(arr4, 10))); // []

        // Test 5: negative numbers [-1,-2,-3,-4] target=-6 → expected [1,3]
        int[] arr5 = { -1, -2, -3, -4 };
        System.out.println("Test 5: " + Arrays.toString(solver.twoSum(arr5, -6))); // [1, 3]
    }

}
