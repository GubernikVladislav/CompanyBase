package ru.gubernik.company;

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
import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        assertThat(responseData.data.get(0).code, is("08"));
        assertThat(responseData.data.get(0).name, is("Временное удостоверение, выданное взамен военного билета"));

        assertThat(responseData.data.get(1).code, is("18"));
        assertThat(responseData.data.get(1).name, is("Свидетельство о предоставлении временного убежища на территории Российской Федерации"));

        assertThat(responseData.data.get(2).code, is("21"));
        assertThat(responseData.data.get(2).name, is("Паспорт гражданина Российской Федерации"));

    }
}