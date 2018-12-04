package ru.gubernik.company.service.user;

import ru.gubernik.company.view.ResultView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

/**
 * Сервис пользователя
 */
public interface UserService {

    /**
     * Получение списка пользователя
     * @param view - обьект с параметрами поиска
     * @return список List пользователей по заданным параметрам
     */
    List<UserView> users(UserView view);

    /**
     * Получение пользователя по идентификатору
     * @param id - идентификатор пользователя
     * @return пользователя
     */
    UserView get(Integer id);

    /**
     * Обновление пользователя
     * @param view - объект с обновленными параметрами
     * @return {"result":"succes"}
     */
    ResultView update(UserView view);

    /**
     * Добавление нового пользователя
     * @param view добавляемый объект пользователя
     * @return {"result":"succes}
     */
    ResultView save(UserView view);
}
