package ru.gubernik.company.dao.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> all(Organization organization) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> root = criteriaQuery.from(Organization.class);
        criteriaQuery.select(root);

        //Фильтр по наименованию
        if(organization.getName() != null) {
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), organization.getName()));
        }
        //Фильтр по ИНН
        if(organization.getInn() != null){
            criteriaQuery.where(criteriaBuilder.equal(root.get("inn"), organization.getInn()));
        }
        //Фильтр по статусу
        if(organization.getIsActive() != null){
            criteriaQuery.where(criteriaBuilder.equal(root.get("isActive"), organization.getIsActive()));
        }

        TypedQuery<Organization> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
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
    public void update(Organization organization) {
        entityManager.merge(organization);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }
}
