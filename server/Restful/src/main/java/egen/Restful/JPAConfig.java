package egen.Restful;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration   
@EnableTransactionManagement //to do transactions(when we write on db ie create any table, entries etc
public class JPAConfig {     //to not use xml(persistence.xml but java
    
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(datasource());    //whole jdbc info
	    emf.setPackagesToScan("egen.Restful.entity", "egen.Restful.TitlesEntity" , "egen.Restful.CommentsEntity","egen.Restful.RatingsEntity");   //where entities are located
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
	    emf.setJpaProperties(jpaProperties());
	    
	return emf;
	
	}
	
	@Bean
	public DataSource datasource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUrl("jdbc:mysql://localhost:3306/user-db?useSSL=false");
	    ds.setUsername("root");
	    ds.setPassword("root");
	    return ds;
	
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf){
		JpaTransactionManager txnManager = new JpaTransactionManager(emf);
	  return txnManager;
	}
	
	private Properties jpaProperties(){
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE); //values like in xml file
	   props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING, "false");
		return props;
	}
}
