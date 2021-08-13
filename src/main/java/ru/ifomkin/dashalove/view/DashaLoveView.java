package ru.ifomkin.dashalove.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.lang.NonNull;

public class DashaLoveView extends HorizontalLayout {
    private Text text;

    public DashaLoveView() {
        TextField textField = new TextField();
        textField.setPlaceholder("Введите имя");
        textField.setAutofocus(true);

        text = new Text("");

        Button knowButton = new Button("Узнать");
        knowButton.addClickShortcut(Key.ENTER);
        knowButton.addClickListener(click -> text.setText(checkResult(textField.getValue())));

        add(textField, knowButton);
    }

    private String checkResult(String name) {
        if (name == null || name.isEmpty()) {
            return "Введите имя!";
        } else if (checkDariaName(name)) {
            return "Дорогая моя зайка! \nЯ очень тебя люблю!";
        } else {
            return "Извините, " + name + ", но Ваня любит Дашу ☺ \nЯ уверен, вы тоже классный человек и вы обретёте любовь всей своей жизни (если, конечно, ещё этого не сделали). Удачи Вам\uD83D\uDE0A ";
        }
    }

    private boolean checkDariaName(@NonNull String name) {
        return name.equalsIgnoreCase("Даша")
                || name.equalsIgnoreCase("Дарья")
                || name.equalsIgnoreCase("Дашка")
                || name.equalsIgnoreCase("Дашутка")
                || name.equalsIgnoreCase("Дашенька")
                || name.equalsIgnoreCase("Дария")
                || name.equalsIgnoreCase("Дашкевич")
                || name.equalsIgnoreCase("Даша Феофанова")
                || name.equalsIgnoreCase("Дарья Феофанова")
                || name.equalsIgnoreCase("Феофанова Дарья")
                || name.equalsIgnoreCase("Феофанова Даша");
    }

    public Text getText() {
        return text;
    }
}
