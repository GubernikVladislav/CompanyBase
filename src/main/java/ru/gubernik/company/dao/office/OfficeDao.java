package ru.gubernik.company.dao.office;

import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.ResultView;

import java.util.List;

/**
 * Dao для работы с талицей оффисов
 */
public interface OfficeDao {

    /**
     * Получение списка оффисов по идентификатору организации
     * @param id идентификатор организации
     * @return список оффисов
     */
    List<Office> offices(Integer id);

    /**
     * Получить оффис по идентификатору
     * @param id идентификтор оффиса
     * @return представление оффиса
     */
    Office get(Integer id);

    /**
     * Обновить оффис по заданным параметрам
     * @param view - объект содержащий обновленные параметры
     * @return {"result":"success"}
     */
    ResultView update(Office view);

    /**
     * Добавить оффис по заданным параметрам
     * @param view - объект содержащий параметры добавляемого оффиса
     * @return {"result":"success"}
     */
    ResultView save(Office view);
}