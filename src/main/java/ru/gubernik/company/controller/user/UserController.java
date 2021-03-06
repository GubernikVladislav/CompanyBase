package ru.gubernik.company.controller.user;

import org.springframework.web.bind.annotation.RequestBody;
import ru.gubernik.company.view.source.DataView;
import ru.gubernik.company.view.source.ResultView;
import ru.gubernik.company.view.user.UserListRequestView;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

/**
 * Контроллер пользователя
 */
public interface UserController {

    /**
     * Получение списка пользователей оффиса
     * @param view - параметр считанный из HTTP запроса
     * @return список пользователей
     */
    DataView users(@RequestBody UserListRequestView view);

    /**
     * Получить пользователя по идентификатору
     * @param id - идентификатор пользователя
     * @return пользователя
     */
    DataView get(Integer id);

    /**
     * Обновить пользователя
     * @param view - параметр считанный из HTTP запроса
     * @return {"result":"seccess"}
     */
    ResultView update(@RequestBody UserView view);

    /**
     * Добавление нового пользователя
     * @param view
     * @return
     */
    ResultView save(@RequestBody UserView view);
}
