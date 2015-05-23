package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.vaadin.spring.annotation.UIScope;
import demo.service.Greeter;
import demo.service.ViewGreeter;

@Configuration
public class VaadinConfiguration {

    @Bean
    @UIScope
    public Greeter greeter() {
        return new Greeter();
    }

    @Bean
    @UIScope
    public ViewGreeter viewGreeter() {
        return new ViewGreeter();
    }
}
