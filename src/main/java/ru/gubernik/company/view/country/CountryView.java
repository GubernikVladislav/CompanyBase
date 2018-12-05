package ru.gubernik.company.view.country;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление страны
 */
public class CountryView {

    /**
     * Название страны
     */
    @NotNull(message = "name cannot be null")
    @Size(max = 255)
    public String name;

    /**
     * Код страны
     */
    @NotNull(message = "code cannot be null")
    @Size(max = 3)
    public String code;

    @Override
    public String toString(){
        return "{name:" + name +
                ";code:" + code + "}";
    }
}
