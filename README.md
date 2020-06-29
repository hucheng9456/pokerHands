# pokerHands


This is a Java Spring Server of pokerHands Evaluation of 5 cards on each hand.

There is a POST API which takes a JSON form of Poker Hands and returns the winner of a table.

two model classes which includes a Hand and a Card class which i use to evaluate each hands. Every single method has a correspond test case. It helps me to check what went wrong during the process.


For Unit Testing, I have created a Suite Class ,AllFeatureTests, which combines every single test class in one place. I have a jUnit test for every method and they are well documented. Each Method does its own calculation and my unit testing strategy is to test the output of each individual method is correct. 

I have created these two dictionaries to form the class of card; i take Short as inputs. 
String[] suits = { "hearts", "spades", "diamonds", "clubs" };
String[] ranks  = { "2", "3", "4", "5", "6", "7", 
                   "8", "9", "10", "Jack", "Queen", "King","Ace" };
