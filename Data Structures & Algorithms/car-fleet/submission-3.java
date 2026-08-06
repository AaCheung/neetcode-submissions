class Car implements Comparable<Car>{
    int position, speed;

    public Car( int _p, int _s ) {
        position = _p;
        speed = _s;
    }

    public boolean checkFleet( Car other, int target ) {
        float otherTime = ( target - other.position ) / (float) other.speed, 
            thisTime = ( target - this.position ) / (float) this.speed;

        //System.out.println( otherTime + " vs " + thisTime );
        return ( other.position < this.position && otherTime <= thisTime ) || ( this.position < other.position && thisTime <= otherTime );
    }

    public int compareTo( Car other ) {
        if ( other.position != this.position ) {
            return this.position - other.position;
        }
        return 0;
    }

    public String toString() {
        return String.format( "( %d, %d )", position, speed );
    }

}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<Car>( position.length );
        for ( int i = 0; i < position.length; i++ ) {
            cars.add( new Car( position[i], speed[i] ) );
        }
        Collections.sort( cars );
        //System.out.println( cars );
        int i = cars.size() - 1;
        while ( i > 0 ) {
            if ( cars.get( i ).checkFleet( cars.get(i - 1), target ) ) {
                cars.remove( i - 1 );
            } 
            i--;
        }
        //System.out.println( cars );

        return cars.size();
        
    }
}
