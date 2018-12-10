package ru.gubernik.company.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gubernik.company.dao.organization.OrganizationDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Organization;
import ru.gubernik.company.view.organization.OrganizationListView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView add(OrganizationView view) {

        organizationDao.save(mapperFacade.map(view, Organization.class));

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView get(Integer id) {

        Organization organization = organizationDao.loadById(id);

        return new DataView<OrganizationView>(mapperFacade.map(organization, OrganizationView.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView update(OrganizationView organizationView) {

        Organization organization = organizationDao.loadById(organizationView.id);
        mapperFacade.map(organizationView, organization);

        organizationDao.update(organization);

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView organizations() {
        return new DataView<List<OrganizationListView>>(mapperFacade.mapAsList(organizationDao.all(),
                                                                        OrganizationListView.class));
    }
}
