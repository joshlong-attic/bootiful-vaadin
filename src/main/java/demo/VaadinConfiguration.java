package demo;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import demo.model.Reservation;
import demo.model.ReservationRepository;
import demo.service.Greeter;

@Configuration
public class VaadinConfiguration {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }

    @Bean
    CommandLineRunner init(ReservationRepository rr){
        return args ->
            Arrays.asList("Richard,Nicolas,Alex,Holger".split(","))
                .forEach( n -> rr.save(new Reservation(n)));
    }
}
