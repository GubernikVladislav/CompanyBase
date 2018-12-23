package ru.gubernik.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Тестирование контроллера справочника документов
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
public class DocumentControllerTest {

    String url = "http://localhost:8888/api";
    RestTemplate restTemplate = new RestTemplate();

    /**
     * Тестирование получение списка из справочника документов.
     * Полученный список сравнивается с данными из файла src/main/resources/data.sql
     */
    @Test
    public void listTest(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(headers);

        ParameterizedTypeReference<DataView<List<DocumentView>>> reference =
                new ParameterizedTypeReference<DataView<List<DocumentView>>>(){};

        ResponseEntity<DataView<List<DocumentView>>> response =
                restTemplate.exchange(url + "/docs", HttpMethod.POST, httpEntity, reference);
        assertNotNull(response);

        DataView<List<DocumentView>> responseData = response.getBody();
        assertNotNull(responseData);
    }
}
