class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( String token: tokens ) {
            if ( isOperation( token ) ) {
                int value2 = list.removeLast();
                int value1 = list.removeLast();
                list.add( doOperation(value1, token, value2 ) );
            } else {
                list.add( Integer.parseInt( token ) );
            }
        }
        return list.removeLast();
        
    }

    public boolean isOperation( String token ) {
        return "+-*/".indexOf( token ) != -1;
    }

    public int doOperation( int v1, String token, int v2 ) {
        switch( token ) {
            case "+": return v1 + v2;
            case "-": return v1 - v2;
            case "*": return v1 * v2;
            case "/": return v1 / v2;
            default: return -1;
        }
    }
}
