package ru.gubernik.company;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.gubernik.company.controller.organization.OrganizationController;
import ru.gubernik.company.dao.organization.OrganizationDao;
import ru.gubernik.company.model.Organization;
import ru.gubernik.company.view.organization.OrganizationView;
import ru.gubernik.company.view.source.DataView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CompanyBaseApplication.class})
@Transactional
@DirtiesContext
public class OrganizationControllerTest {

    @Autowired
    private OrganizationController controller;

    @Test
    public void organizationTest() {

    }
}
