package ru.gubernik.company.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.ResultView;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Сервис организации
 */
@Validated
public interface OrganizationService {

    /**
     * Добавить новую организацию
     * @param organizationView
     * @return {"result":"success"}
     */
    ResultView add(@Valid OrganizationView organizationView);

    /**
     * Получить организацию
     * @param id идентификатор организации
     * @return organizationView
     */
    DataView get(@Min(1) Integer id);

    /**
     * Обновить организацию
     * @param view
     * @return {"result":"success"}
     */
    ResultView update(@Valid OrganizationView view);

    /**
     * Получить список организаций
     * @return List список всех организаций
     */
    DataView organizations();
}
