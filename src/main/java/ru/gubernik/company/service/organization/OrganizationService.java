package ru.gubernik.company.service.organization;

import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResponseView;

import java.util.List;

public interface OrganizationService {

    /**
     * Добавить новую организацию
     */
    ResponseView add(OrganizationView organizationView);

    /**
     * Получить организацию
     */
    OrganizationView get();

    /**
     * Обновить организацию
     */
    ResponseView update(OrganizationView organizationView);

    /**
     * Получить список организаций
     */
    List<OrganizationView> organizations();
}
