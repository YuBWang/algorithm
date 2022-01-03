package com.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个罗马数字，将其转换成整数。
 *
 * @Author: wyb
 * @Date: 2022/1/2 20:30
 */
public class RomanNumeralstoIntegers {

    public static void main(String[] args) {
        String s = "III";
        int result = romanToInt(s);
        System.out.println(result);

    }

    public static int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (romanMap.get(s.charAt(i) + "") < romanMap.get(s.charAt(i + 1) + "")) {
                result -= romanMap.get(s.charAt(i) + "");
            } else {
                result += romanMap.get(s.charAt(i) + "");
            }
        }
        result += romanMap.get(s.charAt(s.length() - 1) + "");
        return result;

    }
}
