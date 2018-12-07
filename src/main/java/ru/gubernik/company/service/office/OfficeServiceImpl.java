package ru.gubernik.company.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.office.OfficeDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.office.OfficeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final MapperFacade mapperFacade;
    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(MapperFacade mapperFacade, OfficeDao officeDao) {
        this.mapperFacade = mapperFacade;
        this.officeDao = officeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView add(OfficeView view) {

        officeDao.save(mapperFacade.map(view, Office.class));
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(OfficeView view) {

        officeDao.update(mapperFacade.map(view, Office.class));
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView get(Integer id) {

        Office office = officeDao.get(id);
        OfficeView view = mapperFacade.map(office, OfficeView.class);
        return new DataView<OfficeView>(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView offices(Integer id) {

        List<Office> offices = officeDao.offices(id);
        List<OfficeView> views = mapperFacade.mapAsList(offices, OfficeView.class);

        return new DataView<List<OfficeView>>(views);
    }
}
