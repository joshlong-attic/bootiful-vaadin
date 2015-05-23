package demo.ui;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import demo.model.Customer;
import demo.service.Greeter;

// pay attention to the order of annotations
@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
  class UIScopedView extends VerticalLayout implements View {
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
        JPAContainer<Customer> container = JPAContainerFactory.make(Customer.class, entityManager);
        Table table = new Table();
        table.setContainerDataSource(container);
        addComponent(table);
        table.setWidth(100, Unit.PERCENTAGE);
        table.addGeneratedColumn("sayHello", new Table.ColumnGenerator() {
            @Override
            public Object generateCell(Table table, Object itemId, Object propertyId) {
                Item item = table.getItem(itemId);
                Property<String> itemProperty = item.getItemProperty("firstName");
                final String value = itemProperty.getValue();
                Button button = new Button("Say Hello");
                button.addClickListener((event) -> Notification.show("My name is " + value));
                return button;
            }
        });
        table.setColumnHeader("firstName", "First Name");
        table.setColumnHeader("lastName", "Last Name");
        table.setColumnHeader("sayHello", "");
        table.setVisibleColumns(new String[] { "lastName", "firstName", "sayHello"});
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}
