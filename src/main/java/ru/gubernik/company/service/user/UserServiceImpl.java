package ru.gubernik.company.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gubernik.company.dao.office.OfficeDao;
import ru.gubernik.company.dao.user.UserDao;
import ru.gubernik.company.mapper.MapperFacade;
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

    @Autowired
    public UserServiceImpl(MapperFacade mapperFacade, UserDao userDao, OfficeDao officeDao) {
        this.mapperFacade = mapperFacade;
        this.userDao = userDao;
        this.officeDao = officeDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView users(UserListRequestView view) {

        User user = mapperFacade.map(view, User.class);

        return new DataView<>(mapperFacade.mapAsList(userDao.users(user, view.officeId, view.docCode, view.citizenshipCode), UserListView.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        User getUser = mapperFacade.userViewMap(view, User.class);
        mapperFacade.map(getUser, user);
        getUser.setOffice(officeDao.get(user.getOffice().getId()));

        userDao.update(getUser);
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView save(UserView view) {

        Office office = officeDao.get(view.officeId);
        User user = mapperFacade.userViewMap(view, User.class);
        user.setOffice(office);

        userDao.save(user);
        return new ResultView();
    }
}
