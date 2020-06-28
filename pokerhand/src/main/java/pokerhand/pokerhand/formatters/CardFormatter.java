package pokerhand.pokerhand.formatters;


import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import pokerhand.pokerhand.model.Card;
import pokerhand.pokerhand.model.Hand;

@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
public class CardFormatter{
	
    private short rank, suit;
	
	public Short getRank() {
		return this.rank;
	}
	
	public Short getSuit() {
		return this.suit;
	}
	
	public Card getCard() {
		Card card = new Card(this.suit,this.rank);
		return card;
	}
}
