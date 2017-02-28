package Shahar;

public class Main{

    public static void main(String[] args) {
        Game game = new Game();
        //System.out.println();

        int playerAction;
        String playerName;
        playerName = IO.getString("Hello, Welcome to the CASINO\nPlease enter your name");
        playerAction = IO.getInt("\nNice to meet you "+ playerName +", let's play.\n\nPleas choose an Action:" +
                "\nfor New BlackJack Game pess 1\nfor EXIT press 2");


        while (playerAction != 2){
            game.restart();
            Play(game);
            playerAction = IO.getInt("\nThat was FUN ! Do you want to play again ? " +
                     "\nfor New BlackJack Game pess 1\nfor EXIT press 2");

        }

        System.out.println("Thank you for playing " + playerName + ", See you next time.");

    }


    public static void Play(Game game) {
        int playerAction = 0;
        System.out.println("This is your Hand now.\n" + game.getPlayerHand() + "\nYour score is: " + game.playerScore);
        if (game.isBlackJack) {
            System.out.println("--------------------\n| You Got BLACK-JACK |\n--------------------");
            game.winner = 0;
            game.printWinner();
            return;
        }

        while(playerAction != 2) {
            System.out.println("\nWhat is your move ?");
            playerAction = IO.getInt("\n(1) Hit me ! \n(2) Stand !");
            if (playerAction == 1) {
                game.hit();
                System.out.println("This is your Hand now.\n" + game.getPlayerHand() + "\nYour score is: " + game.playerScore);
            }
            if(game.isBusted()){
                //System.out.println("This is your Hand now.\n" + game.getPlayerHand() + "\nYour score is: " + game.playerScore);
                game.winner = 1;
                game.printWinner();
                break;
            }
        }

        if (playerAction == 2) {
            System.out.println("Now its the Dealer Time....");
            game.stand();
            System.out.println("This is The Dealer Hand.\n" + game.getDealerHand() + "\nDealer score is: " + game.dealerScore);

            if (game.dealerScore > 21){
                game.winner = 0;
                System.out.println("Dealer Got BUSTED !");
                game.printWinner();
            }else if(game.dealerScore < game.playerScore){
                game.winner = 0;
                game.printWinner();
            }else if (game.dealerScore > game.playerScore) {
                game.winner = 1;
                game.printWinner();
            } else if (game.dealerScore == game.playerScore) {
                game.winner = 2;
                game.printWinner();
            }
         }
    }
}
