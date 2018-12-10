package ru.gubernik.company.view.office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление офиса
 */
public class OfficeView {

    /**
     * Идентификатор оффиса
     */
    public Integer id;

    public Integer orgId;
    /**
     * Наименование оффиса
     */
    @NotNull(message = "name cannot be null")
    @Size(max = 30)
    public String name;
    /**
     * Адресс оффиса
     */
    @NotNull(message = "address cannot be null")
    @Size(max = 255)
    public String address;
    /**
     * Телефон
     */
    @Size(max = 20)
    public String phone;
    /**
     * Статус оффиса
     */
    public Boolean isActive;

    @Override
    public String toString(){
        return "{id:" + id +
                ";name:" + name +
                ";address:" + address +
                ";phone:" + phone +
                ";is_active:" + isActive +
                "}";
    }

}
