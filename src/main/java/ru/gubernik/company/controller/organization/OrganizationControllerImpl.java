package ru.gubernik.company.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.organization.OrganizationService;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> organizations(){
        return organizationService.organizations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/{id:[\\d]+}", method = {GET})
    public OrganizationView get(@PathVariable("id") Integer org_id){
        return organizationService.get(org_id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResultView update(@RequestBody OrganizationView organizationView){
        return organizationService.update(organizationView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResultView save(@RequestBody OrganizationView organizationView){
        return organizationService.add(organizationView);
    }
}
