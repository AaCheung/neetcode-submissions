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
        int i = 0;
        while ( itr != null && fastItr != null ) {
            if ( itr == fastItr ) return true;
            if (i % 2 == 0 ) itr = itr.next;
            fastItr = fastItr.next;
            i++;
        }
        return false;
        
    }
}
