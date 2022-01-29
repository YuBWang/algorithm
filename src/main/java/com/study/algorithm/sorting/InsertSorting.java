package com.study.algorithm.sorting;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * 插入排序
 * @Author: wyb
 * @Date: 2022/1/29 22:23
 */
public class InsertSorting {
    public static void insertSorting(int[] nums) {
        // 分为已排好序的左边和待插入的右边，最开的左边只有数据第一个数据
        for (int i = 1; i < nums.length; i++) {
            // 要插入的那个数据
            int num = nums[i];
            int j;
            // 左边的和待插入的进行排序
            for (j = i -1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                swap(nums, j, j+1);
            }
            nums[j+1] = num;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertSorting(nums);
        System.out.println(Arrays.toString(nums));
    }

}
