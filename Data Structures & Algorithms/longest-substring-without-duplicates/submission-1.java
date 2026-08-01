class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeenAt = new HashMap<Character,Integer>();

        int start = -1, longestSubstring = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            start = Math.max( start, lastSeenAt.getOrDefault( s.charAt(i), -1 ) );
            longestSubstring = Math.max( longestSubstring, i - start );
            lastSeenAt.put( s.charAt( i ), i );
        }
        return longestSubstring;
        
    }
}
