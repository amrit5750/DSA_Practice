package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class AddOperations {

    public static void main(String[] args) {

        String num = "123";
        int target = 6;
        System.out.println(addOperators(num, target));

    }

    public static List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return result;
        }
        addOperatorsHelper(result, "", num, target, 0, 0, 0);

        return result;

    }

    public static void addOperatorsHelper(List<String> result, String expr, String num, int target, int index,
            long currentValue, long prev) {

        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            String CurrentString = num.substring(index, i + 1);
            long currentNum = Long.parseLong(CurrentString);

            if (index == 0) {
                addOperatorsHelper(result, CurrentString, num, target, i + 1, currentNum, currentNum);
            } else {
                // '+'
                addOperatorsHelper(result, expr + "+" + CurrentString, num, target, i + 1, currentValue + currentNum,
                        currentNum);
                // '-'
                addOperatorsHelper(result, expr + "-" + CurrentString, num, target, i + 1, currentValue - currentNum,
                        -currentNum);
                // '*'
                addOperatorsHelper(result, expr + "*" + CurrentString, num, target, i + 1,
                        currentValue - prev + prev * currentNum,
                        prev * currentNum);

            }

        }

    }

}
