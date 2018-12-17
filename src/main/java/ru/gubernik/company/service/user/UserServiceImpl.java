package ru.gubernik.company.service.user;

import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.user.UserDao;
import ru.gubernik.company.mapper.MapperFacade;
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

    @Autowired
    public UserServiceImpl(MapperFacade mapperFacade, UserDao userDao) {
        this.mapperFacade = mapperFacade;
        this.userDao = userDao;
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
    public ResultView update(UserView view) {

        userDao.update(mapperFacade.map(view, User.class));
        return new ResultView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView save(UserView view) {

        userDao.save(mapperFacade.map(view, User.class));
        return new ResultView();
    }
}
