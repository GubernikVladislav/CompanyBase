package ru.gubernik.company.view;

/**
 * Представление текста исключения
 */
public class ErrorView {

    /**
     * Поле текста исключения
     */
    public String error;

    /**
     * Передача текста исключения
     * @param errorText - текс исключения
     */
    public ErrorView(String errorText){
        error = errorText;
    }
}
