package pokerhand.pokerhand.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Card{
    private short rank, suit;

    private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
    private static String[] ranks  = { "2", "3", "4", "5", "6", "7", 
                   "8", "9", "10", "Jack", "Queen", "King","Ace" };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    public Card(short suit, short rank)
    {
    	 if (!isValidRank(rank)) {
             throw new IllegalArgumentException("Invalid rank.");
         }

         if (!isValidSuit(suit)) {
             throw new IllegalArgumentException("Invalid suit.");
         }
        this.rank=rank;
        this.suit=suit;
    }

    @Override
    public String toString()
    {
          return ranks[rank] + " of " + suits[suit];
    }
    
    public String getRank() {
         return ranks[rank];
    }

    public String getSuit() {
        return suits[suit];
    }
    
    public short getRankShort() {
        return rank;
   }

   public short getSuitShort() {
       return suit;
   }
   
    
    private static boolean isValidRank(short rank) {
        return rank >= 0 && rank <= 12;
    }

    private static boolean isValidSuit(short suit) {
        return suit == 1 || suit == 2 || suit == 3 || suit == 4;
    }

}
