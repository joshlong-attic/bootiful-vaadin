package demo.service;

import org.springframework.stereotype.Service;
import com.vaadin.spring.annotation.UIScope;

@Service
@UIScope
public class Greeter {

    public String sayHello() { // custom state unique to each tab
        return "Hello from bean " + this.toString();
    }
}
