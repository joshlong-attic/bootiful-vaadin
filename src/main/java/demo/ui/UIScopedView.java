package demo.ui;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import demo.model.Reservation;
import demo.service.Greeter;

// pay attention to the order of annotations
@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "ui";

    @Autowired
    private Greeter greeter;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        addComponent(new Label("This is a UI scoped view. Greeter says: " + greeter.sayHello()));
        JPAContainer<Reservation> container = JPAContainerFactory.make(Reservation.class, entityManager);
        Table table = new Table();
        table.setContainerDataSource(container);
        addComponent(table);
        table.setVisibleColumns(new String[] { "reservationName" });
        table.setColumnHeader("reservationName", "Name");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
