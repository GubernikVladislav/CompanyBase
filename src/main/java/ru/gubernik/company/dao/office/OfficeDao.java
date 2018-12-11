package ru.gubernik.company.dao.office;

import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.office.OfficeListRequestView;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

/**
 * Dao для работы с талицей оффисов
 */
public interface OfficeDao {

    /**
     * Получение списка оффисов по передаваемым параметрам
     * @param office объект с параметрами поиска организации
     * @return список оффисов
     */
    List<Office> offices(Office office, Integer orgId);

    /**
     * Получить оффис по идентификатору
     * @param id идентификтор оффиса
     * @return представление оффиса
     */
    Office get(Integer id);

    /**
     * Обновить оффис по заданным параметрам
     * @param view - объект содержащий обновленные параметры
     */
    void update(Office view);

    /**
     * Добавить оффис по заданным параметрам
     * @param view - объект содержащий параметры добавляемого оффиса
     */
    void save(Office view);
}
