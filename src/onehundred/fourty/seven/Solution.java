package onehundred.fourty.seven;

import tools.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode test = new ListNode(-1,
                new ListNode(5,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(0)))));
        ListNode result = new Solution().insertionSortList(test);
        System.out.print("OK");
    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode node1 = head;
        ListNode node2;
        boolean isInsert;
        //我的菜鸡方法
        while(node1.next != null) {
            node2 = head;
            isInsert = false;
            if(node2.val > node1.next.val) {
                ListNode temp = catchNode(node1);
                temp.next = node2;
                head = temp;
                continue;
            }
            while(node2.next != node1.next) {
                if(node2.next.val > node1.next.val) {
                    ListNode temp = catchNode(node1);
                    temp.next = node2.next;
                    node2.next = temp;
                    isInsert = true;
                    break;
                }
                node2 = node2.next;
            }
            if(isInsert) continue;
            if(node1.next != null) node1 = node1.next;
            else break;
        }
        //官方答案
//        ListNode dummyHead = new ListNode(0);
//        dummyHead.next = head;
//        ListNode lastSorted = head, curr = head.next;
//        while (curr != null) {
//            if (lastSorted.val <= curr.val) {
//                lastSorted = lastSorted.next;
//            } else {
//                ListNode prev = dummyHead;
//                while (prev.next.val <= curr.val) {
//                    prev = prev.next;
//                }
//                lastSorted.next = curr.next;
//                curr.next = prev.next;
//                prev.next = curr;
//            }
//            curr = lastSorted.next;
//        }
        return head;
    }
    private ListNode catchNode(ListNode node1) {
        ListNode result = new ListNode(node1.next.val);
        if(node1.next.next != null) node1.next = node1.next.next;
        else node1.next = null;
        return result;
    }
}
