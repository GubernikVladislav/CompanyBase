package ru.gubernik.company.controller.country;

import ru.gubernik.company.view.country.CountryView;

import java.util.List;

/**
 * Контроллер справочника стран
 */
public interface CountryController {

    /**
     * Получение справочника стран
     * @return List список стран
     */
    List<CountryView> countries();
}
