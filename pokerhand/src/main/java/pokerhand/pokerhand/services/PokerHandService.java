package pokerhand.pokerhand.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pokerhand.pokerhand.formatters.PokerFormatter;
import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;


@Service
public class PokerHandService {
	
	private static final int HANDSIZE = 5; 
 
	public String pokerHandActor(List<PokerFormatter> pokerhands) {
		List<String> names = new ArrayList<String>();
		Hand [] hands = new Hand[pokerhands.size()];
		for(int i=0;i<pokerhands.size();i++) {
			Card [] cards = new Card[5];
			for(int j=0;j<pokerhands.get(i).getCards().size();j++) {
				cards[j] = pokerhands.get(i).getCards().get(j).getCard();
			}
			hands[i] = new Hand(cards);
		}
		return pokerhands.get(compareHands(hands)).getName();
	}

	public int compareHands(Hand [] hands) {
		Hand maxHand = hands[0];
		int max = 0;
		for(int i=1;i<hands.length;i++) {
			if(compareHands(maxHand,hands[i]) == 2) {
				maxHand = hands[i];
				max = i;
			}else if(compareHands(maxHand,hands[i]) == 0) {
				Card card1 = checkHighestCardInHand(maxHand);
				Card card2 = checkHighestCardInHand(hands[i]);
				if(compareHighCard(card1,card2) == 2) {
					maxHand = hands[i];
					max = i;
				}
			}
		}
		System.out.println("compareHands" + max);
		return max;
	}
	
	public Card checkHighestCardInHand(Hand h) {
		int [] temp = h.rankHand();
		int max = 0;
		for(int i=0;i<temp.length;i++) {
			if(temp[i] > 0 && temp[i] < 2) {
				if(i > max) {
					max = i;
				}
			}
		}
		for(int i=0;i<h.getCards().length;i++) {
			if(max == h.getCards()[i].getRankShort()) {
				return h.getCards()[i];
			}
		}
		return null;
	}
	
    //1 = first hand is best, 2 = second hand is best, 0 = tie
    public int checkFlush(Hand h1, Hand h2) {
    	Card card1 = h1.getCards()[1];
    	Card card2 = h2.getCards()[1];
    	return checkCardSuit(card1,card2);
    }
    
    public int checkCardSuit(Card card, Card card1) {
		if(card.getSuitShort() > card1.getSuitShort()) {
    		return 1;
		}else if(card.getSuitShort() < card1.getSuitShort()) {
    		return 2;
		}else {
			return 0;
		}
    }
    
    public int compareHighCard(Card card, Card card1) {
    	if(card.getRankShort() > card1.getRankShort()) {
    		return 1;
    	}else if(card.getRankShort() < card1.getRankShort()) {
    		return 2;
    	}else {
    		if(card.getSuitShort() > card1.getSuitShort()) {
        		return 1;
    		}else if(card.getSuitShort() < card1.getSuitShort()) {
        		return 2;
    		}else {
    			return 0;
    		}
    	}
    }
    
    public int compareOnePair(Hand h1, Hand h2) {
    	Card card1 = h1.getMaxOnePair();
    	Card card2 = h2.getMaxOnePair();
    	return compareHighCard(card1,card2);
    }
    
    public int compareThreeOfKind(Hand h1, Hand h2) {
    	Card card1 = h1.getMaxThreeOfKind();
    	Card card2 = h2.getMaxThreeOfKind();
    	return compareHighCard(card1,card2);
    }
    
  //rank 1 = highCard 2 = onepair, 3 = threeOfKind , 4 = flush
    public int compareHandsOfSameClass(Hand h1, Hand h2,int rank1) {
    	if(rank1 == 4) {
    		return checkFlush(h1,h2);
    	}else if(rank1 == 3) {
    		return compareThreeOfKind(h1,h2);
    	}else if(rank1 ==2) {
    		return compareOnePair(h1,h2);
    	}else if(rank1 == 1){
    		return compareHighCard(h1.highCard(),h2.highCard());
    	}else {
    		return 0;
    	}
	}
    
    //1 = first hand is best, 2 = second hand is best, 0 = tie
    public int compareHands(Hand h, Hand h1) {
    	int rank1 = h.handCategory();
    	int rank2 = h1.handCategory();
    	if(rank1 > rank2) {
    		return 1;
    	}else if(rank1 < rank2) {
    		return 2;
    	}else {
    		return compareHandsOfSameClass(h,h1,rank1);
    	}
    }
}

