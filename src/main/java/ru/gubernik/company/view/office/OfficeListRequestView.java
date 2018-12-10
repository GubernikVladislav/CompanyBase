package ru.gubernik.company.view.office;

import javax.validation.constraints.NotNull;

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
    public String phone;

    /**
     * Статус офиса
     */
    public Boolean isActive;
}
