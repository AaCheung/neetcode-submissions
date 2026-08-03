class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for ( char c = 'A'; c <= 'Z'; c++ ) {
            max = Math.max( max, characterReplacement( s, k, c ));
        }
        return max;
        
    }

    public int characterReplacement( String s, int k, char c ) {
        int start = 0, end = 0;
        int max = 0;
        int n_not_c = 0;
        while ( start <= end && end < s.length() ) {
            if ( s.charAt(end) != c ) n_not_c++;

            
            while ( n_not_c > k ) {
                if ( s.charAt( start ) != c ) n_not_c--;
                start++;
            }
            //System.out.println( s.substring( start, end + 1 ) );

            max = Math.max( end - start + 1, max );
            end++;
        }

        return max;
    }
}
