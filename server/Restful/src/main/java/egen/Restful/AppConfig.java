package egen.Restful;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc  //help spring to understand that it's http etc and that it is a web app not a normal java app

//server side app so we use tomcat server

public class AppConfig {

}
