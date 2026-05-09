package com.oswaldo.curso.java.springboot.backend.entities;

import jakarta.persistence.*;
/**
 * @author Oswaldo de los Santos
 * @version 1.0
 * @since 1.0
 * @see <a href="https://www.udemy.com/course/master-completo-java-de-cero-a-experto/learn/lecture/47466539?start=405#overview"> Sesión 82 </a>
 * */

@Entity
@Table(name = "products")
public class Product {
    /**
     * Atributos que contiene la base de datos, de la tabla: products
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
