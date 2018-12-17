package ru.gubernik.company.model;

import javax.persistence.CascadeType;
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
    private String docCode;

    /**
     * Наименование документа
     */
    @Column(name = "name")
    private String docName;

    @OneToMany(mappedBy = "docType",
                fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Document> documentList;

    public DocType(){

    }

    public Integer getId() {
        return id;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String code) {
        this.docCode = code;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String name) {
        this.docName = name;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
