class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] counts = new int[9];

        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++ ) {
                //System.out.println(String.format("board[%d][%d]: %c", i, j, board[i][j]));
                if (  board[i][j] != '.' && counts[ board[i][j] - '1' ]++ > 0) return false;
            }
            Arrays.fill( counts, 0 );
        }

        //System.out.println("rows cleared");

        for ( int i = 0; i < 9; i++ ) {
            for ( int j = 0; j < 9; j++ ) {
                //System.out.println(String.format("board[%d][%d]: %c", i, j, board[j][i]));
                if ( board[j][i] != '.' && counts[ board[j][i] - '1']++ > 0) return false;
            }
            Arrays.fill( counts, 0 );
        }
        
        //System.out.println("cols cleared");

        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                for ( int i1 = 3*i; i1 < 3 * (i + 1 ); i1++ ) {
                    for ( int j1 = 3 * j; j1 < 3 * (j + 1); j1++ ) {
                        //System.out.println(String.format("board[%d][%d]: %c", i1, j1, board[i1][j1]));
                        if( board[i1][j1] != '.' && counts[ board[i1][j1] - '1' ]++ > 0) return false;
                    }
                }
                Arrays.fill( counts, 0 );
            }
        }

        return true;
        
    }
}
