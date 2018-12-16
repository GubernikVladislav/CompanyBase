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
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ErrorView;
import ru.gubernik.company.view.source.ResultView;

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

        OrganizationView request = new OrganizationView("test", "TestTest", "123456777890", "123456788", "adress");

        ResponseEntity response = restTemplate.postForEntity(url + "/organization/save", request, ResultView.class);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

    }

    /**
     * Проверка на неправильнное сохранение организации.
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
        request = new OrganizationView("test", "TestTest", "123456777u90", "111u11111", "adress");
        response = restTemplate.postForEntity(url + "/organization/save", request, ErrorView.class);
        assertNotNull(response);
        assertEquals(response.getStatusCodeValue(), 200);
        error = (ErrorView) response.getBody();
        assertThat(error.error, containsString("only numbers"));
    }

    /**
     * Проверка получения организации по идентификатору
     */
    @Test
    public void getTest(){

        ParameterizedTypeReference<DataView<OrganizationView>> reference =
                new ParameterizedTypeReference<DataView<OrganizationView>>(){};

        ResponseEntity<DataView<OrganizationView>> response = restTemplate.exchange(url + "/organization/1", HttpMethod.GET, null,reference );
        Assert.assertNotNull(response);

        DataView<OrganizationView> responseData = response.getBody();
        assertNotNull(responseData);
        assertThat(responseData.data.id, is(1));
        assertThat(responseData.data.name, is("Органихация"));
        assertThat(responseData.data.fullName, is("Тестовая Организация"));
        assertThat(responseData.data.inn, is("123456789112"));
        assertThat(responseData.data.kpp, is("123456789"));
        assertThat(responseData.data.address, is("Москва, ул.Домодедовская, д12б "));
        assertThat(responseData.data.phone, is("7495999999"));
        assertThat(responseData.data.isActive, is(true));

    }


}
