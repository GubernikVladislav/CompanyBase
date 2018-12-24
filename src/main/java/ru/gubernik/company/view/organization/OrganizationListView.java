package ru.gubernik.company.view.organization;

/**
 * Предствление для списка организаций
 */
public class OrganizationListView {

    /**
     * Идентификатор
     */
    public Integer id;

    /**
     * Наименование
     */

    public String name;

    public String inn;
    /**
     * Статус
     */
    public Boolean isActive;

    public OrganizationListView(){

    }

    public OrganizationListView(String name, String inn, Boolean isActive){
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }
}
