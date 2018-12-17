package ru.gubernik.company.view.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.Document;
import ru.gubernik.company.model.Office;

import java.util.Date;

/**
 * Представление пользователя
 */
public class UserView {

    /**
     * Идентификтор
     */
    public Integer id;

    @JsonIgnore
    public Office office;

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
     * Документ
     */
    @JsonIgnore
    public Document document;

    public String docCode;

    /**
     * Название документа
     */
    public String docName;

    /**
     * Номер документа
     */
    public String docNumber;

    /**
     * Дата документа
     */
    public Date docDate;

    /**
     * Страна
     */
    @JsonIgnore
    public Country country;

    /**
     * Название страны
     */
    public String citizenshipName;

    /**
     * Код страны
     */
    public String citizenshipCode;

    /**
     * Статус
     */
    public Boolean isIdentified;

    public UserView(){

    }
}
