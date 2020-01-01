package com.openclassrooms.entrevoisins.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Serializable {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Full name
     */
    private String name;

    /**
     * Avatar
     */
    private String avatarUrl;

    private String numeroVoisin;

    private String aProposDeMoi;


    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(Integer id, String name, String avatarUrl, String numeroVoisin, String aProposDeMoi) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.numeroVoisin = numeroVoisin;
        this.aProposDeMoi = aProposDeMoi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNumeroVoisin() {
        return this.numeroVoisin;
    }

    public void setNumeroVoisin(String numeroVoisin) {
        this.numeroVoisin = numeroVoisin;
    }

    public String getAProposDeMoi() {
        return this.aProposDeMoi;
    }

    public void setAProposDeMoi(String aProposDeMoi) {
        this.aProposDeMoi = aProposDeMoi;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
