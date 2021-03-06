package ru.gubernik.company.controller.organization;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.organization.OrganizationService;
import ru.gubernik.company.view.organization.Views;
import ru.gubernik.company.view.organization.OrganizationListView;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@Validated
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
    public DataView organizations(@RequestBody OrganizationListView organizationListView){
        return organizationService.organizations(organizationListView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/{id:[\\d]+}", method = {GET})
    public DataView get(@PathVariable("id") @Min(1) Integer id){
        return organizationService.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResultView update(@NotNull @RequestBody OrganizationView organizationView){
        return organizationService.update(organizationView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResultView save(@NotNull @RequestBody OrganizationView organizationView){
        return organizationService.add(organizationView);
    }
}
