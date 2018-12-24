package ru.gubernik.company.view.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.Document;
import ru.gubernik.company.model.Office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotNull(message = "firstName cannot be null")
    @Size(max = 50)
    public String firstName;

    /**
     * Фамилия
     */
    @Size(max = 50)
    public String lastName;

    /**
     * Отчество
     */
    public String middleName;

    /**
     * Должность
     */
    @NotNull(message = "position cannot be null")
    @Size(max = 50)
    public String position;

    /**
     * Документ
     */
    @JsonIgnore
    public Document document;

    @Pattern(regexp = "\\d{0,2}", message = "invalid docCode")
    public String docCode;

    /**
     * Название документа
     */
    public String docName;

    /**
     * Номер документа
     */
    @Size(max = 20)
    @Pattern(regexp = "\\d{0,20}", message = "invalid docNumber")
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
