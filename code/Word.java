import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Iterator;

class Word{
  char character;
  int X,Y;
  Word(char character, int X, int Y){
    this.character = character;
    this.X = X;
    this.Y = Y;
  }

      @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Word other = (Word) obj;
        return character == other.character && X == other.X && Y == other.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, X, Y);
    }

  void findMatch(WordMatching wordMatchingGame, int row, int col, ArrayList<Word> endList){
    String lastString="";
    for(int i=1;i<col-2;i++){
      lastString=lastString+wordMatchingGame.board[row-2][i];
    }
    
    int foundIndex=-1;
    String word="";
    try (BufferedReader reader = new BufferedReader(new FileReader("word.txt"))) {
      while ((word = reader.readLine()) != null) {
        if(lastString.indexOf(word)>0){
          foundIndex=lastString.indexOf(word);
          break;
        }
      }        
    } catch (IOException e) {
      e.printStackTrace();
    }

    if(foundIndex>0){    
      // System.out.println(foundIndex+" "+word.length()+" "+endList.size());
      for(int i=foundIndex+1;i<=foundIndex+word.length();i++){

        char charToRemove = wordMatchingGame.board[row-2][i];
        int rowToRemove = row-2;
        int colToRemove = i;

        Iterator<Word> iterator = endList.iterator();
        while (iterator.hasNext()) {
            Word myWord = iterator.next();
            if (myWord.character == charToRemove && myWord.X == rowToRemove && myWord.Y == colToRemove) {
                iterator.remove();
                WordMatching.score++;
            }
        }

        wordMatchingGame.board[row-2][i] = ' ';
      }
    }


  }
  
}