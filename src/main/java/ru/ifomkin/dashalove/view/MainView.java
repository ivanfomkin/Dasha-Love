package ru.ifomkin.dashalove.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route
@PageTitle("Dasha I love You")
public class MainView extends VerticalLayout {
    public MainView() {
        this.setAlignItems(Alignment.CENTER);
        DashaLoveView dashaLoveView = new DashaLoveView();
        add(
                new H1("Проверим, любит ли Вас Ваня?)"),
                dashaLoveView,
                dashaLoveView.getText());
    }
}
