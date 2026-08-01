class Solution {
    public int trap(int[] height) {
        int[] lHeight = new int[ height.length ];
        int[] rHeight = new int[ height.length ];
        int temp = 0;
        for ( int i = 0; i < height.length; i++ ) {
            temp = Math.max( temp, height[i] );
            lHeight[i] = temp;
        }

        temp = 0;
        for ( int j = height.length - 1; j >= 0; j-- ) {
            temp = Math.max( temp, height[j] );
            rHeight[j] = temp;
        }

        //System.out.println( Arrays.toString( lHeight ) );
        //System.out.println( Arrays.toString( rHeight ) );

        int trapped = 0;
        for ( int i = 0; i < height.length; i++ ) {
            trapped += Math.min( lHeight[i], rHeight[i] ) - height[i];
        }
        return trapped;
        
    }
}
