class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> charCounts = new HashMap<Character,Integer>();
        for ( char c: s1.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        //System.out.println( charCounts);

        
        HashMap<Character, Integer> windowCharCounts = new HashMap<Character,Integer>();
        int start = 0, end = 0;
        while ( end < s2.length() ) {

            windowCharCounts.put( s2.charAt(end), windowCharCounts.getOrDefault(s2.charAt(end), 0) + 1);
            while ( windowCharCounts.getOrDefault( s2.charAt(end), 0 ) 
                        > charCounts.getOrDefault( s2.charAt(end), 0 ) 
            ) {
                windowCharCounts.computeIfPresent(
                    s2.charAt(start), 
                    (k, v) -> ( v > 1 ? v - 1 : null ));
                start++;
            }

            System.out.println( windowCharCounts );

            if ( windowCharCounts.equals( charCounts) ) return true;
            end++;
        }

        return false;
        
    }
}
