class Pointer {

}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> list = new ArrayDeque<Integer>();
        HashMap<Integer,HashSet<Integer>> valueAt = new HashMap<Integer,HashSet<Integer>>();
        int[] days = new int[ temperatures.length ];
        for ( int i = 0; i < temperatures.length; i++ ) {
            valueAt.computeIfAbsent(temperatures[i], ( k ) -> new HashSet<Integer>()).add( i );

            list.addLast(temperatures[i] );
            System.out.println( valueAt );
            for ( int value: valueAt.keySet() ) {
                if ( value < temperatures[i] ) {
                    HashSet<Integer> indexesOfValue = valueAt.get( value );
                    for ( int index: indexesOfValue ) {
                        days[index] = i - index;
                    }
                    indexesOfValue.clear();
                }

            }
        }
        return days;
        
    }
}
