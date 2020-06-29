package servicesTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pokerhand.pokerhand.controller.PokerHandController;
import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;
import pokerhand.pokerhand.services.PokerHandService;

@SpringBootTest
public class PokerHandTest {
	
	@Autowired
	private PokerHandService pokerHandService = new PokerHandService();
	private Hand hand3, hand2, hand;
	private Card [] cards = new Card[5],clubCards = new Card[5],heartCards = new Card[5];
	private Hand [] hands = new Hand[3];
	
	@Before
	public void init() {
		cards[0] = new Card((short)2,(short)2);
    	cards[1] = new Card((short)1,(short)1);
    	cards[2] = new Card((short)2,(short)5);
    	cards[3] = new Card((short)2,(short)2);
    	cards[4] = new Card((short)2,(short)11);
    	hand = new Hand(cards);
    	clubCards[0] = new Card((short)3,(short)2);
    	clubCards[1] = new Card((short)3,(short)1);
    	clubCards[2] = new Card((short)3,(short)7);
    	clubCards[3] = new Card((short)3,(short)5);
    	clubCards[4] = new Card((short)3,(short)11);
    	hand2 = new Hand(clubCards);
    	heartCards[0] = new Card((short)1,(short)2);
    	heartCards[1] = new Card((short)1,(short)2);
    	heartCards[2] = new Card((short)1,(short)7);
    	heartCards[3] = new Card((short)1,(short)5);
    	heartCards[4] = new Card((short)1,(short)4);
    	hand3 = new Hand(heartCards);
    	hands[0] = hand;
    	hands[1] = hand2;
    	hands[2] = hand3;
	}
	
	@Test
	//test if hand evaluation is correct;
    public void testCompareHands() {
    	int temp = pokerHandService.compareHands(hands);
    	assertEquals(1,temp);
	}
	
	@Test 
	//test if getting highestCard in a single hand is correct;
	public void checkHighestCardInHand() {
    	System.out.println(pokerHandService.checkHighestCardInHand(hand));
	}
	
	@Test
	public void testCheckCardSuit() {
		Card card1 = new Card((short)3,(short)12);
		Card card2 = new Card((short)2,(short)2);
		assertEquals(1,pokerHandService.checkCardSuit(card1, card2));
	}
	
	@Test
	public void testCompareHighCard() {
		Card card1 = new Card((short)1,(short)11);
		Card card2 = new Card((short)2,(short)12);
		assertEquals(2,pokerHandService.compareHighCard(card1, card2));
	}
	
	@Test
	public void testCheckFlush() {
		assertEquals(1,pokerHandService.checkFlush(hand2, hand3));
	}
	
	@Test
	public void testCompareHandsOfSameClass() {
		assertEquals(1,pokerHandService.compareHandsOfSameClass(hand2, hand3,4));
	}
	
	@Test
	public void testCompareOnePair() {
		Card [] cards = new Card[5];
		cards[0] = new Card((short)2,(short)3);
    	cards[1] = new Card((short)1,(short)1);
    	cards[2] = new Card((short)2,(short)5);
    	cards[3] = new Card((short)2,(short)3);
    	cards[4] = new Card((short)2,(short)2);
		Card [] cards2 = new Card[5];
		cards2[0] = new Card((short)2,(short)2);
    	cards2[1] = new Card((short)1,(short)1);
    	cards2[2] = new Card((short)2,(short)5);
    	cards2[3] = new Card((short)2,(short)3);
    	cards2[4] = new Card((short)2,(short)2);
    	hand = new Hand(cards);
    	hand2 = new Hand(cards2);
		assertEquals(1,pokerHandService.compareOnePair(hand, hand2));
	}
	
	@Test
	public void testCompareThreeOfKind() {
		Card [] cards = new Card[5];
		cards[0] = new Card((short)3,(short)2);
    	cards[1] = new Card((short)1,(short)1);
    	cards[2] = new Card((short)2,(short)5);
    	cards[3] = new Card((short)2,(short)2);
    	cards[4] = new Card((short)2,(short)2);
		Card [] cards2 = new Card[5];
		cards2[0] = new Card((short)2,(short)2);
    	cards2[1] = new Card((short)1,(short)1);
    	cards2[2] = new Card((short)2,(short)5);
    	cards2[3] = new Card((short)2,(short)2);
    	cards2[4] = new Card((short)2,(short)2);
    	hand = new Hand(cards);
    	hand2 = new Hand(cards2);
		assertEquals(1,pokerHandService.compareThreeOfKind(hand, hand2));
	}
	
}
