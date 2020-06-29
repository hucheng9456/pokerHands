package controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pokerhand.pokerhand.controller.PokerHandController;
import pokerhand.pokerhand.formatters.CardFormatter;
import pokerhand.pokerhand.formatters.PokerFormatter;

@SpringBootTest
public class PokerHandControllerTest {

	@Autowired
	private PokerHandController pokerHandController = new PokerHandController();
	private PokerFormatter pokerFormatter = new PokerFormatter(),pokerFormatter2 = new PokerFormatter(),pokerFormatter3 = new PokerFormatter();;
	private CardFormatter cardFormatter = new CardFormatter(),cardFormatter2 = new CardFormatter(),cardFormatter3 = new CardFormatter(),cardFormatter4 = new CardFormatter(),cardFormatter5 = new CardFormatter();
	private List<PokerFormatter> pokerFormatters = new ArrayList<>();
	private List<CardFormatter> list = new ArrayList<>(),list2 = new ArrayList<>();;
	
	@Before
	//to create JSON input
	public void init() {
		pokerFormatter.setName("joe");
		pokerFormatter2.setName("jen");
		pokerFormatter3.setName("bob");
		cardFormatter.setRank((short) 2);
		cardFormatter.setSuit((short) 2);
		cardFormatter2.setRank((short) 3);
		cardFormatter2.setSuit((short) 1);
		cardFormatter3.setRank((short) 3);
		cardFormatter3.setSuit((short) 1);
		cardFormatter4.setRank((short) 11);
		cardFormatter4.setSuit((short) 3);
		cardFormatter5.setRank((short) 12);
		cardFormatter5.setSuit((short) 1);
		list.add(cardFormatter);
		list.add(cardFormatter2);
		list.add(cardFormatter3);
		list.add(cardFormatter4);
		list.add(cardFormatter5);
	}
	
	@Test
	public void testPokerHands() {
		list2.add(cardFormatter);
		list2.add(cardFormatter2);
		list2.add(cardFormatter4);
		list2.add(cardFormatter4);
		list2.add(cardFormatter4);
		pokerFormatter.setCards(list);
		pokerFormatter2.setCards(list2);
		pokerFormatter3.setCards(list);
		pokerFormatters.add(pokerFormatter);
		pokerFormatters.add(pokerFormatter2);
		pokerFormatters.add(pokerFormatter3);
		assertEquals("jen",pokerHandController.pokerHands(pokerFormatters).get("winner"));
	}
	
}
