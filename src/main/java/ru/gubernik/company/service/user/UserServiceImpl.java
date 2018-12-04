package ru.gubernik.company.service.user;

import org.springframework.stereotype.Service;
import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserView> users(UserView view) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserView get(Integer id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView update(UserView view) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultView save(UserView view) {
        return null;
    }
}
