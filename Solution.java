import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[][] positions = {{1,0}, {-1,0}, {0,-1}, {0,1}};

    public static boolean isOnBoard(int i, int j, int rows, int cols) {
      return i >= 0 && j >= 0 && i < rows && j < cols;
    }

    public static List<List<Integer>> findLegalMoves(int[][] board, int[] move) {
        List<List<Integer>> legalMoves = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0] + move[0];
            int col = positions[i][1] + move[1];
            if (isOnBoard(row, col, board.length, board[0].length) && board[row][col] != -1) {
                legalMoves.add(Arrays.asList(row, col));
            }
        }
        return legalMoves;
    }

    public static void dfs(int[][] board, boolean[][] visited, int i, int j) {
        if (isOnBoard(i, j, board.length, board[0].length) && !visited[i][j] && board[i][j] == 0) {
            visited[i][j] = true;
            for (int pos = 0; pos < positions.length; pos++) {
                dfs(board, visited, positions[pos][0] + i, positions[pos][1] + j);
            }
        }
    }

    public static boolean isReachable(int[][] board, int[] end) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        dfs(board, visited, end[0], end[1]);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*

        Given a board and an end position for the player, write a function to determine if it is
        possible to travel from every open cell on the board to the given end position.

        Expected output:

        isReachable(board1, end1) -> True
        isReachable(board1, end2) -> True
        isReachable(board2, end1) -> False
        isReachable(board2, end2) -> False
        isReachable(board3, end1) -> False
        isReachable(board4, end1) -> True
        isReachable(board5, end1) -> True

        n: width of the input board
        m: height of the input board

        Danielle
        15/20?

        Mike
        Communication = 5/5
        Problem-Solving = 5/5
        Syntax = 4/5
        Verification = 3/5

        */
        int[][] board1 = {
            { 0,  0,  0, 0, -1 },
            { 0, -1, -1, 0,  0 },
            { 0,  0,  0, 0,  0 },
            { 0, -1,  0, 0,  0 },
            { 0,  0,  0, 0,  0 },
            { 0,  0,  0, 0,  0 },
        };

        int[][] board2 = {
            {  0,  0,  0, 0, -1 },
            {  0, -1, -1, 0,  0 },
            {  0,  0,  0, 0,  0 },
            { -1, -1,  0, 0,  0 },
            {  0, -1,  0, 0,  0 },
            {  0, -1,  0, 0,  0 },
        };

        int[][] board3 = {
            { 0,  0,  0,  0,  0,  0, 0 },
            { 0, -1, -1, -1, -1, -1, 0 },
            { 0, -1,  0,  0,  0, -1, 0 },
            { 0, -1,  0,  0,  0, -1, 0 },
            { 0, -1,  0,  0,  0, -1, 0 },
            { 0, -1, -1, -1, -1, -1, 0 },
            { 0,  0,  0,  0,  0,  0, 0 },
        };

        int[][] board4 = {
            {0,  0,  0,  0, 0},
            {0, -1, -1, -1, 0},
            {0, -1, -1, -1, 0},
            {0, -1, -1, -1, 0},
            {0,  0,  0,  0, 0},
        };

        int[][] board5 = {
            {0}
        };

        int[][] board6 = {
            {0,  0, -1,  0, 0},
            {0,  0, -1,  0, 0},
            {0,  0, -1,  0, 0},
            {0,  0, -1,  0, 0},
            {0,  0, -1,  0, 0},
            {0,  0, -1,  0, 0}
        };

        int[][] board = new int[][] {
            { 0,  0,  0, -1, -1},
            { 0,  0, -1,  0,  0},
            { 0, -1,  0, -1,  0},
            { 0,  0, -1,  0,  0},
            { 0,  0,  0,  0,  0},
            { 0,  0,  0,  0,  0},
            { 0,  0,  0,  0,  0}
        };

        int[] position = new int[] {1,1};

        int[] end1 = new int[] {0, 0};
        int[] end2 = new int[] {5, 0};

        System.out.println("FIND LEGAL MOVES");
        System.out.println(findLegalMoves(board, new int[] {1,1}));
        System.out.println(findLegalMoves(board, new int[] {5,3}));
        System.out.println(findLegalMoves(board, new int[] {5,1}));
        System.out.println(findLegalMoves(board, new int[] {6,0}));
        System.out.println(findLegalMoves(board, new int[] {6,4}));
        System.out.println(findLegalMoves(board, new int[] {0,0}));
        System.out.println(findLegalMoves(board, new int[] {2,2}));
        System.out.println(findLegalMoves(board, new int[] {1,4}));

        System.out.println("IS REACHABLE");
        System.out.println(isReachable(board1, end1)); // true
        System.out.println(isReachable(board1, end2)); // true
        System.out.println(isReachable(board2, end1)); // false
        System.out.println(isReachable(board2, end2)); // false
        System.out.println(isReachable(board3, end1)); // false
        System.out.println(isReachable(board3, end2)); // false
        System.out.println(isReachable(board4, end1)); // true
        System.out.println(isReachable(board4, end2)); // false
        System.out.println(isReachable(board5, end1)); // true
        System.out.println(isReachable(board5, end2)); // false
        System.out.println(isReachable(board6, end1)); // false
        System.out.println(isReachable(board6, end2)); // false
   }
}
