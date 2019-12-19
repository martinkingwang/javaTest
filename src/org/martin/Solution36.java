package org.martin;

class Solution36{
    public boolean isValidSudoku(char[][] board) {
        print(board);
        int count = board.length;
        char[][] row = new char[count][count];
        char[][] col = new char[count][count];
        char[][] squar = new char[count][count];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board.length; j ++){
                row[i][j] = (char)(j + '1');
                col[i][j] = (char)(j + '1');
                squar[i][j] = (char)(j + '1');
            }
        }
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                int squarN = (i / 3) * 3 + j / 3;
                if(board[i][j] != '.'){
                    int ch = board[i][j] - '1';
                    if(row[i][ch] > 0)
                        row[i][ch] = 0;
                    else
                        return false;
                    if(col[j][ch] > 0)
                        col[j][ch] = 0;
                    else
                        return false;
                    if(squar[squarN][ch] > 0)
                        squar[squarN][ch] = 0;
                    else
                        return false;
                }
            }
        }
        return true;
    }

    private void print(char[][] board){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] < 10){
                    sb.append((int)(board[i][j] + 0) + " ");
                }
                else{
                    sb.append(board[i][j] + " ");
                }
            }
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
    }
}