package ru.gubernik.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.controller.organization.OrganizationControllerImpl;
import ru.gubernik.company.view.organization.OrganizationListView;
import ru.gubernik.company.view.source.DataView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@Transactional
public class OrganizationControllerTest {


}
