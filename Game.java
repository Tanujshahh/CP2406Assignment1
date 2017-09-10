import java.util.Scanner;


class Game {

    private static int getUserMenuChoice() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int n = reader.nextInt();
        return n;
    }

    private static void showMenu() {
        System.out.println("1. Play the  game.");
        System.out.println("2. Exit the game.");
        System.out.println("3. View Instructions for the game.");

    }

    private static void showWelcome() {
        System.out.print("Welcome to Mineral SuperTrumps Game !  \n");
        System.out.print("Made by Tanuj Shah JCUS 13409858 \n");
        System.out.println("All the best!enjoy the game :) \n ");
        System.out.println("Please select an option from below");
    }

    public static void startNewGame() {
        int numberOfPlayers = getNumberPlayers();
        SuperTrumpGame game = new SuperTrumpGame(numberOfPlayers);
        System.out.print("You have selected " + numberOfPlayers + " numbers of players to play with you. \n");
        game.selectDealer(numberOfPlayers);
        System.out.print("The dealer is player  " + game.dealerNumber + ". \n");
        game.dealHand(numberOfPlayers);
        int firstPlayer = game.determineFirstPlayer(game.dealerNumber, numberOfPlayers);
        System.out.println("Player " + firstPlayer + " is playing the first card.");

        if (firstPlayer == 1){
            game.printHand();
            game.firstPlayerTurn();
        }
        else {
            game.firstBotTurn(firstPlayer);

        }

        if (firstPlayer == 1) {
            for (int i = 1; i < game.players.length; i ++){
                if (game.players[i].isHuman) {
                    game.playerTurn();
                } else {
                    System.out.println("Player " + (i + 1) + " has played a turn:");
                    game.botTurn(i);
                }
            }
        }
        else {
            for (int i = firstPlayer; i < game.players.length; i ++){
                if (game.players[i].isHuman) {
                    game.playerTurn();
                } else {
                    System.out.println("Player " + (i + 1) + " has played a turn:");
                    game.botTurn(i);
                }
            }
        }


        while (!game.gameIsover) {

            for (int i = 0; i < game.players.length; i++) {
                if (game.players[i].isHuman) {
                    game.playerTurn();
                } else {
                    System.out.println("Player " + (i + 1) + " has played a turn:");
                    game.botTurn(i);
                }

            }
        }


    }
    public static void main(String args[])
    {

        showWelcome();
        showMenu();
        int opt = getUserMenuChoice();

        if (opt == 1)
        {
            System.out.println("A new game has started!");
            startNewGame();
        } else if (opt == 2){
            System.exit(0);
        } else {
            System.out.println(" Read the assignment folder doc file ");
        }

    }

    private static int getNumberPlayers() {

        System.out.println("How many players would you like to play the game with?");
        Scanner reader = new Scanner(System.in);
        System.out.println("Please input ur choice ");
        int n = reader.nextInt();
        if (n<3)
        {
            System.out.print("Minimum number of players are 3 ");
        }


        while (n <= 2 || n >= 5) {
            System.out.println("How many players would you like to play with?");
            Scanner reader2 = new Scanner(System.in);

            System.out.println("Enter your choice: ");
            n = reader2.nextInt();

        }
        return n + 1;

    }


    public static void dealCards(STDeck Deck, int numberOfPlayers) {
        System.out.println(Deck);
    }



}



