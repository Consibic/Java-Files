/*
 * TicTacToe.java
 * Constantine
 * Feb.7, 2015
 */
package programmingactivities10;

import java.util.*;
/**
 *
 * @author 程博洋
 */
public class TicTacToe {
    
    public static boolean checkRow(String[][] base, int rowNum) {
        for (int i = 0; i < base.length - 1; i++) {
            if (base[i][rowNum] != base[i + 1][rowNum] || base[i][rowNum] == null) {
                return false;
            }
        }return true;
    }
    public static boolean checkColumn(String[][] base, int columnNum) {
        for (int i = 0; i < base[0].length - 1; i++) {
            if (base[columnNum][i] != base[columnNum][i + 1] || base[columnNum][i] == null) {
                return false;
            }
        }return true;
    }
    public static boolean checkSlope(String[][]base, String XO) {
        for (int i = 0; i < base[0].length - 1; i++) {
            if (base[0][0] == base[1][1] && base[1][1] == base[2][2] && base[0][0] == XO) {
                return true;
            } else if (base[0][2] == base[1][1] && base[1][1] == base[2][0] && base[0][2] == XO) {
                return true;
            } else {
                return false;
            }
        } return false;
    }
    public static boolean check(String[][] base) {
        for (int i = 0; i < base.length; i++) {
            if (checkRow(base, i) == true || checkColumn(base, i) == true) {
                return true;
            }
            if (checkSlope(base, "X") == true) {
                return true;
            } else if (checkSlope(base, "O") == true) {
                System.out.println("Winner is O");
                return true;
            }
        }return false;
    }
    public static void change(String[][] base) {
        for (int i = 0; i < base.length; i++) {
            for (int a = 0; a < base[0].length; a++) {
                if (base[a][i] == null) {
                    System.out.print("[ ]");
                } else if (base[a][i] == "X") {
                    System.out.print("[X]");
                } else {
                    System.out.print("[O]");
                }
            } System.out.print("\n");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] base = new String[3][3];
        Scanner sc = new Scanner(System.in);
        int row, column;
        change(base);
        do {
            do {
                System.out.print("Enter row number: ");
                row = sc.nextInt();
                System.out.print("Enter column number: ");
                column = sc.nextInt();
            } while (base[row][column] != null);
            base[row][column] = "X";
            change(base);
            if (check(base) == true) {
                System.out.println("Winner is X");
                break;
            }
            do {
                System.out.print("Enter row number: ");
                row = sc.nextInt();
                System.out.print("Enter column number: ");
                column = sc.nextInt();
            } while (base[row][column] != null);
            base[row][column] = "O";
            change(base);
            if (check(base) == true) {
                System.out.println("Winner is O");
                break;
            }
        } while (check(base) == false);
    }
}
