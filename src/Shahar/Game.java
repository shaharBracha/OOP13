package Shahar;

/**
 * Created by p0018972 on 21/02/2017.
 */
public class Game {

    Deck D;
    boolean isGameOver;
    Hand playerHand;
    Hand dealerHand;
    int dealerScore;
    int playerScore;
    boolean isBlackJack;
    int winner = 3; // 0 - player Won  1 - dealerWon  2 - Tie  3 - Not Determined Yet

    public Game() {
        D = new Deck();
        dealerHand = new Hand();
        playerHand = new Hand();
        dealerHand.addCard(D.dealCard());
        dealerHand.addCard(D.dealCard());
        dealerScore = dealerHand.getValue();
        playerHand.addCard(D.dealCard());
        playerHand.addCard(D.dealCard());
        playerScore = playerHand.getValue();
        isBlackJack = checkBlackJeck();
        //if(isGameOver)
            //winner = 0;
    }

    // geters:

    public Deck getD() {
        return D;
    }

    public boolean getIsGameOn() {
        return isGameOver;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public boolean GetIsBlackJack() {
        return isBlackJack;
    }

    public int getWinner() {
        return winner;
    }

    // methods:

    public boolean isBusted()
    {
        return playerHand.getValue() > 21;
    }

    public void hit() {
        playerHand.addCard(D.dealCard());
        playerScore = playerHand.getValue();
        isGameOver = isBusted();
        if (isBusted())
            winner = 1;
    }

    public boolean checkBlackJeck()
    {
        return playerHand.getValue() == 21 && playerHand.cards.size() == 2;
    }

    void stand()
    {
        while(dealerHand.getValue() < 17){
            dealerHand.addCard(D.dealCard());
            dealerScore=dealerHand.getValue();
        }
    }
    
    public void restart ()
    {
        D = new Deck();
        dealerHand = new Hand();
        playerHand = new Hand();
        dealerHand.addCard(D.dealCard());
        dealerHand.addCard(D.dealCard());
        dealerScore = dealerHand.getValue();
        playerHand.addCard(D.dealCard());
        playerHand.addCard(D.dealCard());
        playerScore = playerHand.getValue();
        isBlackJack = checkBlackJeck();
    }

    public void printWinner(){
        if(winner == 0)
            System.out.println(
                    " -----------------\n" +
                    "| $$$ YOU WON $$$ |\n" +
                    " -----------------");
        if(winner == 1)
            System.out.println(
                    " ------------------\n" +
                    "| ### YOU LOSE ### |\n" +
                    " ------------------");
        if(winner == 2)
            System.out.println(
                    " -------------------\n" +
                    "| *** ITS A TIE *** |\n" +
                    " -------------------");
    }



}
