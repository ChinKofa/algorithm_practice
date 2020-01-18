package com.james.AddTwoNumbers2;

import java.math.BigDecimal;
import java.util.TooManyListenersException;

/**
 * @author: qinkefa
 * @Date: 2019/12/26 0026 12:40
 */
public class Solution1 {
    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        String sn1 = concatListStr(l1);
        String sn2 = concatListStr(l2);

        String snr1 = reverseSn(sn1);
        String snr2 = reverseSn(sn2);

        BigDecimal n1 = new BigDecimal(snr1);
        BigDecimal n2 = new BigDecimal(snr2);

        return insertNumberToLn(reverseSn(String.valueOf(n1.add(n2))));
    }

    private String concatListStr(ListNode l){
        StringBuffer sb = new StringBuffer();
        while(l != null){
            sb.append(l.val);
            l = l.next;
        }
        return sb.toString();
    }

    private String reverseSn(String sn){
        StringBuffer sb = new StringBuffer();
        for(int i = sn.length() - 1; i >= 0; i--){
            sb.append(sn.charAt(i));
        }
        return sb.toString();
    }

    private ListNode insertNumberToLn(String sn){
        int len = sn.length();
        ListNode resultList = new ListNode(Integer.parseInt(String.valueOf(sn.charAt(0))));
        ListNode temp = resultList;
        for(int i = 1; i < len; i++){
            temp.next = new ListNode(Integer.parseInt(String.valueOf(sn.charAt(i))));
            temp = temp.next;
        }
        return resultList;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);

        ListNode temp = l;
        temp = new ListNode(123);


        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }

        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
