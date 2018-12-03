package ru.gubernik.company.view.organization;

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
    public String name;

    /**
     * Полное наименоваение организации
     */
    public String fullName;

    /**
     * ИНН организации
     */
    public String inn;

    /**
     * КПП организации
     */
    public String kpp;

    /**
     * Адресс организации
     */
    public String address;

    /**
     * Телефон организации
     */
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
