package ru.gubernik.company.service.country;

import org.springframework.stereotype.Service;
import ru.gubernik.company.view.country.CountryView;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public List<CountryView> countries() {
        return null;
    }
}
