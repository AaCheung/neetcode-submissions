class Node {
    Node next;

    public Node( Node _next ) {
        next = _next;
    }

    int _len = -1;

    public int length() {
        if ( next == null ) return 1;
        if ( _len != -1 ) return _len;
        _len = 1 + next.length();
        return _len; 
    }

    public String toString() {
        return String.format( "( ) -> %s", ( next != null ? next : "null"));
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
        for ( int n: nums ) { 
            if ( !nodes.containsKey( n ) ) {
                Node node = new Node( nodes.get( n - 1 ) );
                Node prevNode = nodes.get( n + 1 );
                if ( prevNode != null ) {
                    prevNode.next = node;
                }
                nodes.put( n, node );
            }
        }

        //System.out.println( nodes );
        int max = 0;
        for ( Node node: nodes.values() ) {
            max = Math.max( max, node.length() );
        }

        return max;
        
    }
}
