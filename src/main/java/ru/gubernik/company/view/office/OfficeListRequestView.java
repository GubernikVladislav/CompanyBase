package ru.gubernik.company.view.office;

import com.sun.org.apache.regexp.internal.RE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Представление запроса списка оффисов
 */
public class OfficeListRequestView {

    /**
     * Идентификатор организации
     */
    @NotNull(message = "Id cannot be null")
    public Integer orgId;

    /**
     * Наименование офиса
     */
    public String name;

    /**
     * Телефон офиса
     */
    @Pattern(regexp = "\\d{0,20}", message = "phone must have only numbers")
    public String phone;

    /**
     * Статус офиса
     */
    public Boolean isActive;
}
