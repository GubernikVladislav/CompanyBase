package ru.gubernik.company.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public <L, T> List<T> mapAsList(Iterable<L> list, Class<T> target) {
        return mapperFactory.getMapperFacade().mapAsList(list, target);
    }
}
