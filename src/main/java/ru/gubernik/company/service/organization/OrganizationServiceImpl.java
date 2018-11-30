package ru.gubernik.company.service.organization;

import org.springframework.stereotype.Service;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResponseView;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public ResponseView add(OrganizationView organization) {
        return new ResponseView();
    }

    @Override
    public OrganizationView get() {
        return null;
    }

    @Override
    public ResponseView update(OrganizationView organizationView) {
        return new ResponseView();
    }

    @Override
    public List<OrganizationView> organizations() {
        return null;
    }
}
