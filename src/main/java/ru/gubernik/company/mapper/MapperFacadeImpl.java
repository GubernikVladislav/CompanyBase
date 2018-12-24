package ru.gubernik.company.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.model.DocType;
import ru.gubernik.company.model.User;
import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

/**
 * {@inheritDoc
 */
@Service
public class MapperFacadeImpl implements MapperFacade {

    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    /**
     * {@inheritDoc
     */
    @Override
    public <O, T> T map(O object, Class<T> target) {
        return mapperFactory.getMapperFacade().map(object, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O, T> void map(O object, T target) {
        mapperFactory.getMapperFacade().map(object, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <L, T> List<T> mapAsList(Iterable<L> list, Class<T> target) {
        return mapperFactory.getMapperFacade().mapAsList(list, target);
    }

    /**
     * {@inheritDoc}
     */
    public UserView userMap(User user, Class<UserView> view){
        mapperFactory.classMap(User.class, UserView.class)
                .field("document.docNumber", "docNumber")
                .field("document.docType.docName", "docName")
                .field("document.docDate", "docDate")
                .field("document.docType.docCode", "docCode")
                .field("country.name", "citizenshipName")
                .field("country.code", "citizenshipCode")
                .field("office.id", "officeId")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(user, UserView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User userViewMap(UserView view, Class<User> user) {
        mapperFactory.classMap(UserView.class, User.class)
                .field("docNumber", "document.docNumber")
                .field("docName", "document.docType.docName")
                .field("docDate", "document.docDate")
                .field("docCode", "document.docType.docCode")
                .field("citizenshipCode", "country.code")
                .field("citizenshipName", "country.name")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(view, User.class);
    }

    public void userViewMap(UserView view, User user) {
        mapperFactory.classMap(UserView.class, User.class)
                .field("docNumber", "document.docNumber")
                .field("docName", "document.docType.docName")
                .field("docDate", "document.docDate")
                .field("docCode", "document.docType.docCode")
                .field("citizenshipCode", "country.code")
                .field("citizenshipName", "country.name")
                .byDefault()
                .register();
        mapperFactory.getMapperFacade().map(view, user);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public List<DocumentView> mapDocList(List<DocType> docList,Class<DocumentView> view){

        mapperFactory.classMap(DocType.class, DocumentView.class)
                .field("docCode", "code")
                .field("docName", "name")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().mapAsList(docList, view);
    }

}
