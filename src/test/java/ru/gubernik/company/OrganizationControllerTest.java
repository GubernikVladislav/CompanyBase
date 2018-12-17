package ru.gubernik.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


/**
 * Проверка контроллера органицзаций
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@DirtiesContext
@Transactional
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
                        "123456788", "adress", "9166987731", true);

        ResponseEntity response = restTemplate.postForEntity(url + "/organization/save", request, ResultView.class);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        getTest(request);

    }

    /**
     * Проверка на неправильнное сохранение организации. На выходе должна быть ошибка
     */
    @Test
    public void errorSaveTest() {
        //Добавление пустой организации
        OrganizationView request = new OrganizationView();
        ResponseEntity response = restTemplate.postForEntity(url + "/organization/save", request, ErrorView.class);
        assertNotNull(response);
        assertEquals(response.getStatusCodeValue(), 200);
        ErrorView error = (ErrorView) response.getBody();
        assertThat(error.error, containsString("cannot be null"));

        //Добавление организации с буквами в ИНН и КПП
        request = new OrganizationView(null, "test", "TestTest", "123456777u90", "111u11111", "adress", null, true);
        response = restTemplate.postForEntity(url + "/organization/save", request, ErrorView.class);
        assertNotNull(response);
        assertEquals(response.getStatusCodeValue(), 200);
        error = (ErrorView) response.getBody();
        assertThat(error.error, containsString("only numbers"));
    }

    /**
     * Проверка обновления организации
     */
    @Test
    public void updateTest(){

        OrganizationView organization =
                new OrganizationView(2, "testUPD", "testTestUPD", "111111111111",
                        "111111111","testAddresUPD", "7916698773", false);

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
                        "111111111","testAddresUPD2", null, false);

        ResponseEntity<ResultView> result = restTemplate.postForEntity(url + "/organization/update", organization, ResultView.class);
        assertNotNull(result);

        getTest(new OrganizationView(2, "testUPD2", "testTestUPD2", "111111111111",
                        "111111111","testAddresUPD2", "7916698773", false));

    }

    /**
     * Проверка получения списка организаций
     */
    @Test
    public void listTest(){

        ParameterizedTypeReference<DataView<List<OrganizationListView>>> reference =
                new ParameterizedTypeReference<DataView<List<OrganizationListView>>>(){};

        ResponseEntity<DataView<List<OrganizationListView>>> response = restTemplate.exchange(url + "/organization/list", HttpMethod.POST, null, reference);
        assertNotNull(response);

        DataView<List<OrganizationListView>> dataView = response.getBody();
        assertThat(dataView.data.get(0).id, is(1));
        assertThat(dataView.data.get(1).id, is(2));
    }
    /**
     * Получение по идентификатору
     * @param organization - объект для проверки полученых данных
     */
    public void getTest(OrganizationView organization){

        ParameterizedTypeReference<DataView<OrganizationView>> reference =
                new ParameterizedTypeReference<DataView<OrganizationView>>(){};

        ResponseEntity<DataView<OrganizationView>> response = restTemplate.exchange(url + "/organization/2", HttpMethod.GET, null,reference );
        Assert.assertNotNull(response);

        DataView<OrganizationView> responseData = response.getBody();
        assertNotNull(responseData);
        assertThat(responseData.data.id, is(2));
        assertThat(responseData.data.name, is(organization.name));
        assertThat(responseData.data.fullName, is(organization.fullName));
        assertThat(responseData.data.inn, is(organization.inn));
        assertThat(responseData.data.kpp, is(organization.kpp));
        assertThat(responseData.data.address, is(organization.address));
        assertThat(responseData.data.phone, is(organization.phone));
        assertThat(responseData.data.isActive, is(organization.isActive));

    }
}
