package com.zaragon256.compendium;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Creature {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String type;

    Creature() {}

    Creature(String name, String type) {

        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Creature))
            return false;
        Creature creature = (Creature) o;
        return Objects.equals(this.id, creature.id) && Objects.equals(this.name, creature.name)
                && Objects.equals(this.type, creature.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.type);
    }

    @Override
    public String toString() {
        return "Creature{" + "id=" + this.id + ", name='" + this.name + '\'' + ", type='" + this.type + '\'' + '}';
    }
}
