package Shahar;

/**
 * Created by p0018972 on 21/02/2017.
 */
public class Card {

    String suit;
    String rank;


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public int getValue()
    {
        switch(this.rank)
        {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                return Integer.parseInt(this.rank);
            case "J":
            case "j":
            case "Q":
            case "q":
            case "K":
            case "k":
                return 10;
            case "A":
            case "a":
                return 11;
        }
        throw new IllegalArgumentException("No Such card " + rank);
    }

/*
     -----
    |♥    |
    |  9  |
    |    ♥|
     -----
  */

    public String getSuit()
    {
        return this.suit;
    }

    public String getRank()
    {
        return this.rank;
    }

    public String getDetails()
    {
        if(!rank.equals("10")) {
            String s = " -----\n|" + suit + "    |" + "\n|  " + rank + "  |\n|    " + suit + "|\n -----";
            return s;
        }
        else {
            String s = " -----\n|" + suit + "    |" + "\n| " + rank + "  |\n|    " + suit + "|\n -----";
            return s;
        }
    }
}
