package chess.util;

import chess.piece.Piece;

public class MatrixUtil {

    public static <T> void rotateLeft(T[][] mat) {
        int n = mat.length;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                T temp = mat[x][y];
                int i = n - 1 - x;
                int j = n - 1 - y;
                mat[x][y] = mat[y][i];
                mat[y][i] = mat[i][j];
                mat[i][j] = mat[j][x];
                mat[j][x] = temp;
            }
        }
    }

    public static Piece[][] copyBoard(Piece[][] board) {
        int n = board.length;
        Piece[][] result = new Piece[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(board[i], 0, result[i], 0, n);
        return result;
    }

    public static <T> void rotateRight(T[][] mat) {
        int n = mat.length;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int i = n - 1 - x;
                int j = n - 1 - y;
                T temp = mat[j][x];
                mat[j][x] = mat[i][j];
                mat[i][j] = mat[y][i];
                mat[y][i] = mat[x][y];
                mat[x][y] = temp;
            }
        }
    }

    public static <T> void rotate180(T[][] mat) {
        int n = mat.length;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int i = n - 1 - x;
                int j = n - 1 - y;
                T temp1 = mat[j][x];
                mat[j][x] = mat[y][i];
                mat[y][i] = temp1;

                T temp2 = mat[i][j];
                mat[i][j] = mat[x][y];
                mat[x][y] = temp2;
            }
        }
    }

    public static <T> void transpose(T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                T temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static <T> void display(T[][] mat) {
        for (T[] ts : mat) {
            for (T t : ts)
                System.out.print(" " + t);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
