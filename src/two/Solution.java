package two;

import tools.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode result = new ListNode();
        ListNode index = result;
        int val = 0, val1 = 0, val2 = 0;
        while(true) {
            if(l1 != null) val1 = l1.val;
            else val1 = 0;
            if(l2 != null) val2 = l2.val;
            else val2 = 0;
            if((val = val1 + val2 + temp) > 9) {
                temp = 1;
                index.val = val - 10;
            } else {
                temp = 0;
                index.val = val;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            if(l1 == null && l2 == null && temp == 0) break;
            index.next = new ListNode();
            index = index.next;
        }
        return result;
    }
}


