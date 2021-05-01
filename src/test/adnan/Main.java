package test.adnan;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        System.out.println();
        System.out.println("Hello TicTacTie Game");
        System.out.println();
        printGameBoard(gameBoard);


        //Set Input
        Scanner scan = new Scanner(System.in);
        System.out.println("لطفا یک مکان از (1-9) را وارد کنید");
        int pos = scan.nextInt();
        System.out.println(pos);

        // برای حالت وارد کردن عدد توسط کاربر
        placePaice(gameBoard, pos, "player");

        // وارد کردن عدد راندوم بین 1 تا 9 توسط سی پی یو
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        placePaice(gameBoard, cpuPos, "cpu");


        printGameBoard(gameBoard);

    }

    // متد نمایش گرافیکی سطر و ستون
    public static void printGameBoard(char[][] gameBoard) {
        // for-each
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // متد وارد کردن عدد و نمایش (X)
    public static void placePaice(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol; // OR gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
//            switch (pos) {
//                case 1 -> gameBoard[0][0] = 'X';
//                case 2 -> gameBoard[0][2] = 'X';
//                case 3 -> gameBoard[0][4] = 'X';
//                case 4 -> gameBoard[2][0] = 'X';
//                case 5 -> gameBoard[2][2] = 'X';
//                case 6 -> gameBoard[2][4] = 'X';
//                case 7 -> gameBoard[4][0] = 'X';
//                case 8 -> gameBoard[4][2] = 'X';
//                case 9 -> gameBoard[4][4] = 'X';
//            }

        }

    }

}
