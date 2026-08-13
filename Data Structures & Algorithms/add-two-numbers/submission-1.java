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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersWithCarry( l1, l2, 0 );
    }

    public ListNode addTwoNumbersWithCarry( ListNode l1, ListNode l2, int carry ) {
        int val = getVal( l1 ) + getVal( l2 ) + carry;
        ListNode node = new ListNode( val % 10 );
        carry = val / 10;
        if ( hasNext( l1 ) || hasNext( l2 ) || carry > 0 ) {
            node.next = addTwoNumbersWithCarry( getNext( l1 ), getNext( l2 ), carry );
        }
        return node;

    }

    public int getVal( ListNode l ) {
        return ( l != null ? l.val : 0 );
    }

    public boolean hasNext( ListNode node ) {
        return node != null && node.next != null;
    }

    public ListNode getNext( ListNode node ) {
        if ( node == null ) return null;
        return node.next;
    }
}
