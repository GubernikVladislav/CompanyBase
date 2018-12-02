package ru.gubernik.company.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.List;

/**
 * Организация
 */
@Entity
public class Organization {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование организации
     */
    @Column(nullable = false)
    private String name;

    /**
     * Полное наименование организации
     */
    @Column(name = "full_name", nullable = false)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(nullable = false)
    private String inn;

    /**
     * КПП организации
     */
    @Column(nullable = false)
    private String kpp;

    /**
     * Адресс
     */
    @Column(nullable = false)
    private String address;

    /**
     * Телефон
     */
    @Column
    private String phone;

    /**
     * Состоянии организации
     */
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    /**
     * Связь с таблицей оффисов
     */
    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Office> offices;

    /**
     * Конструктор для Hibernate
     */
    public Organization(){

    }

    /**
     * Конструктор для добавления организации, все поля NOT NULL
     * @param name наименование
     * @param fullName полное наименование
     * @param inn ИНН
     * @param kpp КПП
     * @param address адресс
     */
    public Organization(String name, String fullName, String inn, String kpp, String address){
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }
}
