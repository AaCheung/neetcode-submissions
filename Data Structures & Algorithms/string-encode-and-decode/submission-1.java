class Solution {

    public String encode(List<String> strs) {
        StringBuilder indexStringBuilder = new StringBuilder();
        indexStringBuilder.append( 0 );
        int index = 0;
        for ( int i = 0; i < strs.size(); i++ ) {
            indexStringBuilder.append( "," );
            index += strs.get( i ).length();
            indexStringBuilder.append( index );
        }
        indexStringBuilder.append( "|" );
        for ( int i = 0; i < strs.size(); i++ ) {
            indexStringBuilder.append( strs.get( i ) );
        }
        return indexStringBuilder.toString();
    }

    public List<String> decode(String str) {
        int indexOfDelim = str.indexOf( "|" );
        String indexString = str.substring( 0, indexOfDelim );
        String contentString = str.substring( indexOfDelim + 1 );

        List<Integer> indexes = decodeToList( indexString );

        //System.out.println( indexString + " | | " + contentString);
        List<String> stringList = new ArrayList<String>( indexes.size() );
        for ( int i = 1; i < indexes.size(); i++ ) {
            stringList.add( contentString.substring( indexes.get( i - 1 ), indexes.get( i ) ) );
        }
        return stringList;
        


    }

    public List<Integer> decodeToList( String s ) {
        List<Integer> list = new ArrayList<Integer>();
        int lastComma = -1, nextComma = s.indexOf(",");

        while ( lastComma < s.length() ) {
            int end = ( nextComma != -1 ? nextComma : s.length() );
            list.add( Integer.parseInt( s.substring( lastComma + 1, end ) ) );
            lastComma = end;
            nextComma = s.indexOf( ",", lastComma + 1 );
        }
        return list;
    }
}
