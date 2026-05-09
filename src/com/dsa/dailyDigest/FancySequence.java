package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class FancySequence {

    public List<Long> sequence = null;
    static final long mod = 1_000_000_007;
    long mul;
    long add;

    public static void main(String[] args) {
        FancySequence obj = new FancySequence();
        obj.append(2);
        obj.addAll(3);
        obj.append(7);
        obj.multAll(2);
        int param_4 = obj.getIndex(0);
        System.out.println(param_4);
    }

    public FancySequence() {
        sequence = new ArrayList<>();
        mul = 1;
        add = 0;

    }

    public static long power(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = power(a, b / 2);
        long result = (half * half) % mod;

        if (b % 2 == 1) {
            result = (result * a) % mod;
        }

        return result;

    }

    public void append(int val) {
        long num = ((val - add + mod) % mod);
        num = (num * power(mul, mod - 2)) % mod;
        sequence.add(num);
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;

    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;

    }

    public int getIndex(int idx) {

        if (idx >= sequence.size()) {
            return -1;
        }

        Long x = sequence.get(idx);

        return (int) ((x * mul % mod + add) % mod);

    }

}
