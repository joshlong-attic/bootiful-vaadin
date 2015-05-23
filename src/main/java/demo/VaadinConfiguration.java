package demo;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import demo.model.Customer;
import demo.model.CustomerRepository;
import demo.service.Greeter;

@Configuration
public class VaadinConfiguration {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }

    @Bean
    CommandLineRunner init(CustomerRepository rr){
        return args ->
            Arrays.asList("Nicolas,Frankel", "Josh,Long", "Richard,Warburton", "John,Davies")
                .stream()
                .map(n -> n.split(","))
                .forEach(n -> rr.save(new Customer(n[0], n[1])));
    }
}
