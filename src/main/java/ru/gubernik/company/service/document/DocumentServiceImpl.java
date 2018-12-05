package ru.gubernik.company.service.document;

import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.document.DocumentDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Document;
import ru.gubernik.company.view.document.DocumentView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private final MapperFacade mapperFacade;
    private final DocumentDao documentDao;

    public DocumentServiceImpl(MapperFacade mapperFacade, DocumentDao documentDao) {
        this.mapperFacade = mapperFacade;
        this.documentDao = documentDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentView> docs() {

        List<Document> documents = documentDao.docs();
        List<DocumentView> views = mapperFacade.mapAsList(documents, DocumentView.class);
        return views;
    }
}
