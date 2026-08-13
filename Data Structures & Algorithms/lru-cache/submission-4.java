class LRUCache {

    int capacity;
    ArrayDeque<Integer> lruQueue = new ArrayDeque<Integer>();

    HashMap<Integer, Integer> cache = new HashMap<Integer,Integer>();
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
    }
    
    public int get(int key) {
        //System.out.println( String.format("get( %d ): %s, %s", key, lruQueue.toString(), cache.toString() ) );
        Integer value = cache.get( key );
        if ( value != null ) {
            addOrBubbleUp( key );
            return value;
        } 
        return -1;
    }

    public void addOrBubbleUp( int key ) {
        lruQueue.remove( key );
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
