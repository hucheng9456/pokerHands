package pokerhand.pokerhand.configuration;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;


@Profile("!SECURITY_MOCK")
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private ObjectMapper mapper;
	
	public void exceptionHanderGenerate(HttpServletRequest request, HttpServletResponse response, Exception exception,String type) {
		HttpStatus curStatus = type.equals("UNAUTHORIZED") ? HttpStatus.UNAUTHORIZED : HttpStatus.FORBIDDEN;
		Map<String, Object> message = new HashMap<>();
	    message.put("timeStamp", Date.from(Instant.now()));
	    message.put("status", curStatus.value());
	    message.put("error", curStatus.name());
	    message.put("message", exception.getMessage());
	    message.put("path", request.getRequestURI());
	    response.setStatus(curStatus.value());
	    response.setHeader("Content-Type",MediaType.APPLICATION_JSON_VALUE);
	    try {
			response.getWriter().write(mapper.writeValueAsString(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
}
