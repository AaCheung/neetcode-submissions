class LRUCache {

    int capacity;
    ArrayDeque<Integer> lruQueue = new ArrayDeque<Integer>();

    HashMap<Integer, Integer> cache = new HashMap<Integer,Integer>();
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
    }
    
    public int get(int key) {
        //System.out.println( String.format("get( %d ): %s, %s", key, lruQueue.toString(), cache.toString() ) );
        if ( cache.containsKey(key) ) {
            addOrBubbleUp( key );
            return cache.get( key );
        } 
        return -1;
    }

    public void addOrBubbleUp( int key ) {
        if ( lruQueue.contains( key ) ) {
            lruQueue.remove( key );
        } 
        lruQueue.addFirst( key );
    }
    
    public void put(int key, int value) {
        addOrBubbleUp( key );
        

        if (lruQueue.size() > capacity) {
            cache.remove(lruQueue.pollLast());
        }
        cache.put( key, value );
        //System.out.println( String.format("put( %d, %d ): %s, %s", key, value, lruQueue.toString(), cache.toString() ) );


        
    }
}
