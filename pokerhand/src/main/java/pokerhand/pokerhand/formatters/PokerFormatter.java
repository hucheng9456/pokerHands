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

@Data
@SuperBuilder
@Accessors(chain = true)
@NoArgsConstructor
public class PokerFormatter{
	
	private String name;
	
	private List<CardFormatter> cards;
	
	public String getName() {
		return this.name;
	}
	
	public List<CardFormatter> getCards() {
		return this.cards;
	}
}
