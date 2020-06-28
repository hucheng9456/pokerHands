package pokerhand.pokerhand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import configuration.CORSHander;
import configuration.ResourceServerConfig;
import configuration.WebMVCConfiger;

@SpringBootApplication
@Import({ResourceServerConfig.class,CORSHander.class,WebMVCConfiger.class})
public class PokerhandApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PokerhandApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PokerhandApplication.class);
	}

}
