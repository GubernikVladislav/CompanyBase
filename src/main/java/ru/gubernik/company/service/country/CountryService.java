package ru.gubernik.company.service.country;

import ru.gubernik.company.view.country.CountryView;

import java.util.List;

/**
 * Сервис справочника стран
 */
public interface CountryService {

    /**
     * Получение списка стран
     * @return возвращает List список стран
     */
    List<CountryView> countries();
}
