package ru.gubernik.company.view.country;

/**
 * Представление страны
 */
public class CountryView {

    /**
     * Название страны
     */
    public String name;

    /**
     * Код страны
     */
    public String code;

    @Override
    public String toString(){
        return "{name:" + name +
                ";code:" + code + "}";
    }
}
