class Tuple implements Comparable<Tuple> {
    int val, freq;
    public Tuple ( int n ) {
        val = n;
        freq = 0;
    }

    public void increment() {
        freq++;
    }
    public int compareTo( Tuple other ) {
        return other.freq - this.freq;
    }
    public String toString() {
        return String.format("( %d, %d times )", val, freq ); 
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Tuple> map = new HashMap<Integer,Tuple>();
        for ( int n: nums ) {
            map.computeIfAbsent( n, ( val ) -> new Tuple( val )).increment();
        }
        List<Tuple> list = new ArrayList<Tuple>( map.values() );
        //System.out.println( list );
        Collections.sort( list );
        //System.out.println( list );
        int[] arr = new int[ k ];
        for ( int i = 0; i < k; i++ ) {
            arr[i] = list.get( i ).val; 
        }
        return arr;
    }
}
