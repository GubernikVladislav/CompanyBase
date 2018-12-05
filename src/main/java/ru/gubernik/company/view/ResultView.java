package ru.gubernik.company.view;

/**
 * Представление сообщения результата
 */
public class ResultView {

    private final String RESULT = "success";

    @Override
    public String toString(){
        return "{result:" + RESULT + "}";
    }
}
