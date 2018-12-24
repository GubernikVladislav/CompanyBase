package ru.gubernik.company.dao.organization;

import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Organization;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

/**
 * DAO для работы с Organization
 */
@Repository
public interface OrganizationDao {

    /**
     * Получить список организаций
     * @return List список организаций
     */
    List<Organization> all(Organization organization);

    /**
     * Получить организацю по id
     * @param id - идентификатор организации
     * @return возвращает организацию
     */
    Organization loadById(Integer id);

    /**
     * Обновление организации по id
     * @param organization обновленная организация
     */
    void update(Organization organization);

    /**
     * Добавление организации
     * @param organization организация
     */
    void save(Organization organization);
}
