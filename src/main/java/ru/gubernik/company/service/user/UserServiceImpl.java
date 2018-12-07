package ru.gubernik.company.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gubernik.company.dao.user.UserDao;
import ru.gubernik.company.mapper.MapperFacade;
import ru.gubernik.company.model.User;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

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
    public DataView users(UserView view) {

        User user = mapperFacade.map(view, User.class);
        List<User> users = userDao.users(user);
        List<UserView> views = mapperFacade.mapAsList(users, UserView.class);
        return new DataView<List<UserView>>(views);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataView get(Integer id) {
        return new DataView<UserView>(mapperFacade.map(userDao.get(id), UserView.class));
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
