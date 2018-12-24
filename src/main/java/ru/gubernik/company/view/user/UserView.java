package ru.gubernik.company.view.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.gubernik.company.model.Country;
import ru.gubernik.company.model.Document;
import ru.gubernik.company.model.Office;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Представление пользователя
 */
public class UserView {


    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Идентификтор
     */
    public Integer id;

    @JsonIgnore
    public Office office;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    public UserView(Integer officeId, String firstName, String lastName, String middleName, String position,
                    String docCode, String docName, String docNumber, String docDate, String citizenshipName,
                    String citizenshipCode, Boolean isIdentified) throws ParseException {

        this.docDate = format.parse(docDate);

        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    @Override
    public String toString(){

        return "{" +
                "\"id\":" + id + "," +
                "\"officeId\":" + officeId + "," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"middleName\":\"" + middleName + "\"," +
                "\"position\":\"" + position + "\"," +
                "\"docCode\":\"" + docCode + "\"," +
                "\"docNumber\":\"" + docNumber + "\"," +
                "\"docDate\":\"" + format.format(docDate) + "\"," +
                "\"citizenshipCode\":\"" + citizenshipCode + "\"," +
                "\"isIdentified\":" + isIdentified + "}";
    }

}
