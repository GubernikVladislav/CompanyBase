package ru.gubernik.company.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.view.country.CountryView;

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
public class CountryDaoImpl implements CountryDao {

    private final EntityManager entityManager;

    @Autowired
    public CountryDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<Country> countries() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
        Root<Country> country = criteriaQuery.from(Country.class);
        criteriaQuery.select(country);
        TypedQuery<Country> query = entityManager.createQuery(criteriaQuery);
        List<Country> countries = query.getResultList();

        return countries;
    }

    @Override
    public Country get(String countryCode) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
        Root<Country> root = criteriaQuery.from(Country.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("code"), countryCode));
        TypedQuery<Country> query = entityManager.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
