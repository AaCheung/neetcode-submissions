class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> dp = new HashMap<Character,Integer>();
        int max = 0;
        for ( char c: s.toCharArray() ) {
            max = Math.max( max, dp.computeIfAbsent(c, cKey -> characterReplacement( s, k, cKey )));
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
