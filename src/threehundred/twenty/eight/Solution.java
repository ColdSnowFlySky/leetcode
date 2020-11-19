package threehundred.twenty.eight;

public class Solution {
    public static void main(String[] args) {
        ListNode l = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );
        new Solution().oddEvenList(l);
        System.out.print(l);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        ListNode index1 = head;
        ListNode index2 = head.next;
        ListNode midIndex = head.next;
        head = head.next.next;
        while(head != null) {
            index1.next = head;
            index1 = head;
            head = head.next;
            if(head != null) {
                index2.next = head;
                index2 = head;
                head = head.next;
            } else {
                index2.next = head;
                break;
            }
        }
        index1.next = midIndex;
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
