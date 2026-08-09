/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        return reverseList( head.next, head );

    }

    public ListNode reverseList( ListNode head, ListNode last ) {
        if ( head == null ) return last;
        //System.out.println( String.format("( %d, %d )", head.val, last.val ) );
        ListNode first = reverseList( head.next, head );
        if ( last != null ) last.next = null;
        head.next = last;
        return first;
    }
}
