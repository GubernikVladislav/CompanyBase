package ru.gubernik.company.dao.country;

import ru.gubernik.company.model.Country;

import java.util.List;

/**
 * Dao для работы со справочником стран
 */
public interface CountryDao {

    /**
     * Получение списка стран
     * @return список List стран
     */
    List<Country> countries();
}
