package servicesTest;



import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@Autowired
	private PokerHandController pokerHandController = new PokerHandController();
	
	
	@Test
    public void testCompareHands() {
		Card [] cards = new Card[5];
		cards[0] = new Card((short)2,(short)2);
    	cards[1] = new Card((short)2,(short)2);
    	cards[2] = new Card((short)2,(short)5);
    	cards[3] = new Card((short)2,(short)3);
    	cards[4] = new Card((short)3,(short)11);
    	Hand hand = new Hand(cards);
		Card [] cards2 = new Card[5];
		cards2[0] = new Card((short)3,(short)2);
    	cards2[1] = new Card((short)3,(short)2);
    	cards2[2] = new Card((short)2,(short)7);
    	cards2[3] = new Card((short)3,(short)5);
    	cards2[4] = new Card((short)3,(short)4);
    	Hand hand2 = new Hand(cards2);
    	int temp = pokerHandService.compareHands(hand, hand2);
    	assertEquals(2,temp);
	}
	
	@Test
    public void checkPokerHands() {
		Card [] cards = new Card[5];
		cards[0] = new Card((short)2,(short)2);
    	cards[1] = new Card((short)1,(short)1);
    	cards[2] = new Card((short)2,(short)5);
    	cards[3] = new Card((short)2,(short)3);
    	cards[4] = new Card((short)2,(short)11);
    	Hand hand = new Hand(cards);
		Card [] cards2 = new Card[5];
		cards2[0] = new Card((short)1,(short)2);
    	cards2[1] = new Card((short)1,(short)1);
    	cards2[2] = new Card((short)2,(short)7);
    	cards2[3] = new Card((short)3,(short)5);
    	cards2[4] = new Card((short)3,(short)11);
    	Hand hand2 = new Hand(cards2);
		Card [] cards3 = new Card[5];
		cards3[0] = new Card((short)1,(short)2);
    	cards3[1] = new Card((short)1,(short)2);
    	cards3[2] = new Card((short)1,(short)7);
    	cards3[3] = new Card((short)1,(short)5);
    	cards3[4] = new Card((short)1,(short)4);
    	Hand hand3 = new Hand(cards3);
    	Hand [] hands = new Hand[2];
    	hands[0] = hand;
    	hands[1] = hand2;
//    	hands[2] = hand3;
    	Hand temp = pokerHandController.pokerHands(hands);
    	assertEquals(hand2,temp);
	}
	
}
