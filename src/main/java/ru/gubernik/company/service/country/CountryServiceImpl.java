package ru.gubernik.company.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.country.CountryDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.view.country.CountryView;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao, MapperFacade mapperFacade) {
        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<CountryView> countries() {
        return mapperFacade.mapAsList(countryDao.countries(), CountryView.class);
    }
}
