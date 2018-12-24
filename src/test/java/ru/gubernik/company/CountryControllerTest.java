package ru.gubernik.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.view.country.CountryView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Тестирование контроллера справочника стран
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
public class CountryControllerTest {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Получение списка стран
     */
    @Test
    public void countriesTest(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ParameterizedTypeReference<DataView<List<CountryView>>> reference =
                new ParameterizedTypeReference<DataView<List<CountryView>>>(){};

        String url = "http://localhost:8888/api/countries";
        ResponseEntity<DataView<List<CountryView>>> response =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, reference);
        Assert.assertNotNull(response);

        DataView<List<CountryView>> responseData = response.getBody();
        Assert.assertNotNull(responseData);
        Assert.assertThat(responseData.data.get(0).code, is("643"));
        Assert.assertThat(responseData.data.get(0).name, is("Российская Федерация"));
    }
}
