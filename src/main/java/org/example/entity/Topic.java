package org.example.entity;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Topic {


    @Id
    private String id;
    private String description;
    private String name;

    public Topic(){}

    public Topic(String id, String name,String description) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
