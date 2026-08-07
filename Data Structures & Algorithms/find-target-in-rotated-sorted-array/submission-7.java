class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if ( nums[l] == target ) return l;
        if ( nums[r] == target ) return r;
        while ( l < r - 1 ) {
            int m = ( l + r ) / 2;
            if ( nums[m] == target ) return m;
            if ( nums[m] < nums[r] && nums[m] < target && target < nums[r] ) {
                //System.out.println( String.format( "1: ( %d, %d, %d )", l, m, r ) );
                l = m;
            } else if ( nums[l] < nums[m] && nums[l] < target && target < nums[m] ) {
                //System.out.println( String.format( "2: ( %d, %d, %d )", l, m, r ) );
                r = m;
            } else if ( nums[l] > nums[m] && (target < nums[m] || nums[l] < target ) ) {
                //.out.println( String.format( "3: ( %d, %d, %d )", l, m, r ) );
                r = m;
            } else if ( nums[m] > nums[r] && (target < nums[r] || nums[m] < target) ) {
                //System.out.println( String.format( "4: ( %d, %d, %d )", l, m, r ) );
                l = m;
            } else {
                //System.out.println( String.format( "5: ( %d, %d, %d )", l, m, r ) );
                r = m;
            }
        }
        return -1;

        
    }
}
