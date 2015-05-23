package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// https://vaadin.com/wiki?p_p_id=36&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=row-1&p_p_col_pos=1&p_p_col_count=3&_36_struts_action=%2Fwiki%2Fview&p_r_p_185834411_nodeName=vaadin.com+wiki&p_r_p_185834411_title=II+-+Injection+and+Scopes+with+Vaadin+Spring
@SpringBootApplication
public class DemoApplication {




    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

