package ru.gubernik.company.service.document;

import ru.gubernik.company.view.document.DocumentView;

import java.util.List;

/**
 * Сервис справочника документов
 */
public interface DocumentService {

    /**
     * Получение справочника документов
     * @return возвращает список типов документов
     */
    List<DocumentView> docs();
}
