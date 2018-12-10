package ru.gubernik.company.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gubernik.company.dao.office.OfficeDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Office;
import ru.gubernik.company.view.office.OfficeListRequestView;
import ru.gubernik.company.view.office.OfficeListView;
import ru.gubernik.company.view.office.OfficeView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;

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
    @Transactional
    public ResultView add(OfficeView view) {

        officeDao.save(mapperFacade.map(view, Office.class));
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView update(OfficeView view) {

        Office office = officeDao.get(view.id);
        mapperFacade.map(view, office);
        officeDao.update(office);
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
    public DataView offices(OfficeListRequestView view) {

        return new DataView<List<OfficeListView>>(mapperFacade.mapAsList(officeDao.offices(view), OfficeListView.class));
    }
}
