package ru.gubernik.company.view.source;

/**
 * Представление сообщения результата
 */
public class ResultView {

    public String result = "success";

    @Override
    public String toString(){
        return "{result:" + result + "}";
    }
}
