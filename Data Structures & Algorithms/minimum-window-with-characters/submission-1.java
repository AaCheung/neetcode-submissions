class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tCounts = new HashMap<Character,Integer>();
        HashMap<Character,Integer> sCounts = new HashMap<Character,Integer>();
        for ( char c: t.toCharArray()) {
            tCounts.compute(c, (k, v) -> ( v == null ? 1 : v + 1 ));
        }

        int start = 0, end = 0;
        String minString = "";
        while ( end < s.length()) {
            sCounts.compute(s.charAt(end), (k, v) -> ( v == null ? 1 : v + 1 ));
            while ( start < s.length() && sCounts.getOrDefault(s.charAt(start), 0 ) > tCounts.getOrDefault(s.charAt(start), 0 ) ) {
                sCounts.computeIfPresent(s.charAt(start), (k, v) -> ( v < 2 ? null : v - 1 ));
                start++;
            }

            //System.out.println( s.substring( start, end + 1 ) + ": " + sCounts );
            if ( countsAllAbove( sCounts, tCounts ) ) {
                if ( minString.isEmpty() || end - start + 1 < minString.length() ) {
                    minString = s.substring(start, end + 1 );
                }
            }

            end++;
        }
        return minString;
        
    }

    public boolean countsAllAbove(HashMap<Character,Integer> sCounts, HashMap<Character,Integer> tCounts) {
        for ( Map.Entry<Character,Integer> e: tCounts.entrySet()) {
            if ( sCounts.getOrDefault(e.getKey(), 0) < e.getValue() ) return false;
        }
        return true;
    }
}
