package ru.gubernik.company.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.DocType;
import ru.gubernik.company.model.Document;
import ru.gubernik.company.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> users(User user, Integer officeId, String docCode, String citizenshipCode) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root root = criteriaQuery.from(User.class);

        //Фильтр по офису
        criteriaQuery.where(criteriaBuilder.equal(root.get("office"), officeId));
        //Фильтр по типу документа
        if(docCode != null) {
            Subquery<DocType> docQuery = criteriaQuery.subquery(DocType.class);
            Root subRoot = docQuery.correlate(root);
            Join docJoin = subRoot.join("document");
            Join<Document, DocType> typeJoin = docJoin.join("docType");

            docQuery.select(typeJoin);
            docQuery.where(criteriaBuilder.equal(typeJoin.get("code"), docCode));
            criteriaQuery.where(criteriaBuilder.exists(docQuery));
        }
        //Фильтр по гражданству
        if(citizenshipCode != null) {
            Subquery<Country> countrySubQuery = criteriaQuery.subquery(Country.class);
            Root countryRoot = countrySubQuery.correlate(root);
            Join countryJoin = countryRoot.join("country");

            countrySubQuery.select(countryJoin);
            countrySubQuery.where(criteriaBuilder.equal(countryJoin.get("code"), citizenshipCode));
            criteriaQuery.where(criteriaBuilder.exists(countrySubQuery));
        }
        //Фильтр по имени
        if(user.getFirstName() != null) {
            Predicate firstNamePredicate = criteriaBuilder.equal(root.get("firstName"), user.getFirstName());
            criteriaQuery.where(firstNamePredicate);
        }
        //Фильтр по фамилии
        if(user.getLastName() != null){
            Predicate lastNamePredicate = criteriaBuilder.equal(root.get("lastName"), user.getLastName());
            criteriaQuery.where(lastNamePredicate);
        }
        //Фильтр по отчеству
        if(user.getMiddleName() != null){
            Predicate middleNamePredicate = criteriaBuilder.equal(root.get("middleName"), user.getMiddleName());
            criteriaQuery.where(middleNamePredicate);
        }
        //Фильтр по должности
        if(user.getPosition() != null){
            Predicate positionPredicate = criteriaBuilder.equal(root.get("position"), user.getPosition());
            criteriaQuery.where(positionPredicate);
        }
        TypedQuery query = entityManager.createQuery(criteriaQuery);
        List<User> users = query.getResultList();
        return users;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User get(Integer id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User user) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {

    }
}
