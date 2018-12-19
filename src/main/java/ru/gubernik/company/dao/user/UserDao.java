package ru.gubernik.company.dao.user;

import ru.gubernik.company.model.User;

import java.util.List;

/**
 * Dao для работы с таблице пользователя
 */
public interface UserDao {

    /**
     * Получение списка пользователей
     * @param user объект пользователя
     * @return список пользователей
     */
    List users(User user, Integer officeId, String docCode, String citizenshipCode);

    /**
     * Получение пользователя по идентификатору
     * @param id идентификатор пользователя
     * @return пользователя
     */
    User get(Integer id);

    /**
     * Обновление пользователя
     * @param user объект пользователя с обновленными параметрами
     */
    void update(User user);

    /**
     * Добавление нового пользователя в БД
     * @param user объект пользователя добавляемый в БД
     */
    void save(User user);
}
