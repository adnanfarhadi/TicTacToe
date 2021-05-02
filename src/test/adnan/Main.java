package test.adnan;

import java.sql.Array;
import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

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


        while (true) {
            //Set Input
            Scanner scan = new Scanner(System.in);
            System.out.println("لطفا یک مکان از (1-9) را وارد کنید");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position taken a correct Position");
                playerPos = scan.nextInt();
            }

            // برای حالت وارد کردن عدد توسط کار
            // بر
            placePaice(gameBoard, playerPos, "player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }


            // وارد کردن عدد راندوم بین 1 تا 9 توسط سی پی یو
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }

            placePaice(gameBoard, cpuPos, "cpu");


            printGameBoard(gameBoard);
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
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
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
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


    public static String checkWinner() {
        //سطر ها
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        //ستون ها
        List<Integer> lefCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        //مورب ها
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        //اضافه کردن لیست های ایجاد شده در شی ایجاد شده برای جستجو کردن موارد
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(lefCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won! :)";
            } else if (cpuPositions.containsAll(l)) {
                return "Cpu win sorry :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Equal";
            }

        }


        return "";
    }

}
