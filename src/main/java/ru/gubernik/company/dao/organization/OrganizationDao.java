package ru.gubernik.company.dao.organization;

import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Organization;

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
    List<Organization> all();

    /**
     * Получить организацю по id
     * @param id - идентификатор организации
     * @return возвращает организацию
     */
    Organization loadById(Integer id);

    /**
     * Обновление организации по id
     * @param id идентификатор организации
     * @param organization обновленная организация
     */
    void updateById(Integer id, Organization organization);

    /**
     * Добавление организации
     * @param organization организация
     */
    void save(Organization organization);
}
