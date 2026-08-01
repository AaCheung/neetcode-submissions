class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> sums = new HashSet<List<Integer>>();
        Arrays.sort( nums );

        for ( int j = 1; j < nums.length - 1; j++ ) {
            int i = 0;
            int k = nums.length - 1;
            while ( i < j && j < k ) {
                int sum = nums[i] + nums[j] + nums[k];
                //System.out.println( String.format( "( %d, %d, %d ): %d", i, j, k, sum ));
                if ( sum < 0 ) {
                    i++; 
                } else if ( 0 < sum ) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<Integer>( 3 );
                    list.add( nums[i] );
                    list.add( nums[j] );
                    list.add( nums[k] );
                    sums.add( list );
                    i++;
                }
            }
        }
        return new ArrayList<List<Integer>>( sums );
        
    }
}
