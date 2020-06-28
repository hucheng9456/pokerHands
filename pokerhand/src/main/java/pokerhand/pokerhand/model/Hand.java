package pokerhand.pokerhand.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Hand {
	
	private static final int HANDSIZE = 5; 
	private Card[] cards;
	private int[] value;
	private int[] ranks = new int[14];  
	int largeGroupRank,smallGroupRank;
		
	public Hand(Card [] cards)
	{
		this.value = new int[6];
	//        cards = new Card[5];
	    this.cards = cards;
	    this.largeGroupRank = 0;
	    this.smallGroupRank= 0;
	}
	   
		
	public void displayAll()
	{
	    for (int x=0; x<5; x++)
	    System.out.println(cards[x]);
	}
	
	public Card [] getCards() {
		return cards;
	}
		
	public int [] getValues() {
		return value;
	}
		   
	public int handCategory() {
		if(isFlush()) {
			return 4;
		}else if(isThreeOfKind()){
			return 3;
		}else if(isOnePair()) {
			return 2;
		}else {
			return 1;
		}
	}
   
	public Card highCard() {
		Card max = cards[0];
		Short [] ranks = new Short[HANDSIZE];
		for(int i=0;i<cards.length;i++) {
			ranks[i] = cards[i].getRankShort();
			if(ranks[i] > max.getRankShort()) {
				max = cards[i];
			}else if(ranks[i] == max.getRankShort()){
				if(cards[i].getSuitShort() > max.getSuitShort()) {
					max = cards[i];
				}
			}
		}
		return max;
	}
	   
   public boolean isOnePair() {
	   	for(int i=0;i<cards.length;i++) {
	   		for(int j=i+1;j<cards.length;j++) {
	   	   		if(cards[j].getRankShort() == cards[i].getRankShort()) {
	   	   			return true;
	   	   		}
	   		}
	   	}
	   	return false;
   }
	   
   public Card getMaxOnePair() {
	   	for(int i=0;i<cards.length;i++) {
	   		for(int j=i+1;j<cards.length;j++) {
	   	   		if(cards[j].getRankShort() == cards[i].getRankShort()) {
	   	   			if(cards[j].getSuitShort() >= cards[i].getSuitShort()) {
		   	   			return cards[j];
	   	   			}else {
	   	   				return cards[i];
   	   				}
	   	   		}
	   		}
	   	}
	   	return null;
   }
   
   public boolean isFlush() {
       String suit = cards[0].getSuit();
       for (int i = 1; i < 5; i++) {
           if (suit != cards[i].getSuit()) return false;
       }
       return true;
   }
   
   public boolean isThreeOfKind() {
	   boolean hasThreeOfAKind = false;
       int[] value = new int[cards.length];
       for(int i =0; i<cards.length; i++){
           Card myCard = cards[i];
           value[i] = myCard.getRankShort(); 
       }
       int counter = 0;
       for(int i =0; i<cards.length; i++){
           for(int j =i+1; j<cards.length; j++){
               if(value[i] == value[j]){
                   counter++; 
               }
               if(j == cards.length-1 && counter!=2){ 
                   counter = 0;
               }
               else if(j== cards.length-1 && counter >= 2){
                   hasThreeOfAKind = true;
               }
           }
       }
       return hasThreeOfAKind;
   }
   
   public Card getMaxThreeOfKind() {
       int[] value = new int[cards.length];
       int[] suit = new int[cards.length];
       for(int i =0; i<cards.length; i++){
           Card myCard = cards[i];
           value[i] = myCard.getRankShort(); 
           suit[i] = myCard.getRankShort(); 
       }
       int counter = 0;
       int temp = 0;
       for(int i =0; i<cards.length; i++){
           short max = cards[i].getSuitShort();
           for(int j =i+1; j<cards.length; j++){
               if(value[i] == value[j]){
                   counter++;
                   if(cards[j].getSuitShort() >= max) {
                	   max = cards[j].getSuitShort();
                	   temp = j;
                   }
               }
               if(j == cards.length-1 && counter!=2){ 
                   counter = 0;
                   temp = 0;
               }
               else if(j== cards.length-1 && counter >= 2){
                   return cards[temp];
               }
           }
       }
       return null;
   }
   
   public int [] rankHand() {
	   for (int x=0; x<=13; x++){
           ranks[x]=0;
       }
       for (int x=0; x<=4; x++){
           ranks[ cards[x].getRankShort()]++;
       }
       return ranks;
   }
   
}