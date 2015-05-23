package demo.service;

import org.springframework.stereotype.Service;
import com.vaadin.spring.annotation.ViewScope;

public class ViewGreeter {

    public String sayHello() {
        return "Hello from a view scoped bean " + toString();
    }
}
