package ru.gubernik.company.view.organization;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @Max(12)
    @Min(12)
    @NotNull(message = "inn cannot be null")
    public String inn;

    /**
     * КПП организации
     */
    @Max(9)
    @Min(9)
    @NotNull(message = "kpp cannot be null")
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
    @Max(20)
    public String phone;

    /**
     * Состояние организации
     */
    public Boolean isActive;

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
}
