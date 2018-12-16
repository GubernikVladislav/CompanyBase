package ru.gubernik.company.view.source;

/**
 * Представление данных HTTP ответа
 * @param <T>
 */
public class DataView<T> {

    /**
     * Объект данных
     */
    public T data;

    public DataView(){

    }

    public DataView(T object) {
        data = object;
    }

}
