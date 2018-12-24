package ru.gubernik.company.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gubernik.company.view.source.ErrorView;

/**
 * Контроллер для обработки исключений
 */
@RestControllerAdvice
public class ExceptionController {

    /**
     * Обработка исключений
     * @param e тип исключения
     * @return представление с текстом ошибки
     */
    @ExceptionHandler
    public ErrorView checkException(Exception e){
        return new ErrorView(e.getMessage());
    }

}
