package ru.gubernik.company.dao.country;

import ru.gubernik.company.model.Country;
import ru.gubernik.company.view.country.CountryView;

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

    /**
     * Получение страны из списка
     * @param country
     * @return
     */
    Country get(String countryCode);
}
