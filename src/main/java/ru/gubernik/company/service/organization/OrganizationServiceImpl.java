package ru.gubernik.company.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.organization.OrganizationDao;
import ru.gubernik.company.mapper.MapperFacadeImpl;
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
    private final MapperFacadeImpl mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacadeImpl mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView add(OrganizationView view) {

        Organization organization =
                new Organization(
                        view.name,
                        view.fullName,
                        view.inn,
                        view.kpp,
                        view.address);

        organizationDao.save(organization);

        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView get(int id) {

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
