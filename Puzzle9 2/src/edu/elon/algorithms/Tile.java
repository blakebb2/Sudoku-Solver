package edu.elon.algorithms;

/**
 * Represents one tile in the Puzzle-9.
 *
 * @author J. Hollingsworth
 */

public class Tile {

    private String title = "";
    private int [] values = new int[4];
    private int rotation = ZERO;

    // the possible rotations
    public static final int ZERO = 0;
    public static final int NINETY = 1;
    public static final int ONEEIGHTY = 2;
    public static final int TWOSEVENTY = 3;

    // the possible directions (useful for pruning)
    public static final int TOP = 0;
    public static final int RIGHT = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;

    public Tile(String tile) {
        String [] parts = tile.split("\\s+");

        title = parts[0];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(parts[i+1]);
        }
    }

    public int getValue(int which) {
        int actual = (values.length - rotation + which)
                % values.length;
        return values[actual];
    }

    public void rotate(int which) {
        rotation = which;
    }

    public int getRotation() {
        return rotation;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        String str = title;
        for (int i = 0; i < values.length; i++) {
            str += " " + values[i];
        }
        return str;
    }
}
