class Car implements Comparable<Car>{
    int position;
    float timeToTarget;

    public Car( int _p, int _s, int target ) {
        position = _p;
        timeToTarget = ( target - position ) / (float) _s;
    }

    public boolean checkFleet( Car other ) {
        //System.out.println( otherTime + " vs " + thisTime );
        return ( other.position < this.position && other.timeToTarget <= this.timeToTarget ) || ( this.position < other.position && this.timeToTarget <= other.timeToTarget );
    }

    public int compareTo( Car other ) {
        if ( other.position != this.position ) {
            return this.position - other.position;
        }
        return 0;
    }

    public String toString() {
        return String.format( "( %d, %f )", position, timeToTarget );
    }

}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<Car>( position.length );
        for ( int i = 0; i < position.length; i++ ) {
            cars.add( new Car( position[i], speed[i], target ) );
        }
        Collections.sort( cars );
        //System.out.println( cars );
        int i = cars.size() - 1;
        while ( i > 0 ) {
            if ( cars.get( i ).checkFleet( cars.get(i - 1) ) ) {
                cars.remove( i - 1 );
            } 
            i--;
        }
        //System.out.println( cars );

        return cars.size();
        
    }
}
