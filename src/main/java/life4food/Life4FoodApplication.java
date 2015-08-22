package life4food;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Life4FoodApplication {
	
	@Inject DataInitlizer dataInitializer;
	
    public static void main(String[] args) {
        SpringApplication.run(Life4FoodApplication.class, args);
    }
    
    @PostConstruct
    void postConstrct() {
    	dataInitializer.insertAll();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }
}