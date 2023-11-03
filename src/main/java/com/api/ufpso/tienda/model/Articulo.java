package com.api.ufpso.tienda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "idCategory", referencedColumnName = "id")
    private Categoria categoria;


}
