class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodLeft = new int[ nums.length ];
        int[] prodRight = new int[ nums.length ];
        prodLeft[0] = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            prodLeft[i] = prodLeft[i-1] * nums[i];
        }
        prodRight[nums.length - 1 ] = nums[ nums.length - 1 ];
        for ( int i = nums.length - 2; i >= 0; i-- ) {
            prodRight[i] = prodRight[i+1] * nums[i];
        }

        int[] product = new int[nums.length];

        product[0] = prodRight[1];

        product[nums.length - 1 ] = prodLeft[ nums.length - 2 ];

        for ( int i = 1; i < nums.length - 1; i++ ) {
            product[i] = prodLeft[ i - 1 ] * prodRight[ i + 1 ];
        }
        return product;
    }
}  
