package ru.gubernik.company.view.organization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Представление организации в виде JSON
 */
public class OrganizationView {

    /**
     * Идентификатор организации
     */
    public Integer id;

    /**
     * Наименование организации
     */
    @Size(max = 30)
    @NotNull(message = "name cannot be null")
    public String name;

    /**
     * Полное наименоваение организации
     */
    @Size(max = 50)
    @NotNull(message = "fullName cannot be null")
    public String fullName;

    /**
     * ИНН организации
     */
    @Size(max = 12)
    @Size(min = 12)
    @NotNull(message = "inn cannot be null")
    @Pattern(regexp = "\\d{12}", message = "inn may contain only numbers")
    public String inn;

    /**
     * КПП организации
     */
    @Size(max = 9)
    @Size(min = 9)
    @NotNull(message = "kpp cannot be null")
    @Pattern(regexp = "\\d{9}", message = "kpp may contain only numbers")
    public String kpp;

    /**
     * Адресс организации
     */
    @Size(max = 255)
    @NotNull(message = "address cannot be null")
    public String address;

    /**
     * Телефон организации
     */
    @Size(max = 20)
    @Pattern(regexp = "\\d{0,20}", message = "phone may contain only numbers")
    public String phone;

    /**
     * Состояние организации
     */
    public Boolean isActive;

    public OrganizationView(){

    }

    public OrganizationView(Integer id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    /**
     * Переопределение метода Object.toString()
     * @return возвращает строку в виде JSON
     */
    @Override
    public String toString(){
        return "{id:" + id +
                ";name:" + name +
                ";full_name:" + fullName +
                ";inn:" + inn +
                ";kpp:" + kpp +
                ";address:" + address +
                ";phone:" + phone +
                ";is_active:" + isActive + "}";
    }

    public Integer getId(){
        return id;
    }
}
