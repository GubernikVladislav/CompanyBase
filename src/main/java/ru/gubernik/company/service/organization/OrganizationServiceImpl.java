package ru.gubernik.company.service.organization;

import org.springframework.stereotype.Service;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResultView;

import java.util.List;

/**
 * Реализация сервиса OrganizationService
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView add(OrganizationView organization) {
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationView get(int id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(OrganizationView organizationView) {
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationView> organizations() {
        return null;
    }
}
