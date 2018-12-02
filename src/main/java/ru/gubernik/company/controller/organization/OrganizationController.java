package ru.gubernik.company.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.organization.OrganizationService;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.ResponseView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получить список всех организаций
     * @return
     */
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> organizations(){
        return organizationService.organizations();
    }

    /**
     * Получить организацию по id
     * @param org_id
     * @return
     */
    @RequestMapping(value = "/{id:[\\d]+}", method = {GET})
    public OrganizationView get(@PathVariable("id") int org_id){
        return organizationService.get();
    }

    /**
     * Обновить организацию
     * @param organizationView
     */
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView update(@RequestBody OrganizationView organizationView){
        return organizationService.update(organizationView);
    }

    /**
     * Добавить новую организацию
     * @param organizationView
     * @return
     */
    @RequestMapping(value = "/save", method = {POST})
    public ResponseView save(@RequestBody OrganizationView organizationView){
        return organizationService.add(organizationView);
    }
}