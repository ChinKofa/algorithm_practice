package com.james.AddTwoNumbers2;

import javax.sound.midi.Soundbank;

/**
 * @author: qinkefa
 * @Date: 2019/12/26 0026 14:19
 */
public class Sulution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int sum;
        int high = 0;

        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                sum = l2.val + high;
                l2 = l2.next;
            } else if (l1 != null && l2 == null){
                sum = l1.val + high;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + high;
                l1 = l1.next;
                l2 = l2.next;
            }

            high = (int)Math.floor(sum / 10);
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;
        }

        if(high > 0){
            temp.next = new ListNode(high);
        }

        return head.next;
    }

    public ListNode addTwoNumbersRec(ListNode l1, ListNode l2){

        return null;
    }

    private ListNode helper(ListNode l1, ListNode l2, boolean carry){
        if(l1 == null && l2 == null && !carry){
            return null;
        } else if (l1 == null && l2 == null && carry){
            return new ListNode(1);
        } else if(l1 != null && l2 == null){
            l1 = l1.next;
        } else if(l1 == null && l2 != null){
            l2 = l2.next;
        }

        l1 = l1.next;
        l2 = l2.next;

        if(carry) {
            int sum = l1.val + l2.val + 1;
            ListNode head = new ListNode(sum);
            helper(l1, l2, true);
        } else {
            int sum = l1.val + l2.val;
            ListNode head = new ListNode(sum);
            helper(l1, l2, false);
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(7);

        Sulution2 s = new Sulution2();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
