package Shahar;

import java.util.ArrayList;

/**
 * Created by p0018972 on 21/02/2017.
 */
public class Hand {
    ArrayList<Card> cards = new ArrayList<>();


    public Hand()
    {

    }

    public String toString()
    {
        String a = "";
        for (int i = 0; i <cards.size() ; i++) {
            a += cards.get(i).getDetails() + "\n";
        }
        return a;
    }

    public void addCard(Card c)
    {
        cards.add(c);
    }

    public int getValue()
    {
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i).getValue();
        }
        int j = 0;
        while(sum > 21 && j < cards.size()){
            if(cards.get(j).getValue()== 11) {
                sum -= 10;
            }
            j++;
        }
        return sum;
    }

}
