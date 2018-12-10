package ru.gubernik.company.controller.office;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gubernik.company.view.office.OfficeListRequestView;
import ru.gubernik.company.view.office.OfficeView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * Контроллер Оффиса
 */
public interface OfficeController {

    /**
     * Получение списка офисов
     * @param requestView - параметры поиска
     * @return список офисов
     */
    DataView offices(@RequestBody OfficeListRequestView requestView);

    /**
     * Получение оффиса по идентификатору
     * @param orgId идентификатор оффиса
     * @return возвращает представление оффиса
     */
    DataView get(@Min(1) @NotNull @PathVariable("orgId") Integer orgId);

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
