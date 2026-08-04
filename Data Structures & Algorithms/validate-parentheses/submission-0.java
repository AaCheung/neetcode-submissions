class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for ( int i = 0; i < s.length(); i++ ) {
            if ( isOpeningParenthesis( s.charAt(i) )) {
                stack.add( s.charAt(i));
            } else {
                if ( stack.isEmpty() || s.charAt(i) != counterPart( stack.pollLast())) return false;
            }
        }
        return stack.isEmpty();
    }

    public char counterPart( char c ) {
        switch ( c ) {
            case '[': return ']';
            case '{': return '}';
            case '(': return ')';
            default: return 'N';
        }
    }

    public boolean isOpeningParenthesis( char c ) {
        return "[({".indexOf( c ) >= 0;
    }
}
