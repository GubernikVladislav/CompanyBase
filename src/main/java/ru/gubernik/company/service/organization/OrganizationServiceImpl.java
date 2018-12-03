package ru.gubernik.company.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.organization.OrganizationDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Organization;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResultView;

import java.util.List;

/**
 * Реализация сервиса OrganizationService
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
    public ResultView add(OrganizationView view) {

        organizationDao.save(mapperFacade.map(view, Organization.class));

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView get(Integer id) {

        Organization organization = organizationDao.loadById(id);

        return mapperFacade.map(organization, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(OrganizationView organizationView) {

        Organization organization = mapperFacade.map(organizationView, Organization.class);
        organizationDao.updateById(organization.getId(), organization);

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationView> organizations() {
        return mapperFacade.mapAsList(organizationDao.all(), OrganizationView.class);
    }
}
