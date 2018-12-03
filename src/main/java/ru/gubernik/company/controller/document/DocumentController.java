package ru.gubernik.company.controller.document;

import ru.gubernik.company.view.document.DocumentView;

import java.util.List;

/**
 * Контроллер справочника документов
 */
public interface DocumentController {

    /**
     * Получение справочника документов
     * @return
     */
    List<DocumentView> docs();
}
