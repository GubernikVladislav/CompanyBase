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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.view.office.OfficeListView;
import ru.gubernik.company.view.office.OfficeView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ErrorView;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Тестирование контроллера офисов
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@DirtiesContext
@Transactional
public class OfficeControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8888/api/office";

    /**
     * Тестирование добавления нового офиса
     */
    @Test
    public void saveTest(){

        OfficeView request =
                new OfficeView(1, "testOffice", "testAddress", "+79166987731", true);

        ResponseEntity<ResultView> response = restTemplate.postForEntity(url + "/save", request, ResultView.class);
        assertNotNull(response);

        request.id = getId(request);
        getTest(request);
    }

    /**
     * Проверка неправильного добавления. На выходе должна быть ошибка
     */
    @Test
    public void errorSaveTest(){

        OfficeView request =
                new OfficeView(1, null, "testAddress", "+79166987731", true);

        ResponseEntity<ErrorView> response = restTemplate.postForEntity(url + "/save", request, ErrorView.class);
        assertNotNull(response);

        ErrorView error = response.getBody();
        assertNotNull(error);
    }

    /**
     * Тестирование обновления офиса
     */
    @Test
    public void updateTest(){
        //Добавление офиса
        OfficeView request =
                new OfficeView(1, "test", "test", "+79166987731", true);
        ResponseEntity<ErrorView> response = restTemplate.postForEntity(url + "/save", request, ErrorView.class);
        assertNotNull(response);
        request.id = getId(request);

        //Обновление добавленного офиса
        OfficeView updateRequest =
                new OfficeView(1, "testUPD", "testUPD", "+79166987731", true);
        updateRequest.id = request.id;
        ResponseEntity<ResultView> updateResponse = restTemplate.postForEntity(url + "/update", updateRequest, ResultView.class);
        assertNotNull(updateResponse);

        //Проверка обновления
        getTest(updateRequest);
    }

    /**
     * Проверка получения офиса по идентификатору
     * @param view - объект с параметрами для сравнения
     */
    public void getTest(OfficeView view){

        ParameterizedTypeReference<DataView<OfficeView>> reference =
                new ParameterizedTypeReference<DataView<OfficeView>>(){};

        ResponseEntity<DataView<OfficeView>> response = restTemplate.exchange(url + "/" + view.id,HttpMethod.GET,null, reference);
        assertNotNull(response);

        DataView<OfficeView> responseData = response.getBody();
        assertNotNull(responseData);

        assertThat(responseData.data.id, is(view.id));
        assertThat(responseData.data.orgId, is(view.orgId));
        assertThat(responseData.data.name, is(view.name));
        assertThat(responseData.data.address, is(view.address));
        assertThat(responseData.data.phone, is(view.phone));
        assertThat(responseData.data.isActive, is(view.isActive));
    }

    /**
     * Получение идентификатора офиса из списка офисов
     * @param view - объект с параметрами фильтра офисов
     * @return - идентификатор офиса
     */
    public Integer getId(OfficeView view){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = view.toString();
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);

        ParameterizedTypeReference<DataView<List<OfficeListView>>> reference =
                new ParameterizedTypeReference<DataView<List<OfficeListView>>>(){};

        ResponseEntity<DataView<List<OfficeListView>>> response =
                restTemplate.exchange(url + "/list", HttpMethod.POST, httpEntity, reference);
        assertNotNull(response);

        DataView<List<OfficeListView>> data = response.getBody();
        assertNotNull(data);

        Integer id = data.data.get(0).id;
        return id;

    }

}
