package ru.gubernik.company.controller.office;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.office.OfficeView;

import java.util.List;


/**
 * Контроллер Оффиса
 */
public interface OfficeController {

    /**
     * Получение списка оффисов организации
     * @param id идентификатор организации
     * @return возвращает List список оффисов
     */
    List<OfficeView> offices(@PathVariable("id") Integer id);

    /**
     * Получение оффиса по идентификатору
     * @param id идентификатор оффиса
     * @return возвращает представление оффиса
     */
    OfficeView get(@PathVariable("id") Integer id);

    /**
     * Обновление оффиса
     * @param view принимает объект считанный из HTTP запроса
     * @return возвращает результат {"result":"success"} если произведенно обновление
     */
    ResultView update(@RequestBody OfficeView view);

    /**
     * Добавление оффиса
     * @param view принимает объект считанный из HTTP запроса
     * @return возвращает результат {"result":"success"} если произведенно обновление
     */
    ResultView save(@RequestBody OfficeView view);
}
