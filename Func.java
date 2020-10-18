/**
 * prints out a simple minesweeper game that can be pasted into disord to play.
 * 
 * @author
 *
 */

// import java.util.Arrays; // for the test array printing method
class Func {

  final String start = "||";
  final String stop = "||";
  final String zero = ":zero:";
  final String one = ":one:";
  final String two = ":two:";
  final String three = ":three:";
  final String four = ":four:";
  final String five = ":five:";
  final String six = ":six:";
  final String boom = ":boom:";

  /** selects the emoji to put in a tile based on an integer parameter passed */
  public String entry(int count) {

    switch (count) {
      case 0:
        return zero;
      case 1:
        return one;
      case 2:
        return two;
      case 3:
        return three;
      case 4:
        return four;
      case 5:
        return five;
      case 6:
        return six;
      default:
        return "invalid call number";
    }
  }

  /** randomly places mines in the matrix. The number of which is passed to it */
  public String[][] boom(int numBoom, String[][] board) {

    int x = board.length;
    int y = board[0].length;
    int count = 0;

    // picks random entries and puts boom in until it has reached the number passed
    while (count < numBoom) {
      board[rand(x - 1)][rand(y - 1)] = boom;
      count++;
    }

    return board;
  }

  /**
   * fills the board with the letter 's' as a space filler to make reading it
   * easier
   */
  public String[][] fillBoard(String[][] board) {

    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        board[x][y] = "s";
      }
    }
    return board;
  }

  /**
   * pulls enteries out of matrix and concats into strings representing each line
   */
  public void print(String[][] board) {

    /*
     * /debuging, prints the matrix one row at the time (dont forget to uncomment
     * the inport for arrays on line 8) for (String[] row : board) {
     * System.out.println(Arrays.toString(row)); }
     */

    for (int y = 0; y < board[0].length; y++) { // walks through the rows
      String row = "";

      for (int x = 0; x < board.length; x++) { // steps through each entry in row
        row += start + board[x][y] + stop; // concats and adds the pipes for the spoiler
      }

      System.out.println(row); // prints each line out after being concated
    }

  }

  /** generates random number that is less than or equal to the input. */
  public int rand(int maxR) {
    int rand = 1000;
    // int count = 0;
    while (rand > maxR) {
      double randBig = (Math.random() * maxR);
      rand = (int) randBig;
      // count = count + 1 ;
    }
    // System.out.println("this is how many rounds it took to get the rand equal or
    // under " + maxR + ": " + count);
    // System.out.println(rand); //prints the random number
    return rand;
  }

  /**
   * makes the final board, selecting which number goes in each tile based of the
   * booms
   */
  public String[][] entryFinal(String[][] board) {
    // finds the size of the matrix
    int x = board.length;
    int y = board[0].length;

    // iterator (it goes top to bottom on each x before advancing, need to change
    // that sometime)
    for (x = 0; x < board.length; x++) {
      for (y = 0; y < board[x].length; y++) {

        // checks to see if current entry is boom or not
        if (!(board[x][y]).equals(boom)) {
          int count = 0;

          // check if the tile above or below is the boom
          if (y > 0) { // makes sure its not going to call out of bounds
            if ((board[x][y - 1]).equals(boom))
              count++;
          }

          if (y < board[0].length - 1) {
            if ((board[x][y + 1]).equals(boom))
              count++;
          }

          // ----------------------------------------------------------

          // checks if the tiles right or left are the boom
          if (x < board.length - 1) {
            if ((board[x + 1][y]).equals(boom))
              count++;
          }

          if (x > 0) {
            if ((board[x - 1][y]).equals(boom))
              count++;
          }

          // ----------------------------------------------------------

          // check if its on diaginals

          // bottom left and right
          if (x > 0 && y < board[0].length - 1) {
            if ((board[x - 1][y + 1].equals(boom))) {
              count++;
            }
          }

          if (y < board[0].length - 1 && x < board.length - 1) {
            if ((board[x + 1][y + 1]).equals(boom)) {
              count++;
            }
          }

          // top left and right

          if (y > 0 && x > 0) {
            if ((board[x - 1][y - 1].equals(boom))) {
              count++;
            }
          }

          if (x < board.length - 1 && y > 0) {
            if ((board[x + 1][y - 1].equals(boom))) {
              count++;
            }
          }

          /**
           * sets the current tile to the apropreate number emoji based on the counter of
           * boombs seen
           */
          board[x][y] = entry(count);
        }

      }
    }

    return board;
  }

}
