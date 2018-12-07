package ru.gubernik.company.service.document;

import ru.gubernik.company.view.document.DocumentView;
import ru.gubernik.company.view.source.DataView;

import java.util.List;

/**
 * Сервис справочника документов
 */
public interface DocumentService {

    /**
     * Получение справочника документов
     * @return возвращает список типов документов
     */
    DataView docs();
}
