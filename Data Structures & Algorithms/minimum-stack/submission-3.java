class Node {
    int value, min;
    Node prev, next;

    public Node( int _v, Node _prev ) {
        value = _v;
        prev = _prev;
        min = value;
        if ( prev != null ) { 
            prev.next = this;
            min = Math.min( min, prev.min );
        }
    }

    public void push( int _v ) {
        if ( next != null ) next.push( _v );
        else next = new Node( _v, this );
    }

    public void pop() {
        if ( next.next == null ) {
            next = null;
        } else {
            next.pop();
        }
    }

    public int top() {
        if ( next == null ) return value;
        return next.top();
    }

    public int getMin() {
        return min;
    }

    public String toString() {
        return String.format( "( %d, %s )", value, next );
    }

}

class MinStack {

    Node node;
    Node first;

    ArrayList<Integer> list = new ArrayList<Integer>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        node = new Node( val, node );
        if ( node.prev == null ) first = node;
        //System.out.println( first );
    }
    
    public void pop() {
        if ( node.prev != null ) { 
            node = node.prev; 
            node.pop();
        } else node = null;
    }
    
    public int top() {
        return node.top();
    }
    
    public int getMin() {
        return node.getMin();
    }
}
