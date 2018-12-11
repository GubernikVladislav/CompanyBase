package ru.gubernik.company.view.user;

import javax.validation.constraints.NotNull;

/**
 * Представление параметров поиска списка пользователей
 */
public class UserListRequestView {

    /**
     * Идентификтор офиса
     */
    @NotNull(message = "officeId cannot be null")
    public Integer officeId;

    /**
     * Имя
     */
    public String firstName;

    /**
     * Фамилия
     */
    public String lastName;

    /**
     * Отчество
     */
    public String middleName;

    /**
     * Должность
     */
    public String position;

    /**
     * Тип документа
     */
    public String docCode;

    /**
     * Гражданство
     */
    public String citizenshipCode;
}
