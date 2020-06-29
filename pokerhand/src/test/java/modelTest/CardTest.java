package modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;


@SpringBootTest
public class CardTest {

	@Test
    public void addPokerCard() {
		Card card = new Card((short)2,(short)2);
		assertNotNull(card.getRank());
	}
	
	@Test
	public void testIllegalRank() {
		 assertThrows(IllegalArgumentException.class, () -> new Card((short)-1,(short)2));
		
	}
	
	@Test
	public void testIllegalRanks() {
		assertThrows(IllegalArgumentException.class, () -> new Card((short)2,(short)-1));
	}
	
	@Test
	public void testToString() {
        assertEquals("4 of diamonds", new Card((short)2,(short)2).toString());
        assertEquals("4 of clubs", new Card((short)3,(short)2).toString());
        assertEquals("3 of diamonds", new Card((short)2,(short)1).toString());
    }
	
    @Test
    public void testGetSuit() {
        assertEquals("diamonds", new Card((short)2,(short)2).getSuit());
        assertEquals("clubs", new Card((short)3,(short)2).getSuit());
        assertEquals("spades", new Card((short)1,(short)2).getSuit());
        assertNotEquals("diamonds", new Card((short)1,(short)2).getSuit());
    }
    
    @Test
    public void testGetRank() {
        assertEquals("Ace", new Card((short)2,(short)12).getRank());
        assertEquals("King", new Card((short)2,(short)11).getRank());
        assertEquals("4", new Card((short)2,(short)2).getRank());
        assertNotEquals("1", new Card((short)1,(short)2).getRank());
    }
	
}
