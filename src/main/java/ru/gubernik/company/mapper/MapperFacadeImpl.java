package ru.gubernik.company.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.model.User;
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
                .field("country.name", "citizenshipName")
                .field("country.code", "citizenshipCode")
                .byDefault()
                .register();
        return mapperFactory.getMapperFacade().map(user, UserView.class);
    }


}
