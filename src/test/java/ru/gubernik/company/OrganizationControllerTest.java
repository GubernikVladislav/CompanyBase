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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.view.organization.OrganizationListView;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ErrorView;
import ru.gubernik.company.view.source.ResultView;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


/**
 * Проверка контроллера органицзаций
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@Transactional
@DirtiesContext
public class OrganizationControllerTest {

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8888/api";

    /**
     * Проверка на сохранение организации
     */
    @Test
    public void saveTest(){

        OrganizationView request =
                new OrganizationView(null, "test", "TestTest", "123456777890",
                        "123456788", "address", "9166987731", false);

        ResponseEntity response = restTemplate.postForEntity(url + "/organization/save", request, ResultView.class);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        request.id = getId(new OrganizationListView(request.name, request.inn, request.isActive));

        getTest(request);

    }

    /**
     * Проверка на неправильнное сохранение организации. На выходе должна быть ошибка
     */
    @Test
    public void errorSaveTest() {
        //Добавление пустой организации
        OrganizationView nullRequest = new OrganizationView();

        ResponseEntity nullResponse = restTemplate.postForEntity(url + "/organization/save", nullRequest, ErrorView.class);
        assertNotNull(nullResponse);
        assertEquals(nullResponse.getStatusCodeValue(), 200);

        ErrorView nullError = (ErrorView) nullResponse.getBody();
        assertNotNull(nullError);
        assertThat(nullError.error, containsString("cannot be null"));

        //Добавление организации с буквами в ИНН и КПП
        OrganizationView badRequest = new OrganizationView(null, "test", "TestTest", "123456777u90", "111u11111", "adress", null, true);

        ResponseEntity badResponse = restTemplate.postForEntity(url + "/organization/save", badRequest, ErrorView.class);
        assertNotNull(badResponse);
        assertEquals(badResponse.getStatusCodeValue(), 200);

        ErrorView badError = (ErrorView) badResponse.getBody();
        assertNotNull(badError);
        assertThat(badError.error, containsString("only numbers"));
    }

    /**
     * Проверка обновления организации
     */
    @Test
    public void updateTest(){

        OrganizationView organization =
                new OrganizationView(2, "testUPD", "testTestUPD", "111111111111",
                        "111111111","testAddressUPD", "7916698773", false);

        ResponseEntity<ResultView> result = restTemplate.postForEntity(url + "/organization/update", organization, ResultView.class);
        assertNotNull(result);

        getTest(organization);
    }

    /**
     *Проверка игнорирования Null значений при обновлении
     */
    @Test
    public void ignoreNullUpdateTest(){
        OrganizationView organization =
                new OrganizationView(2, "testUPD2", "testTestUPD2", "111111111111",
                        "111111111","testAddressUPD2", null, false);

        ResponseEntity<ResultView> result = restTemplate.postForEntity(url + "/organization/update", organization, ResultView.class);
        assertNotNull(result);

        getTest(new OrganizationView(2, "testUPD2", "testTestUPD2", "111111111111",
                        "111111111","testAddressUPD2", "7916698773", false));

    }

    /**
     * Проверка получения списка организаций
     */
    @Test
    public void listTest(){


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationListView> httpEntity =
                new HttpEntity<>(new OrganizationListView(), headers);

        ParameterizedTypeReference<DataView<List<OrganizationListView>>> reference =
                new ParameterizedTypeReference<DataView<List<OrganizationListView>>>(){};

        ResponseEntity<DataView<List<OrganizationListView>>> response = restTemplate.exchange(url + "/organization/list", HttpMethod.POST, httpEntity, reference);
        assertNotNull(response);
        assertNotNull(response.getBody());

        DataView<List<OrganizationListView>> dataView = response.getBody();
        assertNotNull(dataView);
        assertNotNull(dataView.data);

        for(OrganizationListView view : dataView.data){
            assertEquals(view.id, getId(view));
        }

    }
    /**
     * Получение по идентификатору
     * @param organization - объект для проверки полученых данных
     */
    public void getTest(OrganizationView organization){

        ParameterizedTypeReference<DataView<OrganizationView>> reference =
                new ParameterizedTypeReference<DataView<OrganizationView>>(){};

        ResponseEntity<DataView<OrganizationView>> response =
                restTemplate.exchange(url + "/organization/" + organization.id, HttpMethod.GET, null,reference );
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertThat(response.getBody().data, instanceOf(OrganizationView.class));

        DataView<OrganizationView> responseData = response.getBody();
        assertNotNull(responseData);
        assertNotNull(responseData.data);

        assertThat(responseData.data.id, is(organization.id));
        assertThat(responseData.data.name, is(organization.name));
        assertThat(responseData.data.fullName, is(organization.fullName));
        assertThat(responseData.data.inn, is(organization.inn));
        assertThat(responseData.data.kpp, is(organization.kpp));
        assertThat(responseData.data.address, is(organization.address));
        assertThat(responseData.data.phone, is(organization.phone));
        assertThat(responseData.data.isActive, is(organization.isActive));

    }

    /**
     * Получение идентификатора организации из списка по фильтру
     * @param view - фильтр
     * @return id - идентификатор организации
     */
    public Integer getId(OrganizationListView view){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationListView> httpEntity =
                new HttpEntity<>(view, headers);

        ParameterizedTypeReference<DataView<List<OrganizationListView>>> reference =
                new ParameterizedTypeReference<DataView<List<OrganizationListView>>>(){};

        ResponseEntity<DataView<List<OrganizationListView>>> response = restTemplate.exchange(url + "/organization/list", HttpMethod.POST, httpEntity, reference);
        assertNotNull(response);
        assertNotNull(response.getBody());

        DataView<List<OrganizationListView>> dataView = response.getBody();
        assertNotNull(dataView);
        assertThat(dataView.data.size(), is(1));

        Integer id = dataView.data.get(0).id;

        return id;
    }

}
