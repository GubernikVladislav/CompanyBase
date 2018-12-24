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

    public UserListRequestView(){

    }

    public UserListRequestView(Integer officeId, String firstName,
                               String lastName, String middleName, String position,
                               String docCode, String citizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
    }

    @Override
    public String toString(){
        return "{" +
                "\"officeId\":" + officeId + "," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"middleName\":\"" + middleName + "\"," +
                "\"position\":\"" + position + "\"," +
                "\"docCode\":\"" + docCode + "\"," +
                "\"citizenshipCode\":\"" + citizenshipCode + "\"}";
    }
}
