package pokerhand.pokerhand.services;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ActorService {

	public static Map<String, Object> responseWrap(String[] wrappingNames,Object[] wrappingObjects){
		if(wrappingNames.length != wrappingObjects.length) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "pacaging went wrong");
		}
		Map<String, Object> resMap = new HashMap<String,Object>();
		IntStream.range(0, wrappingNames.length).forEach(i -> {
			resMap.put(wrappingNames[i], wrappingObjects[i]);
		});
		return resMap;
	}
	
	public static Map<String, Object> responseWrap(String wrappingName,Object wrappingObject){
		return new HashMap<String, Object>(){{
			put(wrappingName, wrappingObject);
		}};
	}


}
