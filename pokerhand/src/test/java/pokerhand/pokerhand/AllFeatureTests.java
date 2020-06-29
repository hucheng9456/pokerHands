package pokerhand.pokerhand;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controllerTests.PokerHandControllerTest;
import modelTest.CardTest;
import modelTest.HandTest;
import servicesTest.PokerHandTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({CardTest.class,HandTest.class,PokerHandTest.class,PokerHandControllerTest.class})
public class AllFeatureTests {

}
