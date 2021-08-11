package game2048;

import java.util.Formatter;
import java.util.Observable;


/** The state of a game of 2048.
<<<<<<< HEAD
 *  @author TODO: Atmika and Ihsan
 */
public class Model extends Observable {
    /**
     * Current contents of the board.
     */
    private Board board;
    /**
     * Current score.
     */
    private int score;
    /**
     * Maximum score so far.  Updated when game ends.
     */
    private int maxScore;
    /**
     * True iff game is ended.
     */
    private boolean gameOver;


=======
 *  @author TODO: YOUR NAME HERE
 */
public class Model extends Observable {
    /** Current contents of the board. */
    private Board board;
    /** Current score. */
    private int score;
    /** Maximum score so far.  Updated when game ends. */
    private int maxScore;
    /** True iff game is ended. */
    private boolean gameOver;

>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    /* Coordinate System: column C, row R of the board (where row 0,
     * column 0 is the lower-left corner of the board) will correspond
     * to board.tile(c, r).  Be careful! It works like (x, y) coordinates.
     */

<<<<<<< HEAD
    /**
     * Largest piece value.
     */
    public static final int MAX_PIECE = 2048;

    /**
     * A new 2048 game on a board of size SIZE with no pieces
     * and score 0.
     */
    public Model(int size) {
        this.board = new Board(size);
        this.score = 0;
    }

    /**
     * A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes.
     */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        this.board = new Board(rawValues, score);
        this.maxScore = MAX_PIECE;
        this.gameOver = gameOver;
    }

    /**
     * Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     * 0 <= COL < size(). Returns null if there is no tile there.
     * Used for testing. Should be deprecated and removed.
     */
    public Tile tile(int col, int row) { return board.tile(col, row);
    }

    /**
     * Return the number of squares on one side of the board.
     * Used for testing. Should be deprecated and removed.
     */
=======
    /** Largest piece value. */
    public static final int MAX_PIECE = 2048;

    /** A new 2048 game on a board of size SIZE with no pieces
     *  and score 0. */
    public Model(int size) {
        // TODO: Fill in this constructor.
    }

    /** A new 2048 game where RAWVALUES contain the values of the tiles
     * (0 if null). VALUES is indexed by (row, col) with (0, 0) corresponding
     * to the bottom-left corner. Used for testing purposes. */
    public Model(int[][] rawValues, int score, int maxScore, boolean gameOver) {
        // TODO: Fill in this constructor.
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there.
     *  Used for testing. Should be deprecated and removed.
     *  */
    public Tile tile(int col, int row) {
        return board.tile(col, row);
    }

    /** Return the number of squares on one side of the board.
     *  Used for testing. Should be deprecated and removed. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public int size() {
        return board.size();
    }

<<<<<<< HEAD
    /**
     * Return true iff the game is over (there are no moves, or
     * there is a tile with value 2048 on the board).
     */
=======
    /** Return true iff the game is over (there are no moves, or
     *  there is a tile with value 2048 on the board). */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public boolean gameOver() {
        checkGameOver();
        if (gameOver) {
            maxScore = Math.max(score, maxScore);
        }
        return gameOver;
    }

<<<<<<< HEAD
    /**
     * Return the current score.
     */
=======
    /** Return the current score. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public int score() {
        return score;
    }

<<<<<<< HEAD
    /**
     * Return the current maximum game score (updated at end of game).
     */
=======
    /** Return the current maximum game score (updated at end of game). */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public int maxScore() {
        return maxScore;
    }

<<<<<<< HEAD
    /**
     * Clear the board to empty and reset the score.
     */
=======
    /** Clear the board to empty and reset the score. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public void clear() {
        score = 0;
        gameOver = false;
        board.clear();
        setChanged();
    }

<<<<<<< HEAD
    /**
     * Add TILE to the board. There must be no Tile currently at the
     * same position.
     */
=======
    /** Add TILE to the board. There must be no Tile currently at the
     *  same position. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    public void addTile(Tile tile) {
        board.addTile(tile);
        checkGameOver();
        setChanged();
    }

<<<<<<< HEAD
    /**
     * Tilt the board toward SIDE. Return true iff this changes the board.
     * <p>
     * 1. If two Tile objects are adjacent in the direction of motion and have
     * the same value, they are merged into one Tile of twice the original
     * value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     * tilt. So each move, every tile will only ever be part of at most one
     * merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     * value, then the leading two tiles in the direction of motion merge,
     * and the trailing tile does not.
     */
    public boolean tilt(Side side) {
        boolean changed = false;
        int row_counter;
        Tile new_pos;
        int[][] board_vis = new int[board.size()][board.size()];
        board.setViewingPerspective(side);

        for (int col = 0; col < board.size(); col++) {
            for (int row = board.size() - 1; row >= 0; row--) {
                Tile t = board.tile(col, row);
                row_counter = row + 1;
                if (t != null && row_counter < board.size()) {
                    while (board.tile(col, row_counter) == null && row_counter + 1 < board.size()) {
                        row_counter++;
                    }
                    new_pos = board.tile(col, row_counter);
                    //** If there is a position available in the same column in the the top-most row, then the tile in question moves there.*/
                    if (board.tile(col, row_counter) == null) {
                        board.move(col, row_counter, t);
                    }
                    //** If there is a position available in the same column and a tile in the top-most row has the same value as the tile in question, then
                    // the tile in question moves there.*/
                    else if (new_pos.value() == t.value() && board_vis[col][row_counter] == 0) {
                        board.move(col, row_counter, t);
                        board_vis[col][row_counter] = 1; //To show that tile in board underwent merging
                    } //** If none of the other cases work, the tile in question moves to the top-most empty row in the same column."
                    else {
                        board.move(col, row_counter - 1, t);
                    }
                    changed = true;
                    checkGameOver();
                    if (changed) {
                        setChanged();
                    }
                }
            }
        }
        board.setViewingPerspective(side.NORTH);
        return changed;
    }




    /**
     * Checks if the game is over and sets the gameOver variable
     * appropriately.
=======
    /** Tilt the board toward SIDE. Return true iff this changes the board.
     *
     * 1. If two Tile objects are adjacent in the direction of motion and have
     *    the same value, they are merged into one Tile of twice the original
     *    value and that new value is added to the score instance variable
     * 2. A tile that is the result of a merge will not merge again on that
     *    tilt. So each move, every tile will only ever be part of at most one
     *    merge (perhaps zero).
     * 3. When three adjacent tiles in the direction of motion have the same
     *    value, then the leading two tiles in the direction of motion merge,
     *    and the trailing tile does not.
     * */
    public boolean tilt(Side side) {
        boolean changed;
        changed = false;

        // TODO: Modify this.board (and perhaps this.score) to account
        // for the tilt to the Side SIDE. If the board changed, set the
        // changed local variable to true.

        checkGameOver();
        if (changed) {
            setChanged();
        }
        return changed;
    }

    /** Checks if the game is over and sets the gameOver variable
     *  appropriately.
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
     */
    private void checkGameOver() {
        gameOver = checkGameOver(board);
    }

<<<<<<< HEAD
    /**
     * Determine whether game is over.
     */
=======
    /** Determine whether game is over. */
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    private static boolean checkGameOver(Board b) {
        return maxTileExists(b) || !atLeastOneMoveExists(b);
    }

<<<<<<< HEAD
    /**
     * Returns true if at least one space on the Board is empty.
     * Empty spaces are stored as null.
     */
    public static boolean emptySpaceExists(Board b) {
        for (int col = 0; col < b.size(); col++) {
            for (int row = 0; row < b.size(); row++) {
                if (b.tile(col, row) == null) {
                    return true;
                }
            }
        }
=======
    /** Returns true if at least one space on the Board is empty.
     *  Empty spaces are stored as null.
     * */
    public static boolean emptySpaceExists(Board b) {
        // TODO: Fill in this function.
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        return false;
    }

    /**
     * Returns true if any tile is equal to the maximum valid value.
     * Maximum valid value is given by MAX_PIECE. Note that
     * given a Tile object t, we get its value with t.value().
     */
    public static boolean maxTileExists(Board b) {
<<<<<<< HEAD
        for (int col = 0; col < b.size(); col++) {
            for (int row = 0; row < b.size(); row++) {
                if (b.tile(col, row) != null && b.tile(col, row).value() == MAX_PIECE) {
                    return true;
                }
            }
        }
=======
        // TODO: Fill in this function.
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        return false;
    }

    /**
     * Returns true if there are any valid moves on the board.
     * There are two ways that there can be valid moves:
     * 1. There is at least one empty space on the board.
     * 2. There are two adjacent tiles with the same value.
     */
    public static boolean atLeastOneMoveExists(Board b) {
<<<<<<< HEAD
        for (int col = 0; col < b.size(); col += 1) {
            for (int row = 0; row < b.size(); row += 1) {
                if (b.tile(col, row) == null) {
                    return true;
                } else if (row > 0 && b.tile(col, row).value() == b.tile(col, row - 1).value()) {
                    return true;
                } else if (col > 0 && b.tile(col, row).value() == b.tile(col - 1, row).value()) {
                    return true;
                }
            }
        }
=======
        // TODO: Fill in this function.
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        return false;
    }


<<<<<<< HEAD

=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    @Override
     /** Returns the model as a string, used for debugging. */
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        String over = gameOver() ? "over" : "not over";
        out.format("] %d (max: %d) (game is %s) %n", score(), maxScore(), over);
        return out.toString();
    }

    @Override
    /** Returns whether two models are equal. */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        } else {
            return toString().equals(o.toString());
        }
    }

    @Override
    /** Returns hash code of Model’s string. */
    public int hashCode() {
        return toString().hashCode();
    }
}
