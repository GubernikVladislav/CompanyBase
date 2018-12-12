package ru.gubernik.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@Transactional
public class OrganizationControllerTest {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void notNullListTest(){
        DataView organization = restTemplate.getForObject("http://localhost:8888/api/organization/list", DataView.class);
        Assert.assertNotNull(organization);
    }

    @Test
    public void notNullGetTest(){
        DataView organizationView = restTemplate.getForObject("http://localhost:8888/api/organization/1", DataView.class);
        Assert.assertNotNull(organizationView);
    }

    @Test
    public void saveTest(){

        ResultView resultView = restTemplate.postForObject("http://localhost:8888/api/organization/save",
                "  \"name\":\"ban32\",\n" +
                        "  \"fullName\":\"ban3bank2\",\n" +
                        "  \"kpp\":\"111111113\",\n" +
                        "  \"inn\":\"111111223222\",\n" +
                        "  \"address\":\"moscow2\",\n" +
                        "  \"isActive\":false\n" +
                        "}", ResultView.class);
        Assert.assertNotNull(resultView);
    }

    @Test
    public void updateTest(){

        ResultView resultView = restTemplate.postForObject("http://localhost:8888/api/organization/update","{\n" +
                "  \"id\":1,\n" +
                "  \"name\":\"ban32\",\n" +
                "  \"fullName\":\"ban3bank2\",\n" +
                "  \"kpp\":\"111111113\",\n" +
                "  \"inn\":\"111111223222\",\n" +
                "  \"address\":\"moscow2\",\n" +
                "  \"isActive\":false\n" +
                "}", ResultView.class);
        Assert.assertNotNull(resultView);
    }

    @Test
    public void errorTest(){
        try {

            ResultView errorView = restTemplate.postForObject("http://localhost:8888/api/organization/update", "{\n" +
                    "  \"id\":1,\n" +
                    "  \"name\":\"ban32\",\n" +
                    "  \"fullName\":\"ban3bank2\",\n" +
                    "  \"kpp\":\"111111113\",\n" +
                    "  \"address\":\"moscow2\",\n" +
                    "  \"isActive\":false\n" +
                    "}", ResultView.class);
            Assert.assertNotNull(errorView);
        }catch (Exception e){
            Assert.assertThat(e.getMessage(), containsString("inn cannot be null"));
        }

        try {

            ResultView errorView = restTemplate.postForObject("http://localhost:8888/api/organization/save", "{\n" +
                    "  \"id\":1,\n" +
                    "  \"name\":\"ban32\",\n" +
                    "  \"address\":\"moscow2\",\n" +
                    "  \"isActive\":false\n" +
                    "}", ResultView.class);
            Assert.assertNotNull(errorView);
        }catch (Exception e){
            Assert.assertThat(e.getMessage(), containsString("cannot be null"));
        }
    }
}
