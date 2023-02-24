package com.heshan.elicense;


import java.util.Scanner;

public class TicTacToe {



    public static void main(String[] args) {
        System.out.println("Let's play tic-tac-toe");
        // 构建一个3*3的二维数组(初始棋盘）
        char[][] checkerboard = new char[3][3];
        Scanner in = new Scanner(System.in);
        System.out.println("Who want to first?(please enter player1 or player2)");
        String first = in.next();
        if ("player1".equals(first)) {
            int round = 1;
            boolean judge = false;
            while (judge == false) {
                if (round % 2 == 1) {
                    checkerboard = play1(checkerboard);
                    print(checkerboard);
                    if (judge(checkerboard) == true) {
                        break;
                    }
                    round++;
                } else {
                    checkerboard = play2(checkerboard);
                    print(checkerboard);
                    if (judge(checkerboard) == true) {
                        break;
                    }
                    round++;
                }
            }
        } else {
            int round = 2;
            boolean judge = false;
            while (judge == false) {
                if (round % 2 == 1) {
                    checkerboard = play1(checkerboard);
                    print(checkerboard);
                    if (judge(checkerboard) == true) {
                        break;
                    }
                    round++;
                } else {
                    checkerboard = play2(checkerboard);
                    print(checkerboard);
                    if (judge(checkerboard) == true) {
                        break;
                    }
                    round++;
                }
            }
        }
    }

    // 方法print()用于打印操作后的棋盘格
    public static void print(char[][] checkerboard) {
        System.out.println("-------------");
        for (int i = 0; i <= 2; i++) {
            System.out.print("|");
            for (int j = 0; j <= 2; j++) {
                if (checkerboard[i][j] == 'X' || checkerboard[i][j] == 'O') {
                    System.out.print(" " + checkerboard[i][j] + " ");
                    System.out.print("|");
                } else {
                    System.out.print("   ");
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // 方法play1用于处理用户1输入的选择，此处设置用户1的棋子为字符'X'
    public static char[][] play1(char[][] checkerboard) {
        Scanner in = new Scanner(System.in);
        System.out.print("Player1's move?(Enter the number of rows and columns, separated by spaces.)");
        int line = in.nextInt();
        int row = in.nextInt();
        while (deal(line, row, checkerboard) == false) {
            System.out.print("Player1's move?(Enter the number of rows and columns, separated by spaces.)");
            line = in.nextInt();
            row = in.nextInt();
        }
        checkerboard[line - 1][row - 1] = 'X';
        return checkerboard;
    }

    // 方法play2用于处理用户1输入的选择，此处设置用户1的棋子为字符'O'
    public static char[][] play2(char[][] checkerboard) {
        Scanner in = new Scanner(System.in);
        System.out.print("Player2's move?(Enter the number of rows and columns, separated by spaces.)");
        int line = in.nextInt();
        int row = in.nextInt();
        while (deal(line, row, checkerboard) == false) {
            System.out.print("Player2's move?(Enter the number of rows and columns, separated by spaces.)");
            line = in.nextInt();
            row = in.nextInt();
        }
        checkerboard[line - 1][row - 1] = 'O';
        return checkerboard;
    }

    // 方法deal用于处理用户的输入，检测输入是否有效
    public static boolean deal(int line, int row, char[][] checkerboard) {
        if (line == 0 || line > 3 || row == 0 || row > 3) {  // 输入行列数不在范围内的情况
            System.out.println("Please enter a valid number of rows and columns.");
            return false;
        } else if (checkerboard[line - 1][row - 1] == 'X' || checkerboard[line - 1][row - 1] == 'O') {  // 输入位置已有棋子的情况
            System.out.println("There is already a piece, please re-enter your choice.");
            return false;
        } else {
            return true;
        }
    }

    // 方法judge用于判断是否有三个棋子连成一行
    public static boolean judge(char[][] checkerboard) {
        // 判断一行上是否有棋子相连
        for (int i = 0; i <= 2; i++) {
            int continuity_x = 0;
            int continuity_o = 0;
            for (int j = 0; j <= 2; j++) {
                if (checkerboard[i][j] == 'X') {
                    continuity_x++;
                } else if (checkerboard[i][j] == 'O') {
                    continuity_o++;
                }
            }
            if (continuity_x == 3) {
                System.out.println("Player1 wins!");
                return true;
            } else if (continuity_o == 3) {
                System.out.println("Player2 wins!");
                return true;
            }
        }
        // 判断一列上是否有棋子相连
        for (int j = 0; j <= 2; j++) {
            int continuity_x = 0;
            int continuity_o = 0;
            for (int i = 0; i <= 2; i++) {
                if (checkerboard[i][j] == 'X') {
                    continuity_x++;
                } else if (checkerboard[i][j] == 'O') {
                    continuity_o++;
                }
            }
            if (continuity_x == 3) {
                System.out.println("Player1 wins!");
                return true;
            } else if (continuity_o == 3) {
                System.out.println("Player2 wins!");
                return true;
            }
        }

        // 判断对角线上是否有棋子相连
        if (checkerboard[0][0] == 'X' & checkerboard[1][1] == 'X' & checkerboard[2][2] == 'X') {
            System.out.println("Player1 wins!");
            return true;
        } else if (checkerboard[0][0] == 'O' & checkerboard[1][1] == 'O' & checkerboard[2][2] == 'O') {
            System.out.println("Player2 wins!");
            return true;
        }
        return false;
    }
}