package ru.gubernik.company.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gubernik.company.dao.country.CountryDao;
import ru.gubernik.company.dao.document.DocTypeDao;
import ru.gubernik.company.dao.office.OfficeDao;
import ru.gubernik.company.dao.user.UserDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.Office;
import ru.gubernik.company.model.User;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.user.UserListRequestView;
import ru.gubernik.company.view.user.UserListView;
import ru.gubernik.company.view.user.UserView;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    private final MapperFacade mapperFacade;
    private final UserDao userDao;
    private final OfficeDao officeDao;
    private final CountryDao countryDao;
    private final DocTypeDao docTypeDao;

    @Autowired
    public UserServiceImpl(MapperFacade mapperFacade, UserDao userDao, OfficeDao officeDao, CountryDao countryDao, DocTypeDao docTypeDao) {
        this.mapperFacade = mapperFacade;
        this.userDao = userDao;
        this.officeDao = officeDao;
        this.countryDao = countryDao;
        this.docTypeDao = docTypeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataView users(UserListRequestView view) {

        User user = mapperFacade.map(view, User.class);

        return new DataView<>(mapperFacade.mapAsList(userDao.users(user, view.officeId, view.docCode, view.citizenshipCode), UserListView.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public DataView get(Integer id) {
        User user = userDao.get(id);
        UserView view = mapperFacade.userMap(user, UserView.class);
        DataView<UserView> data = new DataView<UserView>(view);
        return data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView update(UserView view) {

        User user = userDao.get(view.id);
        mapperFacade.userViewMap(view, user);

        userDao.update(user);
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView save(UserView view) {

        Office office = officeDao.get(view.officeId);
        Country country = countryDao.get(view.citizenshipCode);

        User user = mapperFacade.userViewMap(view, User.class);
        user.setOffice(office);
        user.setCountry(country);
        user.getDocument().setDocType(docTypeDao.get(view.docCode));

        userDao.save(user);
        return new ResultView();
    }
}
