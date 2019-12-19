package org.martin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map;

class Solution37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve1(char[][] board){
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] == '.'){
                    for(int k = 0; k < board.length; k ++){
                        board[i][j] = (char)('1' + k);
                        if(success(board, i, j)){
                            if(solve1(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                        else{
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean success(char[][] board, int row, int col){
        return inRow(board, row, col) && inCol(board, row, col) && inSquar(board, row, col);
    }

    private boolean inRow(char[][] board, int row, int col){
        for(int i = 0; i < board[row].length; i ++){
            if(board[row][i] == board[row][col] && i != col){
                return false;
            }
        }
        return true;
    }

    private boolean inCol(char[][] board, int row, int col){
        for(int i = 0; i < board.length; i ++){
            if(board[i][col] == board[row][col] && i != row){
                return false;
            }
        }
        return true;
    }

    private boolean inSquar(char[][] board, int row, int col){
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for(int i = rowStart; i < rowStart + 3; i ++){
            for(int j = colStart; j < colStart + 3; j ++){
                if(board[i][j] == board[row][col] && i != row && j != col){
                    return false;
                }
            }
        }
        return true;
    }

    private char[][] copyBoard(char[][] board) {
        char[][] tempBoard = new char[board.length][];
        for (int m = 0; m < tempBoard.length; m++) {
            tempBoard[m] = Arrays.copyOf(board[m], board[m].length);
        }
        return tempBoard;
    }

    boolean inited = false;
    char[][] result = null;

    private boolean solve(char[][] board) {
        if(!inited){
            updateAvailiables(board);
            inited = true;
        }
        if (!validSudoku(board)) {
            return false;
        }
        else{
            if(allFound(board)){
                return true;
            }
        }
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '.') {
                        List<Character> availiable = GetAvailiable(board, i, j);
                        if (availiable.size() == 1) {
                            isChange = true;
                            board[i][j] = availiable.get(0);
                            updateAvailiables(board);
                        }
                    }
                }
            }
            if (isChange) {
                updateAvailiables(board);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    List<Character> availiable = GetAvailiable(board, i, j);
                    for (int k = 0; k < availiable.size(); k++) {
                        char[][] tempBoard = copyBoard(board);
                        tempBoard[i][j] = availiable.get(k);
                        updateAvailiables(tempBoard);
                        if (solve(tempBoard)) {
                            copyFromBoard(tempBoard, board);
                            return true;
                        }
                        else{
                            updateAvailiables(board);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void copyFromBoard(char[][] original, char[][] destination){
        for(int i = 0; i < original.length; i ++){
            for(int j = 0; j < original[i].length; j ++){
                destination[i][j] = original[i][j];
            }
        }
    }

    private void print(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 10) {
                    sb.append((int) (board[i][j] + 0) + " ");
                } else {
                    sb.append(board[i][j] + " ");
                }
            }
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
    }

    private boolean allFound(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Character> GetAvailiable(char[][] board, int row, int col) {
        char[] rowAvailiable = availiableRows[row];
        char[] colAvailiable = availiableCols[col];
        int squarN = (row / 3) * 3 + col / 3;
        char[] squarAvailiable = availiableSquars[squarN];
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (int i = 0; i < rowAvailiable.length; i++) {
            table.put(rowAvailiable[i], table.getOrDefault(rowAvailiable[i], 0) + 1);
            table.put(colAvailiable[i], table.getOrDefault(colAvailiable[i], 0) + 1);
            table.put(squarAvailiable[i], table.getOrDefault(squarAvailiable[i], 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> set = table.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = set.iterator();
        List<Character> result = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            if (entry.getKey() != 0 && entry.getValue() == 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    char[][] availiableRows;
    char[][] availiableCols;
    char[][] availiableSquars;

    private void updateAvailiables(char[][] board) {
        int count = board.length;
        availiableCols = new char[count][count];
        availiableRows = new char[count][count];
        availiableSquars = new char[count][count];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                availiableCols[i][j] = (char) (j + '1');
                availiableRows[i][j] = (char) (j + '1');
                availiableSquars[i][j] = (char) (j + '1');
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int squarN = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    int ch = board[i][j] - '1';
                    availiableCols[j][ch] = 0;
                    availiableRows[i][ch] = 0;
                    availiableSquars[squarN][ch] = 0;
                }
            }
        }
    }

    private boolean validSudoku(char[][] board) {
        int count = board.length;
        char[][] row = new char[count][count];
        char[][] col = new char[count][count];
        char[][] squar = new char[count][count];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                row[i][j] = (char) (j + '1');
                col[i][j] = (char) (j + '1');
                squar[i][j] = (char) (j + '1');
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int squarN = (i / 3) * 3 + j / 3;
                if (board[i][j] != '.') {
                    int ch = board[i][j] - '1';
                    if (row[i][ch] > 0)
                        row[i][ch] = 0;
                    else
                        return false;
                    if (col[j][ch] > 0)
                        col[j][ch] = 0;
                    else
                        return false;
                    if (squar[squarN][ch] > 0)
                        squar[squarN][ch] = 0;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}