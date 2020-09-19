/* 
* prints out a simple minesweeper game that can be pasted into disord to play.
* @author jackson
* 
*/

import java.util.Scanner;
public class Main {

   public int x;
   public int y;
   public int numBoom;

    public static void main(String[] args) {   

        //constructors
        Main main = new Main();
        Func tools = new Func();
        Scanner input = new Scanner(System.in);

        //take user input
        do {
          System.out.print("Enter the x and y dementions seperated by a space: ");
          main.y = input.nextInt();
          main.x = input.nextInt();
          input.nextLine();
          System.out.print("Enter the number of mines to use: ");
          String minesStr = input.nextLine();
          main.numBoom = Integer.parseInt(minesStr);
        } while (main.y <= 0 || main.x <= 0  || main.numBoom < 0 || main.y * main.x < main.numBoom);
        
        input.close();

        // check if too big for discord message (maybe put this invalidation loop, with more error messages so user can re-enter)
        if (main.x * main.y > 250) {
          System.out.println("\n !!!too big for discord!!! \n");
        }
        
        
        //create matrix
        String [] [] board = new String[main.x][main.y];
      
        //pad matrix with char s to place hold
        tools.fillBoard(board);
        
        //place the mines randomly
        tools.boom(main.numBoom, board);
        
        //fills the rest of the board with the correctly numbered tiles
        tools.entryFinal(board);
        
        // prints the matrix
        tools.print(board);
      }
}