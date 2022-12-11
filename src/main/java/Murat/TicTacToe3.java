package Murat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

public class TicTacToe3 {
    public static void main(String[] args) {
        // create a key to close when the game is over
        while (true) {
            Scanner scan=new Scanner(System.in);
            printMenu();
            String choose=scan.nextLine();
            if(choose.equals("1")){
                start();
            }else if(choose.equals("0")){
                break;
            }else{
                System.out.println("Please press 1 or 0 !");
                System.out.println("");
            }
        }

    }

    public static void printGameBoard(char[][] gameBoard) {
        // We shape the game board within the character list.
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static String user(int number) {
        // this method determines and changes the order of the players.
        if (number % 2 == 0) return "player";
        else {
            userCPU();
        }
        return "cpu";
    }

    public static String userCPU() {
        //The numbers chosen by the computer should be random,
        //and not from the previously selected ones,
        //so we are choosing the random number here.
        //Checks are made in the main block.
        // If a previously selected number is selected,
        //this method works again and return Strig ..

        Random random = new Random();
        int number = random.nextInt(9) + 1;
        return String.valueOf(number);
    }

    public static int winnerCheck(List l) {
        // method returns int. we use this to check if the player has won.
        // method returns 2 if the player wins. Returns 1 if not
        // As a parameter, the list of numbers that the player has written before is given.
        // The method will check the numbers in this list with the winning numbers in it.
        // If there is a match, method will return 2.

        int win = 1;

        //Winning numbers are listed as a lists.
        List list1 = Arrays.asList("1", "2", "3");
        List list2 = Arrays.asList("4", "5", "6");
        List list3 = Arrays.asList("7", "8", "9");
        List list4 = Arrays.asList("1", "4", "7");
        List list5 = Arrays.asList("2", "5", "8");
        List list6 = Arrays.asList("3", "6", "9");
        List list7 = Arrays.asList("1", "5", "9");
        List list8 = Arrays.asList("3", "5", "7");
        List list9 = Arrays.asList("3", "2", "1");
        List list10 = Arrays.asList("6", "5", "4");
        List list11 = Arrays.asList("9", "8", "7");
        List list12 = Arrays.asList("7", "4", "1");
        List list13 = Arrays.asList("8", "5", "2");
        List list14 = Arrays.asList("9", "6", "3");
        List list15 = Arrays.asList("9", "5", "1");
        List list16 = Arrays.asList("7", "5", "3");

        // all lists are imported into one big list. so all lists can be checked with a single code block.
        List<List> winner = new ArrayList<List>();
        winner.add(list1);
        winner.add(list2);
        winner.add(list3);
        winner.add(list4);
        winner.add(list5);
        winner.add(list6);
        winner.add(list7);
        winner.add(list8);
        winner.add(list9);
        winner.add(list10);
        winner.add(list11);
        winner.add(list12);
        winner.add(list13);
        winner.add(list14);
        winner.add(list15);
        winner.add(list16);

        // Checking if the player's list is in the big list.
        for (List k : winner) {
            if (l.containsAll(k)) {

                win = 2;
                break;
            }
        }
        return win;
    }

    public static void izolated(char[][] gameBoard, String text, String user) {
        //The symbols to be written on the game board are X and O.
        // The method determines this symbol according to the player.
        // also the conditions are working according to the given number in string format.
        // According to the number given by the user,
        // his own symbol is written in its place in the character list.

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';
        }
        text = text.toLowerCase();
        text = text.trim();

        if (text.equals("1")) {
            gameBoard[0][0] = symbol;
        } else if (text.equals("2")) {
            gameBoard[0][2] = symbol;
        } else if (text.equals("3")) {
            gameBoard[0][4] = symbol;
        } else if (text.equals("4")) {
            gameBoard[2][0] = symbol;
        } else if (text.equals("5")) {
            gameBoard[2][2] = symbol;
        } else if (text.equals("6")) {
            gameBoard[2][4] = symbol;
        } else if (text.equals("7")) {
            gameBoard[4][0] = symbol;
        } else if (text.equals("8")) {
            gameBoard[4][2] = symbol;
        } else if (text.equals("9")) {
            gameBoard[4][4] = symbol;
        }
    }
    public static void start(){

        boolean close = false;
        //we create a number list to save the positions chosen by the player.
        List<String> playerPositions = new ArrayList<>();
        //We also create a list of numbers to save the positions chosen by the computer.
        List<String> cpuPositions = new ArrayList<>();
        //We also record the positions chosen by both players so that they cannot be selected again.
        List<String> selectedPosition = new ArrayList<>();
        //We will check the numbers in string format so that there is no wrong entry.
        List numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        // we are preparing the board on which the game will be played. we make a two column character list
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        char[][] gameBoardExample = {
                {'1', '|', '2', '|', '3'},
                {'-', '+', '-', '+', '-'},
                {'4', '|', '5', '|', '6'},
                {'-', '+', '-', '+', '-'},
                {'7', '|', '8', '|', '9'},
        };
        // we make a method to print the board we prepared because we will use it after every move
        printGameBoard(gameBoardExample);

        // After each move into the while loop, userChanger will increment by one,
        // the method will determine whether this number is odd or even,
        // and the user will move for even numbers and the computer for odd numbers.
        int userChanger = 2; // this is our first number. if you want computer can start firstly
        Scanner scan = new Scanner(System.in);

        while (true) {
            if (user(userChanger).equals("player")) { // if the move order is on the player
                while (true) { // here we make a loop that will continue until the game is over
                    System.out.print("Enter your placemenet (1-9): ");
                    String position = scan.nextLine();// we want numbers in string format from the player

                    // if the entered number is one of the required numbers and
                    // not one of the previously entered numbers,
                    // the user's symbol will be placed at the position of the number.

                    /*if(numbers.contains(position)) System.out.println(" This Number is in the List");
                    else System.out.println("This character or number is not in  List");*/
                    if ((numbers.contains(position)) && !selectedPosition.contains(position)) {
                        playerPositions.add(position);// // The number selected by the player is added to the list.
                        // with this list we will check if the player can win or not

                        selectedPosition.add(position);// with this list we will check if the same number has been selected before.

                        // We print the numbers entered by the player as a list. this will show us if there are errors
                        System.out.println("Selected player positions " + playerPositions);

                        //if all conditions are met
                        //We take the game board, the number entered by the player,
                        // and the player name as parameters to this method.
                        //This method processes the numbers given from the player on the game board.
                        izolated(gameBoard, position, user(userChanger));

                        // player, numbers,  checked that the numbers are written correctly, not written before.
                        // then the player's symbol was placed on the board.
                        // Now it will be checked whether the player has won or not..
                        // how the method works will be explained inside the method
                        if (winnerCheck(playerPositions) == 2) {
                            System.out.println("\n...Player wins!...");
                            close = true;  // the key will be true because the player won the game and the game will be over
                            break;
                        }
                        break;
                    } else {
                        // if the entered number is not entered in a correct format,
                        // if it has been entered before, then our program will say try again,
                        // the operations will not be executed.
                        System.out.println("Please enter a number between 1 and 9!!");
                        continue;
                    }
                }
                //printGameBoard(gameBoard);
            } else if (user(userChanger).equals("cpu")) {
                while (true) {
                    // the string format number is required for its place on the game board,
                    // but will be converted to int format for list checks.
                    String cpuNumber = userCPU();//
                    // the computer cannot generate an incorrect character.
                    // For this reason, it is only checked for previously entered numbers.
                    if (!selectedPosition.contains(cpuNumber)) {

                        cpuPositions.add(cpuNumber);
                        selectedPosition.add(String.valueOf(cpuNumber));

                        izolated(gameBoard, cpuNumber, user(userChanger));
                        System.out.println("Selected cpu positions " + cpuPositions);

                        if (winnerCheck(cpuPositions) == 2) {

                            System.out.println("\n.....CPU wins!.....");
                            close = true;
                            break;
                        }
                        break;

                    } else {
                        continue;
                    }
                }
                printGameBoard(gameBoard);
            }
            userChanger++;// here we are switching players.
            //there is a possibility that no one can win in the game.
            // For this reason, the game must be over after a total of 9 points.
            // We check this by looking at the size of the list of entered numbers.

            // or if the game is over early, the key becomes true and the game is over.
            if (selectedPosition.size() == 9 || close == true) {
                if (winnerCheck(playerPositions) == 2){
                    printGameBoard(gameBoard);
                    System.out.println("----------");
                    System.out.println(" GAME OVER \n");
                    break;
                }
                System.out.println("----------");
                System.out.println(" GAME OVER \n");
                break;
            }
            //printGameBoard(gameBoard);
        }

    }
    public static void printMenu(){
        System.out.println("...WELCOME TICTACTOE... ");
        System.out.println("...Caution ! you will play against the computer!!))");
        System.out.println("");
        System.out.println("Press 1 to PLAY");
        System.out.println("Press O to Exit");
    }
}
