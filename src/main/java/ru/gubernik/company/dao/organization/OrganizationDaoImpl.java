package ru.gubernik.company.dao.organization;


import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Organization;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Реализация интерфейса OrganizationDao
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Integer id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateById(Integer id, Organization organization) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }
}
