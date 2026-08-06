class Car implements Comparable<Car>{
    int position, speed;

    Car fleet;
    public Car( int _p, int _s ) {
        position = _p;
        speed = _s;
        fleet = this;
    }

    public boolean checkFleet( Car other, int target ) {
        if ( fleet != this ) { 
            return fleet.checkFleet( other, target );
        }
        other = other.fleet;
        float otherTime = ( target - other.position ) / (float) other.speed, 
            thisTime = ( target - this.position ) / (float) this.speed;

        //System.out.println( otherTime + " vs " + thisTime );
        if ( other.position < this.position && otherTime <= thisTime ) {
            other.fleet = this.fleet;
            return true;
        } else if ( this.position < other.position && thisTime <= otherTime ) {
            this.fleet = other.fleet;
            return true;
        }
        return this.fleet == other.fleet;
    }

    public int compareTo( Car other ) {
        if ( other.position != this.position ) {
            return this.position - other.position;
        }
        return 0;
    }

    public String toString() {
        return String.format( "( %d, %d ) -> %d", position, speed,  fleet.position );
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
