package ru.gubernik.company.dao.document;

import ru.gubernik.company.model.Document;

import java.util.List;

/**
 * Dao для работы со справочником документов
 */
public interface DocumentDao {

    /**
     * Получение списка типов документов
     * @return список типов документов
     */
    List<Document> docs();
}
