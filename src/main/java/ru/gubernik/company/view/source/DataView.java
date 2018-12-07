package ru.gubernik.company.view.source;

/**
 * Представление данных HTTP ответа
 * @param <T>
 */
public class DataView<T> {

    /**
     * Объект данных
     */
    public Object data;

    public DataView(T object) {
        data = object;
    }

}
