package array;

public class SingleNonRepeatingElementInArrayPrbm {

    public int singleNonRepeatingNumber(int[] nums) {
        // variable to store
        int singleNumber = nums[0];

        for (int i = 1; i < nums.length; i++) {

            singleNumber = singleNumber ^ nums[i];
        }

        return singleNumber;

    }

    public static void main(String[] args) {
        SingleNonRepeatingElementInArrayPrbm solver = new SingleNonRepeatingElementInArrayPrbm();

        // Test 1: [2,2,1] → expected 1
        int[] arr1 = { 2, 2, 1 };
        System.out.println("Test 1: " + solver.singleNonRepeatingNumber(arr1)); // 1

        // Test 2: [4,1,2,1,2] → expected 4
        int[] arr2 = { 4, 1, 2, 1, 2 };
        System.out.println("Test 2: " + solver.singleNonRepeatingNumber(arr2)); // 4

        // Test 3: [0,1,1] → expected 0 (0 is the single element)
        int[] arr3 = { 0, 1, 1 };
        System.out.println("Test 3: " + solver.singleNonRepeatingNumber(arr3)); // 0

        // Test 4: [1,1,2,2,3,3] → no single element
        int[] arr4 = { 1, 1, 2, 2, 3, 3 };
        System.out.println("Test 4: " + solver.singleNonRepeatingNumber(arr4)); // No single non-repeating element
                                                                                // exists!

        // Test 5: [-1,-1,2] → expected 2
        int[] arr5 = { -1, -1, 2 };
        System.out.println("Test 5: " + solver.singleNonRepeatingNumber(arr5)); // 2
    }

}
