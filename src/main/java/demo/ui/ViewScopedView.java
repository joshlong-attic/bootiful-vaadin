package demo.ui;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import demo.service.Greeter;
import demo.service.ViewGreeter;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "other-view";


    // a new instance will be created for every view instance
    @Autowired
    private ViewGreeter viewGreeter;

    // the same instance will be used by all views of the UI
    @Autowired
    private Greeter uiGreeter;

    @PostConstruct
    public void init() {
        this.setMargin(true);
        this.setSpacing(true);


        this.addComponent(new Label("This is a view scoped view"));
        this.addComponent(new Label(uiGreeter.sayHello()));
        this.addComponent(new Label(viewGreeter.sayHello()));

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
