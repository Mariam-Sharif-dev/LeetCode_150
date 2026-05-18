package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stock Span Problem (Leetcode 901)
 */
public class StockSpanPrbm901 {

    private int[]  calculateSpan (int[] prices)
    {

        int[]  spanArr = new int[prices.length];

        // for the first element at first index it will be alwys one
        spanArr[0] =1;

        Stack<Integer> indices  = new Stack<Integer>();
        indices.push(0);

        for(int i=1;i<prices.length;i++)
        {
            //if current price is greathe than whatver is in the stack
            while(!indices.isEmpty()
                &&prices[indices.peek()]<=prices[i])
            {

                indices.pop();
            }
            if(indices.isEmpty())
            {
                spanArr[i] =i+1;
            }
            else
            {
                spanArr[i]  = i-indices.peek();
            }
            indices.push(i);
        }

        return spanArr;
    }

    public static void main(String[] args) {
        StockSpanPrbm901 solver = new StockSpanPrbm901();

        // Test 1: [100,80,60,70,60,75,85] → expected [1,1,1,2,1,4,6]
        int[] prices1 = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println("Test 1: " + Arrays.toString(solver.calculateSpan(prices1)));

        // Test 2: [10,4,5,90,120,80] → expected [1,1,2,4,5,1]
        int[] prices2 = { 10, 4, 5, 90, 120, 80 };
        System.out.println("Test 2: " + Arrays.toString(solver.calculateSpan(prices2)));

        // Test 3: all same [5,5,5,5] → expected [1,2,3,4]
        int[] prices3 = { 5, 5, 5, 5 };
        System.out.println("Test 3: " + Arrays.toString(solver.calculateSpan(prices3)));

        // Test 4: increasing [1,2,3,4] → expected [1,2,3,4]
        int[] prices4 = { 1, 2, 3, 4 };
        System.out.println("Test 4: " + Arrays.toString(solver.calculateSpan(prices4)));

        // Test 5: decreasing [4,3,2,1] → expected [1,1,1,1]
        int[] prices5 = { 4, 3, 2, 1 };
        System.out.println("Test 5: " + Arrays.toString(solver.calculateSpan(prices5)));
    }

}
