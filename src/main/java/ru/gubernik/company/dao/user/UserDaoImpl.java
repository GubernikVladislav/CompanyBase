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

        //Фильтр по офису
        criteriaQuery.where(criteriaBuilder.equal(root.get("office"), officeId));

        //Фильтр по типу документа
        documentJoin(docCode);

        //Фильтр по гражданству
        countryJoin(citizenshipCode);

        //Фильтр по имени
        addNotNullPredicate("firstName", user.getFirstName());

        //Фильтр по фамилии
        addNotNullPredicate("lastName", user.getLastName());

        //Фильтр по отчеству
        addNotNullPredicate("middleName", user.getMiddleName());

        //Фильтр по должности
        addNotNullPredicate("position", user.getPosition());

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

    /**
     *Выполнение JOIN таблицы справочника стран.
     * @param citizenshipCode - код гражданства из запроса. Если код null - return
     */
    private void countryJoin(String citizenshipCode) {

        if(citizenshipCode == null){
            return;
        }

        Subquery<Country> countrySubQuery = criteriaQuery.subquery(Country.class);
        Root<User> countryRoot = countrySubQuery.correlate(root);
        Join countryJoin = countryRoot.join("country");

        countrySubQuery.select(countryJoin);
        countrySubQuery.where(criteriaBuilder.equal(countryJoin.get("code"), citizenshipCode));
        criteriaQuery.where(criteriaBuilder.exists(countrySubQuery));
    }

    /**
     * Выполнение JOIN таблицы документов
     * @param docCode - код документа из запроса. Если код Null - return
     */
    private void documentJoin(String docCode) {

        if(docCode == null){
            return;
        }

        Subquery<DocType> docQuery = criteriaQuery.subquery(DocType.class);
        Root<User> subRoot = docQuery.correlate(root);
        Join docJoin = subRoot.join("document");
        Join typeJoin = docJoin.join("docType");

        docQuery.select(typeJoin);
        docQuery.where(criteriaBuilder.equal(typeJoin.get("docCode"), docCode));
        criteriaQuery.where(criteriaBuilder.exists(docQuery));
    }

    /**
     * Добавление к запросу предиката, если он не null
     * @param column - атрибут по которому проводится поиск
     * @param value - значение атрибута. Если null - return
     */
    private void addNotNullPredicate(String column, String value){

        if(value == null){
            return;
        }

        Predicate predicate = criteriaBuilder.equal(root.get(column), value);
        criteriaQuery.where(predicate);
    }
}
