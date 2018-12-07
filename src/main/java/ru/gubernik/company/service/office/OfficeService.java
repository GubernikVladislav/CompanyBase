package ru.gubernik.company.service.office;

import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.office.OfficeView;

import java.util.List;

public interface OfficeService {

    /**
     * Добавить новый оффис
     * @param view объект оффиса
     * @return resultView
     */
    ResultView add(OfficeView view);

    /**
     * Обновить организацию
     * @param view объект оффиса
     * @return resultView
     */
    ResultView update(OfficeView view);

    /**
     * Получить оффис по идентификатору
     * @param id идентификатор оффиса
     * @return возвращает представление оффиса
     */
    DataView get(Integer id);

    /**
     * Получить список оффисов по идентификатору организации
     * @param id идентификатор организации
     * @return возвращает список List оффисов
     */
    DataView offices(Integer id);
}
