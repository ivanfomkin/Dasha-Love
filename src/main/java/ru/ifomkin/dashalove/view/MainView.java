package ru.ifomkin.dashalove.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.ifomkin.dashalove.service.SearchHistoryService;

@Route
@PageTitle("Dasha I love You")
public class MainView extends VerticalLayout {
    private final SearchHistoryService service;

    public MainView(SearchHistoryService service) {
        this.service = service;
        this.setAlignItems(Alignment.CENTER);
        DashaLoveView dashaLoveView = new DashaLoveView(this.service);
        add(
                new H1("Проверим, любит ли Вас Ваня?)"),
                dashaLoveView,
                dashaLoveView.getText());
    }
}
