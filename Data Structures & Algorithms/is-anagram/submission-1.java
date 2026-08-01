class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[26]; 
        if ( s.length() != t.length() ) return false;
        for (int i = 0; i < s.length(); i++ ) {
            charCounts[s.charAt(i) - 'a']++;
        }

        for ( int j = 0; j < t.length(); j++ ) {
            if ( charCounts[t.charAt(j)-'a'] < 1 ) return false;
            charCounts[t.charAt(j)-'a']--;
        }

        return true;

    }
}
