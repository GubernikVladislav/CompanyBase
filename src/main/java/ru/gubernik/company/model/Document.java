package ru.gubernik.company.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * Документ пользователя
 */
@Entity
@Table(name = "Document")
public class Document {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "number", nullable = false, length = 20)
    private String docNumber;

    /**
     * Дата документа
     */
    @Column(name = "doc_date")
    @Temporal(TemporalType.DATE)
    private Date docDate;

    /**
     * Тип документа
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_type_id", nullable = false)
    private DocType docType;

    /**
     * Пользователь
     */
    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
    private User user;

    public Document(){

    }

    public Integer getId() {
        return id;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String number) {
        this.docNumber = number;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }
}
