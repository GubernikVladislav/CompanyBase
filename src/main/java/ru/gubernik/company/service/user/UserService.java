package ru.gubernik.company.service.user;

import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.user.UserListRequestView;
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
    DataView users(UserListRequestView view);

    /**
     * Получение пользователя по идентификатору
     * @param id - идентификатор пользователя
     * @return пользователя
     */
    DataView get(Integer id);

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
