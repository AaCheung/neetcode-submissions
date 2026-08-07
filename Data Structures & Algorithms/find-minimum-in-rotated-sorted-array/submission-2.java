class Solution {
    public int findMin(int[] nums) {
        if ( nums[0] < nums[nums.length - 1] ) return nums[0]; 
        int l = 0, r = nums.length - 1; 
        while ( l < r - 1 ) {
            int m = ( l + r ) / 2;
            //System.out.println( String.format( "( %d, %d, %d )", l, m, r ) );
            if ( ( nums[m] < nums[r] )
              || ( nums[l] > nums[m] ) ) {
                r = m;
            } else {
                l = m;
            }
        }
        return nums[r];
        
    }
}
