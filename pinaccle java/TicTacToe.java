import java.util.Scanner;
class Main {
    public static void main(String[] args) 
  {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) 
     {
         for (int col = 0; col < board[row].length; col++) 
      {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameOver) 
    {
      printBoard(board);
      System.out.print("Player " + player + " enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      System.out.println();

      if (board[row][col] == ' ') 
       {
        board[row][col] = player; // place the element
        gameOver = haveWon(board, player);
        if (gameOver) 
         {
          System.out.println("Player " + player + " has won: ");
      } else 
        {
          // if (player == 'X') {
          // player = 'O';
          // } else {
          // player = 'X';
          // }
          player = (player == 'X') ? 'O' : 'X';
        }
    } else 
      {
        System.out.println("Invalid move. Try again!");
      }
    }
    printBoard(board);
  }

  public static boolean haveWon(char[][] board, char player) {
    // check the rows
    for (int row = 0; row < board.length; row++) 
     {
         if (board[row][0] == player && board[row][1] == player && board[row][2] == player) 
       {
        return true;
      }
    }

    // check for col
    for (int col = 0; col < board[0].length; col++) 
     {
         if (board[0][col] == player && board[1][col] == player && board[2][col] == player) 
       {
        return true;
      }
    }

    // diagonal
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) 
    {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) 
    {
      return true;
    }
    return false;
  }

  public static void printBoard(char[][] board) 
   {
       for (int row = 0; row < board.length; row++) 
    {
        for (int col = 0; col < board[row].length; col++) 
      {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }
}






//Pinnacle Labs CODE

 
/*import java.util.Scanner;
public class TicTacToe {
    private char[][] board;
    private Scanner scanner;

    public TicTacToe() {
        this.board = new char[3][3];
        this.scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + this.board[i][j]);
            }
            System.out.println(" |");
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public void playerMove(char icon) {
        int row, col;
        while (true) {
            System.out.println("Player " + icon + "'s turn. Enter row (1-3):");
            row = this.scanner.nextInt() - 1;
            System.out.println("Enter column (1-3):");
            col = this.scanner.nextInt() - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && this.board[row][col] == ' ') {
                this.board[row][col] = icon;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public boolean isVictory(char icon) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (this.board[i][0] == icon && this.board[i][1] == icon && this.board[i][2] == icon) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (this.board[0][i] == icon && this.board[1][i] == icon && this.board[2][i] == icon) {
                return true;
            }
        }
        // Check diagonals
        if ((this.board[0][0] == icon && this.board[1][1] == icon && this.board[2][2] == icon) ||
                (this.board[0][2] == icon && this.board[1][1] == icon && this.board[2][0] == icon)) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() {
        while (true) {
            this.printBoard();
            this.playerMove('X');
            this.printBoard();
            if (this.isVictory('X')) {
                System.out.println("Player X wins! Congratulations!");
                break;
            } else if (this.isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }
            this.playerMove('O');
            if (this.isVictory('O')) {
                this.printBoard();
                System.out.println("Player O wins! Congratulations!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}   //* */