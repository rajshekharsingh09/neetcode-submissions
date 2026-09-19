class Solution {
    public boolean isValidSudoku(char[][] board) {
      for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(!noDuplicate(board,true,i)){
                return false;
            }
            if(!noDuplicate(board,false,j)){
                return false;
            }
            int boxStartRow = (i/3)*3;
            int boxStartCol = (j/3)*3;
            int boxEndRow = (i/3 +1)*3;
            int boxEndCol = (j/3+1)*3;

            Map<Character,Boolean> mp = new HashMap<>();
            for(int l=boxStartRow;l<boxEndRow;l++){
                for(int m=boxStartCol;m<boxEndCol;m++){
                    if(mp.containsKey(board[l][m])){
                        return false;
                    }
                    if(board[l][m]!='.'){
                        mp.put(board[l][m],true);
                    }
                    
                }
            }
        }
      }
      return true;
    }

    private boolean noDuplicate(char[][] board,boolean isRow,int number){
        if(isRow){
            Map<Character,Boolean> mp = new HashMap<>();
            for(int i=0;i<9;i++){
                if(mp.containsKey(board[number][i])){
                    return false;
                }
                if(board[number][i]!='.'){
                        mp.put(board[number][i],true);
                    }
            }
        }else{
            Map<Character,Boolean> mp = new HashMap<>();
            for(int i=0;i<9;i++){
                if(mp.containsKey(board[i][number])){
                    return false;
                }
                                    if(board[i][number]!='.'){
                        mp.put(board[i][number],true);
                    }
            }
        }
        return true;
    }
}
