package Kenan;

import java.util.Scanner;

public class TicTacToeKenan {
    /*algorithm of the game
     First of all,i make a 3-dimensional and 3-element matrix array.
     i give the elements numbers from 1 to 9.
     when the player chooses a number, the selected number becomes X
     the computer chooses a random number It becomes O
     if sequential or diagonal is the same, the game is over, otherwise it will reset and repeat.
     */

    public static void main(String[] args) {
        String[][] matrix = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

        Scanner input = new Scanner(System.in);
        boolean controls1 = true;
        boolean controls2 = true;
        boolean controls3 = true;
        String testX = "XXX";
        String testO = "OOO";
        String iteratinoncontroll = "f";
        int count = 0;

        System.out.println("welcome to TickTackToe");
        System.out.println("1. for two people to play ");
        System.out.println("2 to play against the computer");
        int choice = 0;
        while (controls1) {
            choice = enterNummer();
            if (choice == 1 || choice == 2)
                controls1 = false;
            else {
                System.out.println(" Please make one of the two choices");
                controls1 = true;
            }
        }

        while (controls2) {
            //matrix
            showMatrix(matrix);

            boolean istWinner = findWinner(matrix, testX, testO);
            if (istWinner) {
                while (controls3) {
                    count = 0;
                    System.out.println("1. to continue ");
                    System.out.println("2. exit ");
                    int continueOrExit = enterNummer();
                    if (continueOrExit == 1) {
                        iteratinoncontroll = "f";
                        int a = 0;
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                a++;
                                matrix[i][j] = String.valueOf(a);
                            }
                        }
                        showMatrix(matrix);
                        controls3 = false;
                    } else if (continueOrExit == 2) {
                        controls3 = false;
                        controls2 = false;
                        continue;
                    }
                    else {
                        System.out.println(" Please make one of the two choices");
                        controls3 = true;
                    }
                }
            }

//from 1. user
        while (true) {
            int nummer1 = enterNummer();
            String userInput1 = String.valueOf(nummer1);

            if (iteratinoncontroll.contains(userInput1)) {
                System.out.println("please do not select the previously selected number");
                continue;
            } else {
                iteratinoncontroll = iteratinoncontroll + userInput1;
                count++;

                switch (userInput1) {
                    case "1":
                        matrix[0][0] = "X";
                        break;
                    case "2":
                        matrix[0][1] = "X";
                        break;
                    case "3":
                        matrix[0][2] = "X";
                        break;
                    case "4":
                        matrix[1][0] = "X";
                        break;
                    case "5":
                        matrix[1][1] = "X";
                        break;
                    case "6":
                        matrix[1][2] = "X";
                        break;
                    case "7":
                        matrix[2][0] = "X";
                        break;
                    case "8":
                        matrix[2][1] = "X";
                        break;
                    case "9":
                        matrix[2][2] = "X";
                        break;
                    default:
                        System.out.println("you entered wrong number");
                        continue;
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
        //to warn when all numbers are played
        if (count == 9) {
            System.out.println("no Winner !!");
            System.out.println("1. to Continue ");
            System.out.println("2. Exit ");
            int karar = input.nextInt();
            if (karar == 1) {
                iteratinoncontroll = "f";
                int a = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        a++;
                        matrix[i][j] = String.valueOf(a);
                    }
                }
            } else if (karar == 2)
                controls2 = false;
            continue;
        }

//second player
        switch (choice) {
            case 1:
                while (true) {
                    int nummer2 = enterNummer();
                    String userInput2 = String.valueOf(nummer2);
                    if (iteratinoncontroll.contains(userInput2)) {
                        System.out.println("please do not select the previously selected number");
                        continue;
                    } else {
                        iteratinoncontroll = iteratinoncontroll + userInput2;
                        count++;

                        switch (userInput2) {
                            case "1":
                                matrix[0][0] = "O";
                                break;
                            case "2":
                                matrix[0][1] = "O";
                                break;
                            case "3":
                                matrix[0][2] = "O";
                                break;
                            case "4":
                                matrix[1][0] = "O";
                                break;
                            case "5":
                                matrix[1][1] = "O";
                                break;
                            case "6":
                                matrix[1][2] = "O";
                                break;
                            case "7":
                                matrix[2][0] = "O";
                                break;
                            case "8":
                                matrix[2][1] = "O";
                                break;
                            case "9":
                                matrix[2][2] = "O";
                                break;
                            default:
                                System.out.println("you entered wrong number");
                                continue;
                        }
                        break;
                    }
                }
                break;

            //computer
            case 2:
                while (true) {
                    int random = (int) (Math.random() * 9) + 1;
                    String randomtoString = String.valueOf(random);
                    if (iteratinoncontroll.contains(randomtoString))
                        continue;
                    else {
                        iteratinoncontroll = iteratinoncontroll + randomtoString;
                        count++;
                        switch (randomtoString) {
                            case "1":
                                matrix[0][0] = "O";
                                break;
                            case "2":
                                matrix[0][1] = "O";
                                break;
                            case "3":
                                matrix[0][2] = "O";
                                break;
                            case "4":
                                matrix[1][0] = "O";
                                break;
                            case "5":
                                matrix[1][1] = "O";
                                break;
                            case "6":
                                matrix[1][2] = "O";
                                break;
                            case "7":
                                matrix[2][0] = "O";
                                break;
                            case "8":
                                matrix[2][1] = "O";
                                break;
                            case "9":
                                matrix[2][2] = "O";
                                break;
                        }
                        System.out.println("computer has played: ");
                        break;
                    }
                }
                break;
        }

    }
        System.out.println("Thank You!!");
    }

    public static int enterNummer() {
        int nummer = 0;
        System.out.println("enter a nummer");
        boolean control = true;
        while (control) {
            try {
                Scanner input = new Scanner(System.in);
                nummer = input.nextInt();
                control = false;
            } catch (Exception e) {
                System.out.println("please enter a nummer!!");
                control = true;
            }
        }
        return nummer;
    }

    public static boolean findWinner(String[][] master, String testX, String testO) {

        String word1 = master[0][0] + master[0][1] + master[0][2];
        String word2 = master[1][0] + master[1][1] + master[1][2];
        String word3 = master[2][0] + master[2][1] + master[2][2];
        String word4 = master[0][0] + master[1][0] + master[2][0];
        String word5 = master[0][1] + master[1][1] + master[2][1];
        String word6 = master[0][2] + master[1][2] + master[2][2];
        String word7 = master[0][0] + master[1][1] + master[2][2];
        String word8 = master[0][2] + master[1][1] + master[2][0];

        if (testX.equals(word1) || testX.equals(word2) || testX.equals(word3) || testX.equals(word4) || testX.equals(word5) || testX.equals(word6) || testX.equals(word7) || testX.equals(word8)) {
            System.out.println("Winner XXX");
            return true;
        }
        else if (testO.equals(word1) || testO.equals(word2) || testO.equals(word3) || testO.equals(word4) || testO.equals(word5) || testO.equals(word6) || testO.equals(word7) || testO.equals(word8)) {
          System.out.println("Winner OOO");
           return true;
        }
        else
            return false;
    }
    public static void showMatrix(String[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix [i][j] + " ");
            }
            System.out.println();
        }
    }
}

