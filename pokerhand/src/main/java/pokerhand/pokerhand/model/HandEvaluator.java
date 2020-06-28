package pokerhand.pokerhand.model;

import lombok.Data;

@Data
public class HandEvaluator {
    private int[] value;
    private Hand hand;
    
    public HandEvaluator(Hand hand) {
    	this.hand = hand;
    	this.value = new int[5];
    }

}
