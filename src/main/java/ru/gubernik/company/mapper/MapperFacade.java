package ru.gubernik.company.mapper;

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
     * Преобразование списка обьектов к заданному классу
     * @param list список объектов
     * @param target класс, к которому приводятся объекты
     * @param <L> тип объектов списка list
     * @param <T> тип объектов target
     * @return возарвщает список объектов типа target
     */
    <L, T> List<T> mapAsList(Iterable<L> list, Class<T> target);
}
