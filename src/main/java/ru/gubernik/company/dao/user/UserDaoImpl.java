package ru.gubernik.company.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gubernik.company.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> users(User user) {
        return null;
    }

    @Override
    public User get(Integer id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void save(User user) {

    }
}
