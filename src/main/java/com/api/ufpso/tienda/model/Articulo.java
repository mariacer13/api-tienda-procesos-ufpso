package com.api.ufpso.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name article is required")
    @Size(max = 255, message = "Name article max 255 characters")
    private String name;
    @NotBlank(message = "Description is required")
    @Size(max = 400, message = "lastname max 400 characters")
    private String description;
    @NotBlank(message = "Price is required")
    @Min(value= 0, message = "price > 0")
    private Double price;
    @NotBlank(message = "Stock is required")
    @Min(value= 0, message = "stock >= 0")
    private int stock;

    @ManyToOne()
    @JoinColumn(name = "id_category", referencedColumnName = "idCategory")
    private Categoria categoria;

    /*@JsonIgnore //Cuando genere una respuesta, ignore lo siguiente
    @OneToMany(mappedBy = "articulo")
    List<Categoria> categoriaList;*/
}
