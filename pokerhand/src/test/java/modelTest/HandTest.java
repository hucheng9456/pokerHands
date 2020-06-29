package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;


@SpringBootTest
public class HandTest {
	
	private Card [] cards = new Card[5],cards2 = new Card[5],cards3 = new Card[5];
	private Hand clubFlush,diamondFlush,highCardOnly;
	
	@Before
	public void init() {
		for(int i=0;i<5;i++) {
			Card card = new Card((short)2,(short)2);
			cards[i] = card;
		}
		for(int i=0;i<5;i++) {
			Card card = new Card((short)3,(short)12);
			cards2[i] = card;
		}
    	diamondFlush = new Hand(cards);
    	clubFlush = new Hand(cards2);
    	cards3[0] = new Card((short)2,(short)2);
    	cards3[1] = new Card((short)3,(short)1);
    	cards3[2] = new Card((short)2,(short)3);
    	cards3[3] = new Card((short)3,(short)9);
    	cards3[4] = new Card((short)1,(short)10);
    	highCardOnly = new Hand(cards3);
	}

	@Test
    public void testCardsInHand() {
    	assertEquals(5,diamondFlush.getCards().length);
    	assertEquals(5,clubFlush.getCards().length);
    	assertEquals(5,highCardOnly.getCards().length);
	}
	
	@Test
	public void testRankHand() {
    	assertEquals(5,diamondFlush.rankHand()[2]);
    	assertEquals(5,clubFlush.rankHand()[12]);
    	assertEquals(1,highCardOnly.rankHand()[2]);
	}
	
	@Test
	public void testPair() {
		cards[4] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
		clubFlush = new Hand(cards);
    	assertTrue(clubFlush.isOnePair());
	}
	
	@Test
	public void testHighCard() {
		cards[4] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
		clubFlush = new Hand(cards);
    	assertEquals("10 of clubs", clubFlush.highCard().toString());
	}
	
	@Test
	public void testThreeOfKind() {
		cards[1] = new Card((short)3,(short)8);
		cards[2] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
		clubFlush = new Hand(cards);
    	assertTrue(clubFlush.isThreeOfKind());
    	assertFalse(highCardOnly.isThreeOfKind());
	}
	
	@Test
	public void testFlush() {
    	assertTrue(clubFlush.isFlush());
    	assertFalse(highCardOnly.isFlush());
	}
	
	@Test
	public void testGetMaxThreeOfKind() {
		cards[1] = new Card((short)1,(short)8);
		cards[2] = new Card((short)2,(short)8);
		cards[3] = new Card((short)3,(short)8);
		clubFlush = new Hand(cards);
		assertEquals(3,clubFlush.getMaxThreeOfKind().getSuitShort());
		assertEquals(8,clubFlush.getMaxThreeOfKind().getRankShort());
	}
}
