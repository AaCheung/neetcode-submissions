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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        n = length( head, 0 ) - n;
        //System.out.println( String.format( "length: %d, n %d", length( head ), n ));
        return removeNth( head, n );


    }

    public ListNode removeNth( ListNode head, int n ) {
        if ( head == null ) return null;
        if ( n == 0 ) return head.next;
        head.next = removeNth( head.next, n - 1 );
        return head;

    }

    public int length( ListNode node, int acc ) {
        if ( node == null ) return acc;
        return length( node.next, acc + 1 );
    }
}
