package ru.gubernik.company.dao.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.Document;

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
    public List<Document> docs() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Document> criteriaQuery = criteriaBuilder.createQuery(Document.class);
        Root<Document> document = criteriaQuery.from(Document.class);
        criteriaQuery.select(document);
        TypedQuery<Document> query = entityManager.createQuery(criteriaQuery);
        List<Document> docs = query.getResultList();

        return docs;
    }


}
