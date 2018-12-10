package ru.gubernik.company.service.document;

import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.document.DocumentDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.DocType;
import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.source.DataView;

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
    public DataView docs() {

        List<DocType> docTypes = documentDao.docs();
        List<DocumentView> views = mapperFacade.mapAsList(docTypes, DocumentView.class);
        return new DataView<List<DocumentView>>(views);
    }
}
