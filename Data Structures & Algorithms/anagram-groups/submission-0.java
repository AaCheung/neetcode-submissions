class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>, List<String>> charsToStrings = new HashMap<HashMap<Character,Integer>, List<String>>();

        for ( String s: strs ) {
            HashMap<Character,Integer> key = key( s );
            charsToStrings.computeIfAbsent( key, ( v ) -> new ArrayList<String>() ).add( s );
        }

        return new ArrayList<List<String>>( charsToStrings.values() );
        
    }

    public HashMap<Character,Integer> key(String s){
        HashMap<Character,Integer> key = new HashMap<Character,Integer>();
        for ( char c: s.toCharArray() ) {
            key.put( c, key.getOrDefault( c, 0 ) + 1 );
        }
        return key;
    }
}
