package edu.elon.algorithms;

/**
 * Puzzle9
 *
 * @author Blake Byerly
/*

 *
In a sentence of two (at most), explain how your backtracking algorithm works?
The tiles are placed from the top left incrementally, while seeing if the tile 
is already placed. Every single rotation is checked then added.
tile is tried. Once a 9th valid tile is found, a solution is printed.

Did you implement pruning? If so, explain how you decided to prune a tree branch?
Yes. When the tiles are placed, and every rotation is checked, the tiles are matched
and the branch is broken if none of the combinations work.

Q3: Run your solution on all puzzleX.txt puzzles. Report the number of times your solution called your method that validates 
(checks to see if a board is currently valid or board is an answer) a board?  Your code should find all solutions (including rotations). 
1: 4390 checks
2: 5211 checks
3: 4840 checks
4: 5008 checks
5: 5478 checks
6: 4912 checks

*/

public class Main {

    public static void main(String[] args) {

        Puzzle9 puzzle9 = new Puzzle9("src/edu/elon/algorithms/puzzles/puzzle3.txt");
        puzzle9.puzzleSolve();

    }
}
