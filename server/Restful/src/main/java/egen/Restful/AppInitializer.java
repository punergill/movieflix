package egen.Restful;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//class to extend dispatcherservlet(to use for front controller that http requests)

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {AppConfig.class, JPAConfig.class};  //configurations
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		
		return new String[] { "/api/*" };
	}
}


