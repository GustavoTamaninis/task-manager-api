package com.example.first_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // identificá-lo para que possa ser interpretado como uma entidade de db.
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // identifica que esse código ("id") será gerado pelo próprio SGBD.
    // Poderia ter utilizado GenerationType.ENTITY também.
    private Long id; // não foi utilizado um tipo primitivo, pois o id pode ser "null".
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
