package ru.gubernik.company.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.persistence.JoinColumn;

/**
 * Оффис
 */
@Entity
public class Office {

    /**
     * Уникальный идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    /**
     * Служебное поле Hibernate
     */
    @Version
    private Integer version;

    /**
     * Наименование офиса
     */
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    /**
     * Адресс
     */
    @Column(nullable = false, length = 255)
    private String address;

    /**
     * Телефон
     */
    @Column(length = 20)
    private String phone;

    /**
     * Статус офиса
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Связь с таблицей организаций
     */
    @ManyToOne
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    /**
     * Конструктор для Hibernate
     */
    public Office(){

    }

    /**
     * Конструктор для добавления оффиса, все поля NOT NULL
     * @param name наименование оффиса
     * @param address адресс
     */
    public Office( String name, String address){
        this.name = name;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Integer getOrgId(){
        return organization.getId();
    }

}
