package ru.gubernik.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Модель страны
 */
@Entity
public class Country {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Код страны
     */
    @Column(length = 3, nullable = false)
    private String code;

    /**
     * Название страны
     */
    @Column(length = 255, nullable = false)
    private String name;

    /**
     * Связь с таблицей User
     */
    @OneToMany(mappedBy = "country",
            fetch = FetchType.LAZY)
    private List<User> users;

    public Country(){

    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
