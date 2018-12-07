package ru.gubernik.company.controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gubernik.company.service.country.CountryService;
import ru.gubernik.company.view.country.CountryView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * {@inheritDoc}
 */
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @RequestMapping(value = "/countries", method = {POST})
    public DataView countries() {
        return countryService.countries();
    }
}
