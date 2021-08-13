package ru.ifomkin.dashalove.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import ru.ifomkin.dashalove.service.SearchHistoryService;

@Component
public class DashaLoveView extends HorizontalLayout {
    private final SearchHistoryService service;
    private Text text;

    public DashaLoveView(SearchHistoryService service) {
        this.service = service;
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
        service.save(name);
        if (name == null || name.isEmpty()) {
            return "Введите имя!";
        } else if (checkDariaName(name)) {
            return "Любимая моя, сладкая Зайка! \nПрошло уже полгода с того момента, как мы с тобой \"официально\" вместе. Много это или мало? Не знаю, у каждого свой счёт времени. Давай посмотрим со стороны математики \uD83E\uDDEE \nПол года - это 6 месяцев \nПол года - это 181 день \nПол года - это 4344 часа \nПол года - это 260 640 минут \nПол года - это 15 638 400 секунд! \nЗа это время моё сердце сделало более 18 миллионов ударов. 18 миллионов ударов с мыслью о тебе ❤ \nСимволично, что ровно через полгода мы собираем вещи и едем жить вместе \uD83E\uDD14 Что дальше? Неизвестно... Знаю лишь одно - я тебя люблю и мне с тобой хорошо \uD83D\uDC97 А помнишь?) Мы сидели и пили кофе, ровно 181 день назад, в воздухе висела неловкость... Кто из нас мог тогда предположить, что всё вот так окажется?) Я благодарен судьбе за такой милый подарок мне \uD83E\uDD70 Но ещё больше я благодарен тебе, просто за то что ты есть \uD83D\uDE18 За твою нежность и ласку, за твои сюрпризы и твою непредсказуемость \uD83D\uDC95 Я просто тебя люблю, моя дорогая \uD83D\uDC98 Знай это всегда. \nС любовью \nТвой Ваня \uD83E\uDD17";
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
