package edu.elon.algorithms;

/**
 * A 3x3 Tile Board, with tileMatch method
 *
 * @author Blake Byerly
 */

public class Board {

    private static Tile [][] board;

    public Board() {
        board = new Tile[3][3];
    }

    // add a tile to the board at the given location
    public void add(int row, int col, Tile tile) {
        board[row][col] = tile;
    }

    // rotate the tile at the given location
    public void rotate(int row, int col, int rotation) {
        board[row][col].rotate(rotation);
    }
    
 

    public boolean check() {
        // check left/right
        if (board[0][0].getValue(Tile.RIGHT) + board[0][1].getValue(Tile.LEFT) != 0)
                return false;
        if (board[0][1].getValue(Tile.RIGHT) + board[0][2].getValue(Tile.LEFT) != 0)
            return false;
        if (board[1][0].getValue(Tile.RIGHT) + board[1][1].getValue(Tile.LEFT) != 0)
            return false;
        if (board[1][1].getValue(Tile.RIGHT) + board[1][2].getValue(Tile.LEFT) != 0)
            return false;
        if (board[2][0].getValue(Tile.RIGHT) + board[2][1].getValue(Tile.LEFT) != 0)
            return false;
        if (board[2][1].getValue(Tile.RIGHT) + board[2][2].getValue(Tile.LEFT) != 0)
            return false;

        // check top/bottom
        if (board[0][0].getValue(Tile.BOTTOM) + board[1][0].getValue(Tile.TOP) != 0)
            return false;
        if (board[0][1].getValue(Tile.BOTTOM) + board[1][1].getValue(Tile.TOP) != 0)
            return false;
        if (board[0][2].getValue(Tile.BOTTOM) + board[1][2].getValue(Tile.TOP) != 0)
            return false;
        if (board[1][0].getValue(Tile.BOTTOM) + board[2][0].getValue(Tile.TOP) != 0)
            return false;
        if (board[1][1].getValue(Tile.BOTTOM) + board[2][1].getValue(Tile.TOP) != 0)
            return false;
        if (board[1][2].getValue(Tile.BOTTOM) + board[2][2].getValue(Tile.TOP) != 0)
            return false;

        return true;
    }
    
    public static String printTile(int row, int col) {
        if (board[row][col] == null) {
            return "__";
        }
        else {
            return board[row][col].getTitle() + board[row][col].getRotation();
        }
    }
    
    

    public String toString() {
        String str = "";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                str += board[row][col].getTitle() + board[row][col].getRotation() + " ";
            }
            str += "\n";
        }

        return str;
    }

	public static boolean tileMatch(int i) {
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            if (board[0][0].getValue(Tile.RIGHT) + board[0][1].getValue(Tile.LEFT) == 0)
                return true;
        }
        if (i == 2) {
            if (board[0][1].getValue(Tile.RIGHT) + board[0][2].getValue(Tile.LEFT) == 0)
                return true;
        }
        if (i == 3) {
            if (board[0][2].getValue(Tile.BOTTOM) + board[1][2].getValue(Tile.TOP) == 0)
                return true;
        }
        if (i == 4) {
            if ((board[1][1].getValue(Tile.TOP) + board[0][1].getValue(Tile.BOTTOM) == 0) &&
                    (board[1][1].getValue(Tile.RIGHT) + board[1][2].getValue(Tile.LEFT) == 0))
                return true;
        }
        if (i == 5) {
            if ((board[1][0].getValue(Tile.TOP) + board[0][0].getValue(Tile.BOTTOM) == 0) &&
                    (board[1][0].getValue(Tile.RIGHT) + board[1][1].getValue(Tile.LEFT) == 0))
                return true;
        }
        if (i == 6) {
            if (board[2][0].getValue(Tile.TOP) + board[1][0].getValue(Tile.BOTTOM) == 0)
                return true;
        }
        if (i == 7) {
            if ((board[2][1].getValue(Tile.TOP) + board[1][1].getValue(Tile.BOTTOM) == 0) &&
                    (board[2][1].getValue(Tile.LEFT) + board[2][0].getValue(Tile.RIGHT) == 0))
                return true;
        }
        if (i == 8) {
            if ((board[2][2].getValue(Tile.TOP) + board[1][2].getValue(Tile.BOTTOM) == 0) &&
                    (board[2][2].getValue(Tile.LEFT) + board[2][1].getValue(Tile.RIGHT) == 0))
                return true;
        }
        return false;
	}

}
