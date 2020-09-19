/* 
* prints out a simple minesweeper game that can be pasted into disord to play.
* @author jackson
*
*/

  //import java.util.Arrays;  // for the test array printing method 
class Func extends Main {

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

  
      public String entry(int count) {   // selects the emoji to put in a tile based on an integer parameter passed

      switch (count) {
        case 0: 
          return zero ;
        case 1:
          return one ;
        case 2:
          return two ;
        case 3:
          return three ;
        case 4:
          return four ;
        case 5:
          return five;
        case 6:
          return six;
        default:
            return "invalid call number";
        }
      } 

    public String[][] boom(int numBoom, String[][] board) {  // randomly places mines in the matrix.  The number of which is passed to it

        this.x = board.length;
        this.y = board[0].length;
        int count = 0;

        //picks random entries and puts boom in until it has reached the number passed
       while (count < numBoom) {
          board[rand(this.x -1)][rand(this.y -1)] = boom;
          count++;
          }

          return board;
      }

      public String[][] fillBoard(String[][] board) {
       
        //fills the board with the letter 's' as a space filler to make reading it easier
        for (x = 0; x < board.length; x++) {
          for (y = 0; y < board[x].length; y++) {
              board [x][y] = "s";
          }
        }
        return board;
    }

     public void print(String[][] board) {
      
      /*/debuging, prints the matrix one row at the time (dont forget to uncomment the inport for arrays on line 8)
      for (String[] row : board) {
          System.out.println(Arrays.toString(row)); 
        }  */

        //pulls enteries out of matrix and concats into strings representing each line
        for (this.y = 0; this.y < board[0].length; this.y++) { // walks through the rows
          String row = "";

          for (this.x = 0; this.x < board.length; this.x++) { // steps through each entry in row
            row += start + board[this.x][this.y] + stop ;     // concats and adds the pipes for the spoiler 
          }
          
          System.out.println(row); // prints each line out after being concated
      } 

      
        
  }

  public int rand(int maxR) {      //generates random number that is less than or equal to the input. 
    int rand = 1000;
    //int count = 0;
    while (rand > maxR) { 
      double randBig = (Math.random()*maxR);
      rand = (int)randBig;
      //count = count + 1 ;
    }
     //System.out.println("this is how many rounds it took to get the rand equal or under " + maxR + ": " + count); 
     // System.out.println(rand); //prints the random number
    return rand;
   }

   public String[][] entryFinal(String[][] board) {
    //finds the size of the matrix
    this.x = board.length;
    this.y = board[0].length;
    
    //iterator  (it goes top to bottom on each x before advancing, need to change that sometime)
    for (this.x = 0; this.x < board.length; this.x++) {
      for (this.y = 0; this.y < board[this.x].length; this.y++) {

        //checks to see if current entry is boom or not
        if (!(board[this.x][this.y]).equals(boom)) {
          int count = 0;

          //check if the tile above or below is the boom
          if (this.y > 0){ //makes sure its not going to call out of bounds
            if ((board[this.x][this.y-1]).equals(boom)) count++;} 

          if (this.y < board[0].length -1) {
            if ((board[this.x][this.y+1]).equals(boom)) count++;} 
            
          //----------------------------------------------------------

            //checks if the tiles right or left are the boom
            if (this.x < board.length -1) {
              if ((board[this.x+1][this.y]).equals(boom)) count++;}
            
            if (this.x > 0) {
              if ((board[this.x-1][this.y]).equals(boom)) count++;}

          //----------------------------------------------------------
              
              // check if its on diaginals

              //bottom left and right
            if (this.x > 0 && this.y < board[0].length -1 ) {
              if ((board[this.x -1][this.y +1].equals(boom))) {count++;}}

            if (this.y < board[0].length -1 && this.x < board.length -1) {
              if ((board[this.x +1][this.y +1]).equals(boom)) {count++;}}

              //top left and right

            if (this.y > 0 && this.x > 0 ) {
              if ((board[this.x -1][this.y -1].equals(boom))) {count++;}}

            if (this.x < board.length -1 && this.y > 0 ) {
              if ((board[this.x +1][this.y -1].equals(boom))) {count++;}}

          //sets the current tile to the apropreate number emoji based on the counter of boombs seen
          board[this.x][this.y] = entry(count);
        }

      }
    }

    return board;
   }

}
