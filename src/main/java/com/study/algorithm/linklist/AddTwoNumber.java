package com.study.algorithm.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加 链表做法
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wyb
 * @Date: 2022/1/2 15:58
 *
 */
public class AddTwoNumber {

    public static void main(String[] args) throws Exception {
        ListNode head1 = new ListNode();
        ListNode l1 = head1;
        head1.val = 1;
        for (int i = 2; i< 4; i++) {
            ListNode node = new ListNode();
            node.val = i;
            head1.next = node;
            head1 = head1.next;
        }
        ListNode head2 = new ListNode();
        ListNode l2 = head2;
        head2.val = 1;
        for (int i = 5; i< 8; i++) {
            ListNode node = new ListNode();
            node.val = i;
            head2.next = node;
            head2 = head2.next;
        }
        addTwoNumbers(l1, l2);
        String  s = "dsfdsfdf";
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) throws Exception {
        double number1 = add(l1);
        double number2 = add(l2);
        double sum = number1 + number2;
        ListNode head = new ListNode();
        ListNode result = head;
        int headValue = (int)sum%10;
        head.val = headValue;
        sum = sum/10;
        while(0 != (int)sum) {
            ListNode node = new ListNode();
            node.val = (int)sum%10;
            head.next = node;
            head = head.next;
            sum = sum/10;
        }
       System.out.println(add(result));
        return result;
    }

    public static double add(ListNode linked) throws Exception {
        double result = linked.val;
        linked = linked.next;
        int count = 1;
        while(linked != null) {
            result = result + Math.pow(10, count) * linked.val;
            linked = linked.next;
            count++;

        }
        return result;
    }

    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I",1);
        romanMap.put("IV",4);
        romanMap.put("V",5);
        romanMap.put("IX",9);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("XL",40);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        romanMap.put("XC",90);
        romanMap.put("CD",400);
        romanMap.put("CM",900);
        int result = 0;
        for (int i = 0; i < s.length() -1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
