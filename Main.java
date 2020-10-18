/**
* prints out a simple minesweeper game that can be pasted into disord to play.
* @author
* 
*/

import java.util.Scanner;
public class Main {


    public static void main(String[] args) {   

        //constructors and variables
        Func tools = new Func();
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int numBoom;

        //take user input
        do {
          System.out.print("Enter the x and y dementions seperated by a space: ");
          y = input.nextInt();
          x = input.nextInt();
          input.nextLine();
          System.out.print("Enter the number of mines to use: ");
          String minesStr = input.nextLine();
          numBoom = Integer.parseInt(minesStr);
        } while (y <= 0 || x <= 0  || numBoom < 0 || y * x < numBoom);
        
        input.close();

        // check if too big for discord message (maybe put this invalidation loop, with more error messages so user can re-enter)
        if (x * y > 250) {
          System.out.println();
          System.out.println(" !!!too big for discord!!! ");
          System.out.println();
        }
        
        
        //create matrix
        String [] [] board = new String[x][y];
      
        //pad matrix with char s to place hold
        tools.fillBoard(board);
        
        //place the mines randomly
        tools.boom(numBoom, board);
        
        //fills the rest of the board with the correctly numbered tiles
        tools.entryFinal(board);
        
        // prints the matrix
        tools.print(board);
      }
}