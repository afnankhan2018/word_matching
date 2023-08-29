import java.util.ArrayList;
import java.util.Scanner;

class WordMatching{

  static int row=30;
  static int col=50;
  static int score = 0;
  static char[][] board=new char[row][col];
  static char[] alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M','N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  static String removeSpace="";


  public static void main(String[] args){
    
    WordMatching wordMatchingGame=new WordMatching();
    PseudoRandom myRandom = new PseudoRandom(System.currentTimeMillis());
    Scanner scanner=new Scanner(System.in);
    BoardInterface myBoard= new BoardInterface(board, row, col);

    char randomWord = alphabets[myRandom.generateRandomNumber(0, alphabets.length-1)];
    Word myWord = new Word(randomWord, 1, myRandom.generateRandomNumber(1, col-3));
    ArrayList<Word> endList=new ArrayList<Word>();

    while(true){
      myBoard.setWord(board, myWord, endList);
      myBoard.displayBoard(board, row, col);

      System.out.println("Your Score: "+score);
      System.out.print("Enter Your Movement: ");
      String movement=scanner.next();

      board[myWord.X][myWord.Y]=' ';
      if(movement.equals("L") && myWord.Y>1 && myWord.Y<col-1 && board[myWord.X+1][myWord.Y-1]==' '){
        myWord.Y=myWord.Y-1;
      }else if(movement.equals("R") && myWord.Y>=1 && myWord.Y<col-3 && board[myWord.X+1][myWord.Y+1]==' '){
        myWord.Y=myWord.Y+1;
      }else if(movement.equals("D") && board[myWord.X+1][myWord.Y]==' '){
        myWord.X++;
      }
      else{
        System.out.println("Invalid Movement");
      }

      if(myWord.X!=row-2 && board[myWord.X+1][myWord.Y]==' '){
        myWord.X++;
      }else{
        endList.add(myWord);
        randomWord = alphabets[myRandom.generateRandomNumber(0, alphabets.length-1)];
        myWord = new Word(randomWord, 1, myRandom.generateRandomNumber(1, col-3));
      }

      
      myWord.findMatch(wordMatchingGame, row, col, endList);


      if(removeSpace.length()==col-3){
        System.out.println("Game Oveor");
        break;
      }
    }
  }
}