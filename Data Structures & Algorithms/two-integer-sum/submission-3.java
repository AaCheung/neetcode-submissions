class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexOf = new HashMap<Integer,Integer>();
        for ( int i = 0; i < nums.length; i++ ) {
            int otherIndex = indexOf.getOrDefault( target - nums[i], -1 );
            if ( otherIndex != -1 ) {
                return new int[]{ otherIndex, i };
            }
            indexOf.put( nums[i], i );
        }
        return new int[2];
        
    }
}
