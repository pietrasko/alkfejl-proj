package hu.elte.alkfejl.csaladitodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CsaladiTodoApplication extends WebMvcConfigurerAdapter {
        
        @Autowired
        private HandlerInterceptor authInterceptor;
    
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(authInterceptor);
        }
    
	public static void main(String[] args) {
		SpringApplication.run(CsaladiTodoApplication.class, args);
	}
}
