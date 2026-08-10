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
    public boolean hasCycle(ListNode head) {
        ListNode itr = head, fastItr = ( head != null ? head.next : null );
        while ( itr != null && fastItr != null && fastItr.next != null ) {
            if ( itr.val == fastItr.val ) return true;
            itr = itr.next;
            fastItr = fastItr.next.next;
        }
        return false;
        
    }
}
