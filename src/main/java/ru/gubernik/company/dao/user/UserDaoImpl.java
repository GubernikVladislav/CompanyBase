package ru.gubernik.company.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.DocType;
import ru.gubernik.company.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<User> criteriaQuery;
    private Root<User> root;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> users(User user, Integer officeId, String docCode, String citizenshipCode) {

        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(User.class);
        root = criteriaQuery.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        //Фильтр по офису
        Predicate officePredicate = criteriaBuilder.equal(root.get("office"), officeId);
        predicates.add(officePredicate);

        //Фильтр по типу документа
        if(docCode != null) {
            predicates.add(documentJoin(docCode));
        }
        //Фильтр по гражданству
        if(citizenshipCode != null) {
            predicates.add(countryJoin(citizenshipCode));
        }
        //Фильтр по имени
        if(user.getFirstName() != null) {
            predicates.add(addPredicate("firstName", user.getFirstName()));
        }
        //Фильтр по фамилии
        if(user.getLastName() != null) {
            predicates.add(addPredicate("lastName", user.getLastName()));
        }
        //Фильтр по отчеству
        if(user.getMiddleName() != null) {
            predicates.add(addPredicate("middleName", user.getMiddleName()));
        }
        //Фильтр по должности
        if(user.getPosition() != null) {
            predicates.add(addPredicate("position", user.getPosition()));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(Integer id) {

        return entityManager.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    private Predicate countryJoin(String citizenshipCode) {

        Subquery<Country> countrySubQuery = criteriaQuery.subquery(Country.class);
        Root<User> countryRoot = countrySubQuery.correlate(root);
        Join countryJoin = countryRoot.join("country");

        countrySubQuery.select(countryJoin);
        countrySubQuery.where(criteriaBuilder.equal(countryJoin.get("code"), citizenshipCode));

        Predicate countyPredicate = criteriaBuilder.exists(countrySubQuery);
        return countyPredicate;
    }

    private Predicate documentJoin(String docCode) {

        Subquery<DocType> docQuery = criteriaQuery.subquery(DocType.class);
        Root<User> subRoot = docQuery.correlate(root);
        Join docJoin = subRoot.join("document");
        Join typeJoin = docJoin.join("docType");

        docQuery.select(typeJoin);
        docQuery.where(criteriaBuilder.equal(typeJoin.get("docCode"), docCode));

        Predicate docPredicate = criteriaBuilder.exists(docQuery);
        return docPredicate;
    }

    private Predicate addPredicate(String column, String value){

        Predicate predicate = criteriaBuilder.equal(root.get(column), value);
        return predicate;
    }
}
