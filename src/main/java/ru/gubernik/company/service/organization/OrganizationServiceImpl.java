package ru.gubernik.company.service.organization;

import org.springframework.stereotype.Service;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResultView;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public ResultView add(OrganizationView organization) {
        return new ResultView();
    }

    @Override
    public OrganizationView get(int id) {
        return null;
    }

    @Override
    public ResultView update(OrganizationView organizationView) {
        return new ResultView();
    }

    @Override
    public List<OrganizationView> organizations() {
        return null;
    }
}
