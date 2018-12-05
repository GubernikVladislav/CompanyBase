package ru.gubernik.company.controller.organization;

import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.organization.OrganizationView;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Контроллер организации
 */
public interface OrganizationController {

    /**
     * Получить список всех организаций
     * @return List список организаций
     */
    List<OrganizationView> organizations();

    /**
     * Получить организацию по id
     * @param orgId принимаемое значение - идентификатор организации (id)
     * @return OrganizationView Возвращает организацию
     */
    OrganizationView get(@Min(1) Integer orgId);

    /**
     * Обновить организацию
     * @param organizationView принимает обьект, считанный из HTTP запроса
     * @return Возвращает результат выполнения {"result":"success"} если выполнено обновление
     */
    ResultView update(@NotNull OrganizationView organizationView);

    /**
     * Добавить новую организацию
     * @param organizationView принимает обьект, считанный из HTTP запроса
     * @return Возвращает результат выполнения {"result":"success"} если выполнено добавление
     */
    ResultView save(@NotNull OrganizationView organizationView);
}
