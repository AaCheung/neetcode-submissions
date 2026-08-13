class Solution {
    public int findDuplicate(int[] nums) {
        int slowIndex = nums[0], fastIndex = nums[nums[0]];
        while ( slowIndex != fastIndex ) {
            slowIndex = nums[slowIndex ];
            fastIndex = nums[nums[fastIndex]];
        }
        fastIndex = 0;

        while ( slowIndex != fastIndex ) {
            slowIndex = nums[slowIndex];
            fastIndex = nums[fastIndex];
        }

        return slowIndex;
        
    }
}
