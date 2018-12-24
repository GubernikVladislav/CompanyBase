package ru.gubernik.company.dao.document;

import ru.gubernik.company.model.DocType;
import ru.gubernik.company.model.Document;

import java.util.List;

/**
 * Dao для работы со справочником документов
 */
public interface DocTypeDao {

    /**
     * Получение списка типов документов
     * @return список типов документов
     */
    List<DocType> docs();

    DocType get(String docCode);
}
