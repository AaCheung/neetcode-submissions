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
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists.length == 0 || lists[0] == null ) return null;
        for ( int i = 1; i < lists.length; i++ ) {
            lists[0] = mergeLists( lists[0], lists[i] );
        }
        return lists[0];

    }

    public ListNode mergeLists( ListNode l1, ListNode l2 ) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;

        ListNode root = new ListNode( 0 ), itr = root;

        while ( l1 != null && l2 != null ) {
            if ( l1.val < l2.val ) {
                itr.next = l1;
                l1 = l1.next;
            } else {
                itr.next = l2;
                l2 = l2.next;
            }
            itr = itr.next;
        } 
        while ( l1 != null ) {
            itr.next = l1;
            l1 = l1.next;
            itr = itr.next;
        }  
        while ( l2 != null ) {
            itr.next = l2;
            l2 = l2.next;
            itr = itr.next;
        } 
        return root.next;
    }
}
