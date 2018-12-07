package ru.gubernik.company.controller.document;

import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

/**
 * Контроллер справочника документов
 */
public interface DocumentController {

    /**
     * Получение справочника документов
     * @return
     */
    DataView docs();
}
