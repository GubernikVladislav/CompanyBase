package ru.gubernik.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Модель документа
 */
@Entity
@Table(name = "Doc_type")
public class DocType {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Код документа
     */
    @Column(name = "code")
    private String code;

    /**
     * Наименование документа
     */
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "docType",
                fetch = FetchType.LAZY)
    private List<Document> documentList;

    public DocType(){

    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
