class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while ( l < r ) {
            if ( !isAlphanumeric( s.charAt(l) ) ) {
                l++;
            } else if ( !isAlphanumeric( s.charAt(r) ) ) {
                r--;
            } else {
                if ( toLowercase(s.charAt(l)) != toLowercase(s.charAt( r )) ) return false;
                l++;
                r--;
            }
        }
        return true;

        
    }

    public boolean isUppercase( char c ) {
        return ('A' <= c && c <= 'Z');
    }

    public char toLowercase( char c ) {
        if ( isUppercase( c ) ) return (char) (c - 'A' + 'a');
        return c;
    }

    public boolean isAlphanumeric( char c ) {
        return isUppercase( c ) || ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}
