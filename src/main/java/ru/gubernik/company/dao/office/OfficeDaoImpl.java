package ru.gubernik.company.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.office.OfficeListRequestView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager entityManager;

    @Autowired
    public OfficeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> offices(OfficeListRequestView office) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> root = criteriaQuery.from(Office.class);
        criteriaQuery.select(root);

        //Создание предикатов по переданым параметрам
        Predicate predicate = criteriaBuilder.equal(root.get("organization"), office.orgId);
        Predicate namePredicate = criteriaBuilder.equal(root.get("name"), office.name);
        Predicate phonePredicate = criteriaBuilder.equal(root.get("phone"), office.phone);
        Predicate activePredicate = criteriaBuilder.equal(root.get("isActive"), office.isActive);

        //Доюавление not null предикатов в запрос
        criteriaQuery.where(predicate);
        if(office.name != null) {
            criteriaQuery.where(namePredicate);
        }
        if(office.phone != null){
            criteriaQuery.where(phonePredicate);
        }
        if(office.isActive != null){
            criteriaQuery.where(activePredicate);
        }

        TypedQuery<Office> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office get(Integer id) {
        return entityManager.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Office view) {
        entityManager.merge(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        entityManager.persist(office);
    }
}
