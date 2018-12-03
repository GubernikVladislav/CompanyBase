package ru.gubernik.company.service.organization;

import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResultView;

import java.util.List;

/**
 * Сервис организации
 */
public interface OrganizationService {

    /**
     * Добавить новую организацию
     * @param organizationView
     * @return {"result":"success"}
     */
    ResultView add(OrganizationView organizationView);

    /**
     * Получить организацию
     * @param id идентификатор организации
     * @return organizationView
     */
    OrganizationView get(int id);

    /**
     * Обновить организацию
     * @param view
     * @return {"result":"success"}
     */
    ResultView update(OrganizationView view);

    /**
     * Получить список организаций
     * @return List список всех организаций
     */
    List<OrganizationView> organizations();
}
