package com.dsa.greedy.easy;

// LeetCode Problem 860. Lemonade Change
// time complexity: O(n)
// space complexity: O(1)
// how to solve: Greedy Algorithm
//how it works: Keep track of the number of $5 and $10 bills we have. For each customer, we check the bill they give us 
// and give them change accordingly. If we can't give change, we return false. 
public class Lemonade {

    public static void main(String[] args) {

        int[] bills = { 5, 5, 5, 10, 20 };

        System.out.println(lemonadeChange(bills));

    }

    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int tens = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                tens++;
                five--;
            } else {
                if (bills[i] == 20) {
                    if (five > 0 && tens > 0) {
                        tens--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }

}
