/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> nodeMap = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        Node itr = head;
        while ( itr != null ) {
            nodeMap.put(itr, new Node( itr.val ));
            itr = itr.next;
        }
        itr = head;
        while ( itr != null ) {
            Node itrCopy = nodeMap.get( itr );
            if ( itr.next != null ) itrCopy.next = nodeMap.get( itr.next );
            if ( itr.random != null ) itrCopy.random = nodeMap.get( itr.random );
            itr = itr.next;
        }
        return nodeMap.get( head );
    }
}
