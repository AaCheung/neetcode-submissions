class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while ( l < r ) {
            while ( numbers[l] < target - numbers[r] ) {
                l++;
            }
            if ( numbers[l] == target - numbers[r] ) return new int[]{ l + 1, r + 1 };
            r--;

        }
        return new int[]{ 0, 0 };
        
    }
}
