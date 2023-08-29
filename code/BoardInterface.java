import java.util.ArrayList;

class BoardInterface{
  BoardInterface(char[][] board, int row_size ,int col_size){
    for
    (int i=0;i<row_size;i++)
    {
      for(int j=0;j<col_size;j++)

      {
        if(i!=0 && i!=(row_size-1) && (j==0 || j==(col_size-2)))board[i][j]='|';
        else if
        (j==(col_size-1))board[i][j]='\n';
        else if
        (i==0 || i==(row_size-1))board[i][j]='=';
        else board[i][j]=' ';
      }
    }
  }
  void displayBoard(char[][] board, int row_size ,int col_size)
  {
    for(int i=0;i<row_size;i++)

    {
      for(int j=0;j<col_size;j++)
      {
        System.out.print(board[i][j]);
      }
    }
  }

  void setWord(char[][] board, Word myWord, ArrayList<Word> endList){
    board[myWord.X][myWord.Y]=myWord.character;

    for(int i=0;i<endList.size();i++){
      board[endList.get(i).X][endList.get(i).Y]=endList.get(i).character;
    }
  }
}