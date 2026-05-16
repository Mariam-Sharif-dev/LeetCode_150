package array;

public class MaximumSubArrayPrbm53 {

    public int maxSubArray(int[] arrs) {
        // initialize first value as mamximum and current maximum
        int max = arrs[0];
        int currentMax = arrs[0];

        for (int i = 1; i < arrs.length; i++) {
            currentMax = Math.max(arrs[i], arrs[i] + currentMax);
            max = Math.max(currentMax, max);
        }
        return max;

    }

    public static void main(String[] args) {
        MaximumSubArrayPrbm53 solver = new MaximumSubArrayPrbm53();

        // Test 1: [-2,1,-3,4,-1,2,1,-5,4] → expected 6 (subarray: [4,-1,2,1])
        int[] arr1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Test 1: " + solver.maxSubArray(arr1)); // 6

        // Test 2: [1] → expected 1
        int[] arr2 = { 1 };
        System.out.println("Test 2: " + solver.maxSubArray(arr2)); // 1

        // Test 3: [5,4,-1,7,8] → expected 23 (entire array)
        int[] arr3 = { 5, 4, -1, 7, 8 };
        System.out.println("Test 3: " + solver.maxSubArray(arr3)); // 23

        // Test 4: all negatives [-3,-1,-2] → expected -1 (least negative)
        int[] arr4 = { -3, -1, -2 };
        System.out.println("Test 4: " + solver.maxSubArray(arr4)); // -1

        // Test 5: all positives [1,2,3,4] → expected 10 (entire array)
        int[] arr5 = { 1, 2, 3, 4 };
        System.out.println("Test 5: " + solver.maxSubArray(arr5)); // 10
    }

}
