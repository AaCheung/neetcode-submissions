class Entry {
    String value;
    int timestamp;
    public Entry( String _value, int _timestamp ) {
        value = _value;
        timestamp = _timestamp;
    }

    public String toString() {
        return String.format( "( %s, %d )", value, timestamp );
    }
}
class TimeMap {
    HashMap<String, ArrayList<Entry>> map = new HashMap<String,ArrayList<Entry>>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Entry>()).add( new Entry( value, timestamp ));
        //System.out.println( map );
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Entry> entries = map.get( key );
        if ( entries == null ) return "";
        int t = entries.size(), b = -1;

        while ( b < t - 1 ) {
            int m = ( b + t ) / 2;
            //System.out.println( String.format( "( %d, %d, %d ) for %d", b, m, t, timestamp) );
            if ( timestamp >= entries.get( m ).timestamp ) {
                b = m;
            } else {
                t = m;
            }
        }
        if ( b == -1 ) return "";
        return entries.get( b ).value;

        
    }
}
