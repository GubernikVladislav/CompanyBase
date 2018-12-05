package ru.gubernik.company.view.document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление документа в виде JSON
 */
public class DocumentView {

    /**
     * Код документа
     */
    @NotNull(message = "code cannot be null")
    @Size(max = 2)
    public String code;

    /**
     * Наименование документа
     */
    @NotNull(message = "name cannot be null")
    @Size(max = 255)
    public String name;

    @Override
    public String toString(){
        return "{name:" + name + ";code:" + code + "}";
    }
}
