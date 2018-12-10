package ru.gubernik.company.dao.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.DocType;

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
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager entityManager;

    @Autowired
    public DocumentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocType> docs() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<DocType> criteriaQuery = criteriaBuilder.createQuery(DocType.class);
        Root<DocType> document = criteriaQuery.from(DocType.class);
        criteriaQuery.select(document);
        TypedQuery<DocType> query = entityManager.createQuery(criteriaQuery);
        List<DocType> docs = query.getResultList();

        return docs;
    }


}
