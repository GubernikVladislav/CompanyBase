package ru.gubernik.company.controller.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.office.OfficeService;
import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.office.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/list/{org_id:[\\d]+}", method = {POST})
    public List<OfficeView> offices(@PathVariable("org_id") Integer org_id) {
        return officeService.offices(org_id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/{id:[\\d]+}", method = {GET})
    public OfficeView get(@PathVariable Integer id) {
        return officeService.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResultView update(OfficeView view) {
        return officeService.update(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/save", method = {POST})
    public ResultView save(OfficeView view) {
        return officeService.add(view);
    }
}
