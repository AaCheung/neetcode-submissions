class Pointer {

}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> list = new ArrayDeque<Integer>();
        HashMap<Integer,HashSet<Integer>> valueAt = new HashMap<Integer,HashSet<Integer>>();
        int[] days = new int[ temperatures.length ];
        for ( int i = 0; i < temperatures.length; i++ ) {
            valueAt.computeIfAbsent(temperatures[i], ( k ) -> new HashSet<Integer>()).add( i );

            while ( !list.isEmpty() && list.getFirst() < temperatures[i] ) {
                int value = list.pollFirst();
                HashSet<Integer> indexesOfValue = valueAt.get( value );
                for ( int index: indexesOfValue ) {
                    days[index] = i - index;
                }
                indexesOfValue.clear();
                valueAt.remove( value );
            }
            if ( list.isEmpty() || list.peekFirst() != temperatures[i] ) list.addFirst( temperatures[i] );
            //System.out.println( list );
            //System.out.println( valueAt );
        }
        return days;
        
    }
}
