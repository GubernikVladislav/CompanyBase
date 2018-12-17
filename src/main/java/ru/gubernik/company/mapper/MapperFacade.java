package ru.gubernik.company.mapper;

import ru.gubernik.company.model.User;
import ru.gubernik.company.view.user.UserView;

import java.util.List;

/**
 * Фасад для преобразования моделей БД к типам View
 */
public interface MapperFacade {

    /**
     * Приведение обьекта к заданному классу
     * @param object приводимый обьект
     * @param target класс, к которому привеодится обьект
     * @param <O> тип object
     * @param <T> тип target
     * @return возарвщает object приведенный к классу target
     */
    <O, T> T map(O object, Class<T> target);

    /**
     * Запись параметров из object в target
     * @param object объект с новыми параметрами
     * @param target объект в который записываются параметры
     * @param <O> класс объекта object
     * @param <T> класс объекта target
     */
    <O, T> void map(O object, T target);
    /**
     * Преобразование списка обьектов к заданному классу
     * @param list список объектов
     * @param target класс, к которому приводятся объекты
     * @param <L> тип объектов списка list
     * @param <T> тип объектов target
     * @return возарвщает список объектов типа target
     */
    <L, T> List<T> mapAsList(Iterable<L> list, Class<T> target);

    /**
     * Кастомное преобразование User к UserView
     * @param user
     * @param view
     * @return
     */
    UserView userMap(User user, Class<UserView> view);


    User userViewMap(UserView view, Class<User> user);

}
