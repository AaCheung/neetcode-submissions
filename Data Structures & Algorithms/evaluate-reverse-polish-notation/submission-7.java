class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( String token: tokens ) {
            System.out.println( list );
            if ( isOperation( token ) ) {
                int value2 = list.removeLast();
                int value1 = list.removeLast();
                list.add( doOperation(value1, token.charAt( 0 ), value2 ) );
            } else {
                list.add( Integer.parseInt( token ) );
            }
        }
        return list.removeLast();
        
    }

    public boolean isOperation( String token ) {
        switch ( token ) {
            case "+":
            case "-": 
            case "*": 
            case "/": return true;
            default: return false;
        }
    }

    public int doOperation( int v1, char op, int v2 ) {
        switch( op ) {
            case '+': return v1 + v2;
            case '-': return v1 - v2;
            case '*': return v1 * v2;
            case '/': return v1 / v2;
            default: return -1;
        }
    }
}
