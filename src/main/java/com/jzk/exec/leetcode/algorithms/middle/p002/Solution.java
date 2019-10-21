package com.jzk.exec.leetcode.algorithms.middle.p002;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode resultNode = null;
        ListNode cursorNode = null;
        ListNode tmpNode1 = l1;
        ListNode tmpNode2 = l2;
        int add = 0;
        do {
            int sum = 0;
            if(tmpNode1 == null) {
                sum = tmpNode2.val + add;
            } else if(tmpNode2 == null) {
                sum = tmpNode1.val + add;
            } else {
                sum = tmpNode1.val + tmpNode2.val + add;
            }
            
            add = sum / 10;
            
            if(resultNode == null) {
                resultNode = new ListNode(sum%10);
                cursorNode = resultNode;
            }else {
                cursorNode.next = new ListNode(sum%10);
                cursorNode = cursorNode.next;
            }
            if(tmpNode1 !=null) tmpNode1 = tmpNode1.next;
            if(tmpNode2 !=null) tmpNode2 = tmpNode2.next;
        } while(tmpNode1 != null || tmpNode2 != null);
        if(add>0) {
            cursorNode.next = new ListNode(add%10);
            cursorNode = cursorNode.next;
        }
        
        return resultNode;
    }
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
         }
}