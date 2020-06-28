package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;


@SpringBootTest
public class HandTest {

	@Test
    public void checkPokerHands() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)2,(short)2);
			cards[i] = card;
		}
    	Hand hand2 = new Hand(cards);
    	assertEquals(5,hand2.getCards().length);
	}
	
	@Test
	public void testRankHand() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)2,(short)2);
			cards[i] = card;
		}
    	Hand hand = new Hand(cards);
//    	assertEquals(4,hand.rankHand());
	}
	
	@Test
	public void testPair() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)3);
			cards[i] = card;
		}
		cards[4] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
    	Hand hand2 = new Hand(cards);
    	assertTrue(hand2.isOnePair());
	}
	
	@Test
	public void testRank() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)3);
			cards[i] = card;
		}
		cards[4] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
    	Hand hand2 = new Hand(cards);
    	hand2.rankHand();
	}
	
	@Test
	public void testHighCard() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)3);
			cards[i] = card;
		}
		cards[4] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
    	Hand hand2 = new Hand(cards);
    	assertEquals("10 of clubs", hand2.highCard().toString());
	}
	
	@Test
	public void testThreeOfKind() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)3);
			cards[i] = card;
		}
		cards[2] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
    	Hand hand2 = new Hand(cards);
    	assertTrue(hand2.isThreeOfKind());
	}
	
	@Test
	public void testFlush() {
		Card [] cards = new Card[5];
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)3);
			cards[i] = card;
		}
    	Hand hand2 = new Hand(cards);
    	assertTrue(hand2.isFlush());
	}
}
