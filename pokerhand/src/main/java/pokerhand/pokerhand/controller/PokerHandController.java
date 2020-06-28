package pokerhand.pokerhand.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pokerhand.pokerhand.formatters.PokerFormatter;
import pokerhand.pokerhand.services.ActorService;
import pokerhand.pokerhand.services.PokerHandService;

@RestController
@RequestMapping("/api/pokerHands")
public class PokerHandController {
	
	@Autowired
	private PokerHandService pokerHandService = new PokerHandService();
	@Autowired
	private ActorService actorService;
	
	@PostMapping("/")
	@ResponseBody
    public  Map<String,Object> pokerHands(@RequestBody List<PokerFormatter> pokerhands){
    	return actorService.responseWrap("winner", pokerHandService.pokerHandActor(pokerhands));
    }
}
