package ru.gubernik.company.controller.office;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.office.OfficeView;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Контроллер Оффиса
 */
public interface OfficeController {

    /**
     * Получение списка оффисов организации
     * @param orgId идентификатор организации
     * @return возвращает List список оффисов
     */
    DataView offices(@Min(1) @NotNull @PathVariable("org_id") Integer orgId);

    /**
     * Получение оффиса по идентификатору
     * @param orgId идентификатор оффиса
     * @return возвращает представление оффиса
     */
    DataView get(@Min(1) @NotNull @PathVariable("org_id") Integer orgId);

    /**
     * Обновление оффиса
     * @param view принимает объект считанный из HTTP запроса
     * @return возвращает результат {"result":"success"} если произведенно обновление
     */
    ResultView update(@NotNull @RequestBody OfficeView view);

    /**
     * Добавление оффиса
     * @param view принимает объект считанный из HTTP запроса
     * @return возвращает результат {"result":"success"} если произведенно обновление
     */
    ResultView save(@NotNull @RequestBody OfficeView view);
}
