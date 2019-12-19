package org.martin;

class Test37 implements ITest{

    @Override
    public void run() {
        Solution37 solution37 = new Solution37();
        char[][] board = {{'.','.','.','2','.','.','.','6','3'},{'3','.','.','.','.','5','4','.','1'},{'.','.','1','.','.','3','9','8','.'},{'.','.','.','.','.','.','.','9','.'},{'.','.','.','5','3','8','.','.','.'},{'.','3','.','.','.','.','.','.','.'},{'.','2','6','3','.','.','5','.','.'},{'5','.','3','7','.','.','.','.','8'},{'4','7','.','.','.','1','.','.','.'}};
        solution37.solveSudoku(board);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] < 10){
                    board[i][j] += '0';
                }
                sb.append(board[i][j] + " ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
    }

}