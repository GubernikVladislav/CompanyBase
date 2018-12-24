package ru.gubernik.company.service.document;

import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.document.DocTypeDao;
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
    private final DocTypeDao docTypeDao;

    public DocumentServiceImpl(MapperFacade mapperFacade, DocTypeDao docTypeDao) {
        this.mapperFacade = mapperFacade;
        this.docTypeDao = docTypeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView docs() {

        List<DocType> docTypes = docTypeDao.docs();
        List<DocumentView> views = mapperFacade.mapDocList(docTypes, DocumentView.class);
        return new DataView<List<DocumentView>>(views);
    }
}
