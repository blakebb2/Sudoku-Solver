/**
 * Represents the building of the board and backtracking algorithm 
 * to check matching numbers between tiles that cancel out
 *
 * @author Blake Byerly
 */

package edu.elon.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle9 {
	
    private Board board = new Board();
    private Tile [] tiles = new Tile[9];
    
    public int[] collumnIndex = {0, 1, 2, 2, 1, 0, 0, 1, 2};
    public int[] rowIndex = {0, 0, 0, 1, 1, 1, 2, 2, 2,};

//    private Board board = new Board();
//    private Tile [] tiles = new Tile[9];

    public Puzzle9(String puzzleFileName) {

        // open a tile definition file
        File file = new File(puzzleFileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Invalid file name: " + puzzleFileName);
            System.exit(-1);
        }

        String title = sc.nextLine();
        System.out.println(title);

        // add tiles
        int i = 0;
        while (sc.hasNextLine()) {
            tiles[i] = new Tile(sc.nextLine());
            i++;
        }
        
    }


        private boolean [] newboard;
        private int count = 0;

        public void puzzleSolve() {
        	newboard = new boolean[9];
            for (int i = 0; i < 9; i++) {
                newboard[i] = true;
            }
            recursiveSolve(0);
            System.out.println("# of checks: " + count);
        }

        private void recursiveSolve(int index) {
            for (int i = 0; i < 9; i++) { // spaces
                if (newboard[i]) { // see space
                    board.add(rowIndex[index], collumnIndex[index], tiles[i]);
                    board.rotate(rowIndex[index], collumnIndex[index], 0);
                    newboard[i] = false;
                    if (isFill()) { // solution
                        count++;
                    }
                    else { // iterate through rest
                        for (int rot = 0; rot < 4; rot++) {
                            board.rotate(rowIndex[index], collumnIndex[index], rot);
                            if (Board.tileMatch(index)) {
                                count++;
                                recursiveSolve(index + 1);
                            }
                        }
                    }
                    board.add(rowIndex[index], collumnIndex[index], null);
                    newboard[i] = true;
                }
            }
        }
        private boolean isFill() {
            for (int i = 0; i < 9; i++) {
                if (newboard[i]) {
                    return false;
                }
            }
            return true;
        }

    }