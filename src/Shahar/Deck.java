package Shahar;
import java.util.Random;
import java.util.ArrayList;

/**
 * Created by p0018972 on 21/02/2017.
 */
public class Deck {

    ArrayList<Card> cards = new ArrayList<Card>();

    public Deck()
    {
        String[] Rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] suits = {"♥","♦","♣","♠"};
        for (String i : suits)
            for (String j : Rank)
                cards.add(new Card(i, j));


        Shuffel();
    }


    public void Shuffel()
    {
        Random x = new Random();
        for (int i = 0; i < 500; i++)
            cards.add(cards.remove(x.nextInt(52)));
    }

    public String toString()
    {
        String a = "";
        for (int i = 0; i <cards.size() ; i++) {
            a += cards.get(i).getDetails() + "\n";
        }
        return a;
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public Card dealCard()
    {
        return cards.remove(0);
    }

    public boolean isEmpty()
    {
        return cards.isEmpty();
    }

}
