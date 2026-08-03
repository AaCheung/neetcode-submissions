class Node {
    int value;
    Node less, greaterThanEqualTo;

    public Node ( int _v ) {
        value = _v;
    }

    public int getMax() {
        if ( greaterThanEqualTo != null ) return greaterThanEqualTo.getMax();
        return value;
    }

    public Node remove( int valueToRemove ) {
        if ( valueToRemove < value ) {
            if ( less != null ) less = less.remove( valueToRemove );
            return this;
        } else if ( valueToRemove == value ) {
            if ( less == null ) return greaterThanEqualTo;
            if ( greaterThanEqualTo == null ) return less;
            greaterThanEqualTo.addNode( less );
            return greaterThanEqualTo;
        } else {
            if ( greaterThanEqualTo != null ) greaterThanEqualTo = greaterThanEqualTo.remove( valueToRemove );
            return this;
        }
    } 

    public Node add( int value ) {
        addNode( new Node( value ) );
        return this;
    }

    public Node addNode( Node n ) {
        if ( n.value >= this.value ) {
            if ( greaterThanEqualTo == null ) greaterThanEqualTo = n;
            else greaterThanEqualTo.addNode( n );
        } else {
            if ( less == null ) less = n;
            else less.addNode( n );
        }
        return this;
    }

    public String toString() {
        return String.format( "(%s (%d) %s)", less, value, greaterThanEqualTo);
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxSlidingWindow = new int[ nums.length - k + 1 ];

        Node values = new Node( nums[0] );
        for ( int i = 1; i < k; i++ ) {
            values = values.add( nums[i] );
        }

        maxSlidingWindow[0] = values.getMax();

        for ( int i = 1; i < maxSlidingWindow.length; i++ ) {
            //System.out.println( values );
            values = values.add( nums[i+ k - 1] );
            values = values.remove( nums[i - 1] );
            maxSlidingWindow[i] = values.getMax();
        }

        return maxSlidingWindow;
        
    }
}
