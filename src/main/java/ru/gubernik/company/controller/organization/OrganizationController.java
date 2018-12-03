package ru.gubernik.company.controller.organization;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.organization.OrganizationView;

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
     * @param org_id принимаемое значение - идентификатор организации (id)
     * @return OrganizationView Возвращает организацию
     */
    OrganizationView get(@PathVariable("id") Integer org_id);

    /**
     * Обновить организацию
     * @param organizationView принимает обьект, считанный из HTTP запроса
     * @return Возвращает результат выполнения {"result":"success"} если выполнено обновление
     */
    ResultView update(@RequestBody OrganizationView organizationView);

    /**
     * Добавить новую организацию
     * @param organizationView принимает обьект, считанный из HTTP запроса
     * @return Возвращает результат выполнения {"result":"success"} если выполнено добавление
     */
    ResultView save(@RequestBody OrganizationView organizationView);
}
