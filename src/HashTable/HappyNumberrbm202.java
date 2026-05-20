package HashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberrbm202 {

    public boolean isHappyNumber(int n) {
        Set<Integer> usedNumber = new HashSet<>();

        int sumInt = 0;
        double sumDbl = 0;
        double remainder = 0.0;
        double quotient = 0.0;
        while (n != 0) {
            remainder = n % 10;
            quotient = n / 10;
            double num1 = Math.pow(remainder, 2.0);
            double num2 = Math.pow(quotient, 2.0);
            sumDbl = num1 + num2;
            sumInt = (int) (sumDbl);
            if (sumInt == 1)// if sum equals 1 then its a happy number
            {
                return true;
            }

            n = sumInt;

            // if used number contains this number already then return false otherwise add
            // the number in the hashset
            if (usedNumber.contains(n)) {
                return false;
            } else {
                usedNumber.add(n);
            }

        }
        return true;

    }

    public static void main(String[] args) {
        HappyNumberrbm202 solver = new HappyNumberrbm202();

        System.out.println("Test 1 (19): " + solver.isHappyNumber(19));  // true
        System.out.println("Test 2 (2):  " + solver.isHappyNumber(2));   // false
        System.out.println("Test 3 (1):  " + solver.isHappyNumber(1));   // true
        System.out.println("Test 4 (7):  " + solver.isHappyNumber(7));   // true
    }

}
