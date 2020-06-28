package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSHander {

	//CORS setting
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				        .allowedMethods("PUT","DELETE","POST","GET")
				        .allowedOrigins("http://localhost:8080"
				        		,"http://dev.lasfu.roro3.com"
				        		,"https://dev.lasfu.roro3.com"
                                ,"https://dev2.roro3.com"
                                ,"http://dev2.roro3.com"
				        		,"http://lasfu_crawler.local"
				        		,"http://localhost:5000"
				        		,"http://localhost:3000"
				        		,"http://172.16.0.147:8080"
				        		,"http://roroshop.roro3.com"
				        		,"https://roroshop.roro3.com"
				        		,"http://www.lasfu.com"
				        		,"https://www.lasfu.com"
				        		,"https://lasfu.com"
				        		,"http://lasfu.com"
				        		,"http://localhost:5001");
			}
		};
	}
}
