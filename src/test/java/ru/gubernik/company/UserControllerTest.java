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
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.user.UserListRequestView;
import ru.gubernik.company.view.user.UserListView;
import ru.gubernik.company.view.user.UserView;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Тестирование контроллера пользователей
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@Transactional
@DirtiesContext
public class UserControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8888/api/user";

    /**
     * Тестирование сохранения нового пользователя
     * @throws ParseException - ислючение бросает метод parse() в конструкторе UserView
     */
    @Test
    public void saveTest() throws ParseException {

        UserView request =
                new UserView(1, "testName", "testLastName", "testMiddleName",
                        "testPosition", "21", "Паспорт гражданина Российской Федерации",
                        "4614699999", "2018-07-10", "Российская Федерация",
                        "643", true );


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(request.toString(), headers);

                ResponseEntity<ResultView> response = restTemplate.exchange(url + "/save", HttpMethod.POST,httpEntity, ResultView.class);
        assertNotNull(response);

        request.id = getId(request);
        getTest(request);
    }

    /**
     * Тестирование обновления пользователя
     * @throws ParseException
     */
    @Test
    public void updateTest() throws ParseException{
        //Добавление нового пользователя
        UserView saveRequest =
                new UserView(1, "Name", "LastName", "MiddleName",
                        "Position", "21", "Паспорт гражданина Российской Федерации",
                        "4614699999", "2018-07-10", "Российская Федерация",
                        "643", true );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity saveEntity = new HttpEntity(saveRequest.toString(), headers);

        ResponseEntity<ResultView> saveResponse =
                restTemplate.exchange(url + "/save", HttpMethod.POST,saveEntity, ResultView.class);
        assertNotNull(saveResponse);

        saveRequest.id = getId(saveRequest);

        //Обновление добавленного пользователя
        UserView updateRequest =
                new UserView(1, "NameUPD", "LastNameUPD", "MiddleNameUPD",
                        "Position", "21", "Паспорт гражданина Российской Федерации",
                        "4614688888", "2018-07-11", "Российская Федерация",
                        "643", true );
        updateRequest.id = saveRequest.id;

        HttpEntity updateEntity = new HttpEntity(updateRequest.toString(), headers);

        ResponseEntity<ResultView> response =
                restTemplate.exchange(url + "/update", HttpMethod.POST,updateEntity, ResultView.class);

        assertNotNull(response);

    }

    /**
     * Тестирование получения пользователя по идентификатору
     * @param view
     */
    public void getTest(UserView view){

        ParameterizedTypeReference<DataView<UserView>> reference =
                new ParameterizedTypeReference<DataView<UserView>>(){};

        ResponseEntity<DataView<UserView>> response =
                restTemplate.exchange(url + "/" + view.id, HttpMethod.GET, null, reference);
        assertNotNull(response);
        DataView<UserView> responseData = response.getBody();
        assertNotNull(responseData);
        assertThat(responseData.data.id, is(view.id));
        assertThat(responseData.data.firstName, is(view.firstName));
        assertThat(responseData.data.lastName, is(view.lastName));
        assertThat(responseData.data.middleName, is(view.middleName));
        assertThat(responseData.data.position, is(view.position));
        assertThat(responseData.data.docName, is(view.docName));
        assertThat(responseData.data.docNumber, is(view.docNumber));
        assertThat(responseData.data.citizenshipName, is(view.citizenshipName));
        assertThat(responseData.data.isIdentified, is(view.isIdentified));
    }

    /**
     * Получение идентификатора пользователя из списка
     * @param view - объект с дынными фильтра списка
     * @return идентифитор пользователя
     */
    public Integer getId(UserView view){

        UserListRequestView request = new UserListRequestView(view.officeId, view.firstName, view.lastName, view.middleName,
                view.position, view.docCode, view.citizenshipCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(request.toString(), headers);

        ParameterizedTypeReference<DataView<List<UserListView>>> reference =
                new ParameterizedTypeReference<DataView<List<UserListView>>>(){};

        ResponseEntity<DataView<List<UserListView>>> response =
                restTemplate.exchange(url + "/list", HttpMethod.POST, httpEntity, reference);
        assertNotNull(response);

        DataView<List<UserListView>> responseData = response.getBody();
        assertNotNull(responseData);

        return responseData.data.get(0).id;
    }
}
