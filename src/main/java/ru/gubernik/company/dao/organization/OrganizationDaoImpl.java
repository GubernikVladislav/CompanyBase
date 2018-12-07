package ru.gubernik.company.dao.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Organization;
import ru.gubernik.company.view.source.ResultView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
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
    public List<Organization> all() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = criteriaBuilder.createQuery(Organization.class);
        Root<Organization> organization = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organization);
        TypedQuery<Organization> query = entityManager.createQuery(criteriaQuery);
        List<Organization> organizations = query.getResultList();

        return organizations;
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
    public ResultView update(Organization organization) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Organization> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Organization.class);
        Root<Organization> root = criteriaUpdate.from(Organization.class);

        criteriaUpdate.set("name", organization.getName());
        criteriaUpdate.set("fullName", organization.getFullName());
        criteriaUpdate.set("inn", organization.getInn());
        criteriaUpdate.set("kpp", organization.getKpp());
        criteriaUpdate.set("address", organization.getAddress());
        if(organization.getPhone() != null) {
            criteriaUpdate.set("phone", organization.getPhone());
        }
        if(organization.getIsActive() != null) {
            criteriaUpdate.set("isActive", organization.getIsActive());
        }

        Predicate predicate = criteriaBuilder.equal(
                root.get("id"), organization.getId());

        criteriaUpdate.where(predicate);

        entityManager.createQuery(criteriaUpdate).executeUpdate();

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView save(Organization organization) {
        entityManager.persist(organization);

        return new ResultView();
    }
}
